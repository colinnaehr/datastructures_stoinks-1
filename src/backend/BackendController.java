package backend;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BackendController {
    private RequestHandler handler;
    public ArrayList<StockPrices> data;

    public void fetchStocks(){
        try {
            File tickersFile = new File("filename.txt");
            Scanner reader = new Scanner(tickersFile);
            while (reader.hasNextLine()) {
                String ticker = reader.nextLine();
                data.add(handler.getPrices(ticker));
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
