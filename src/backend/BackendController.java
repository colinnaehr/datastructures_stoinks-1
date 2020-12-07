package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BackendController {
    private RequestHandler handler;
    public ArrayList<Stock> data;

    public BackendController(){
        this.data = new ArrayList<>();
        this.handler = new RequestHandler();
    }

    public void fetchStocks(){
        data.clear();
        try {
            File tickersFile = new File("./src/backend/tickers.txt");
            Scanner reader = new Scanner(tickersFile);
            while (reader.hasNextLine()) {
                String ticker = reader.nextLine();
                Stock stonk = handler.getPrices(ticker);
                stonk.setTicker(ticker);
                System.out.println(stonk.getTicker());
                System.out.println(stonk.getTotalVolume());
                data.add(stonk);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No tickers.txt file found.");
            e.printStackTrace();
        }
    }

//    public ArrayList<Pair<String,Long>> volumeQuery(){
//        ArrayList<Pair<String,Long>> results;
//
//    }

}
