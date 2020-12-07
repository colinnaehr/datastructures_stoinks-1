package backend;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BackendController {
    private RequestHandler handler;
    public ArrayList<Stock> data;

    public BackendController(){
        this.data = new ArrayList<>();
        this.handler = new RequestHandler();
    }

    public void fetchStocks(){
        System.out.println("Fetching...");
        data.clear();
        try {
            File tickersFile = new File("./src/backend/tickers.txt");
            Scanner reader = new Scanner(tickersFile);
            while (reader.hasNextLine()) {
                String ticker = reader.nextLine();
                try {
                    Stock stonk = handler.getPrices(ticker);
                    stonk.setTicker(ticker);
                    System.out.println(stonk.getTicker());
                    System.out.println(stonk.getTotalVolume());
                    data.add(stonk);
                } catch (Exception e){
                    System.out.println("Error");
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No tickers.txt file found.");
            e.printStackTrace();
        }
    }

    public ArrayList<Pair<String,Long>> volumeQuery(boolean priorityQueue){
        ArrayList<Pair<String,Long>> results = new ArrayList<>();
        if (priorityQueue){
            PriorityQueue<Stock> pq = new PriorityQueue<>(new StockComparator());
            pq.addAll(data);
            for (int i = 0; i < 5; i++){
                Stock top = pq.peek();
                assert top != null;
                results.add(new Pair<>(top.getTicker(),top.getTotalVolume()));
                pq.remove();
            }
            return results;
        } else {
            return null;
        }
    }

}

class StockComparator implements Comparator<Stock>{
    @Override
    public int compare(Stock s1, Stock s2){
        long s1v = s1.getTotalVolume();
        long s2v = s2.getTotalVolume();
        return Long.compare(s2v, s1v);
    }
}