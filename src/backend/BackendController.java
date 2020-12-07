package backend;

import javafx.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BackendController {
    private final RequestHandler handler;
    private final ArrayList<Stock> stocks;

    public BackendController(){
        this.stocks = new ArrayList<>();
        this.handler = new RequestHandler();
    }

    public void fetchStocks(){
        System.out.println("Fetching...");
        stocks.clear();
        try {
            File tickersFile = new File("./src/backend/tickers.txt");
            Scanner reader = new Scanner(tickersFile);
            while (reader.hasNextLine()) {
                String ticker = reader.nextLine();
                try {
                    Stock stonk = handler.getPrices(ticker);
                    stonk.setTicker(ticker);
                    System.out.println(stonk.getTicker());
                    stocks.add(stonk);
                } catch (Exception e){
                    System.out.printf("Error, could not fetch stock ticker: %s%n",ticker);
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No tickers.txt file found.");
        }
    }

    public ArrayList<Pair<String,Long>> volumeQuery(boolean priorityQueue, boolean highest){
        ArrayList<Pair<String,Long>> results = new ArrayList<>();
        if (priorityQueue){
            PriorityQueue<Stock> pq;
            pq = highest ? new PriorityQueue<>(new StockTotalVolumeComparatorHigh()) : new PriorityQueue<>(new StockTotalVolumeComparatorLow());
            pq.addAll(stocks);
            for (int i = 0; i < 5; i++){
                Stock top = pq.peek();
                assert top != null;
                results.add(new Pair<>(top.getTicker(),top.getTotalVolume()));
                pq.remove();
            }
        } else {
            ArrayList<Stock> sortedData = stocks;
            sortedData.sort(new StockTotalVolumeComparatorHigh());
            if (highest){
                for (int i = 0; i < 5; i++){
                    Stock s = sortedData.get(i);
                    results.add(new Pair<>(s.getTicker(),s.getTotalVolume()));
                }
            } else {
                for (int i = sortedData.size() - 1; i > sortedData.size() - 6; i--){
                    Stock s = sortedData.get(i);
                    results.add(new Pair<>(s.getTicker(),s.getTotalVolume()));
                }
            }

        }
        return results;
    }

    private ArrayList<Pair<Long,Integer>> getRsiDatePairs(Stock stock, int rsiPeriod){
        var returned = new ArrayList<Pair<Long,Integer>>();
        for (int i = 0; i < 200 ; i++) {
            int extension = 0;
            double summedUpMoves = 0;
            double summedDownMoves = 0;
            int j = i;
            while (j < i + rsiPeriod + extension){
                if (stock.getPrices().get(j).getClose() == null){ break; }
                double recent = stock.getPrices().get(j).getClose();
                double dayBefore;
                if (stock.getPrices().get(j+1).getClose() != null){
                    dayBefore = stock.getPrices().get(j+1).getClose();
                } else {
                    extension++;
                    dayBefore = stock.getPrices().get(j+2).getClose();
                    j++;
                }
                double change = recent - dayBefore;
                if (change > 0){
                    summedUpMoves += change;
                } else if (change < 0){
                    summedDownMoves += Math.abs(change);
                }
                j++;
            }
            double avgUp = summedUpMoves / rsiPeriod;
            double avgDown = summedDownMoves / rsiPeriod;
            int rsi = (int) (100 - (100/(1+(avgUp/avgDown))));
            returned.add(new Pair<>((long)stock.getPrices().get(i).getDate(),rsi));
        }
        return returned;
    }

    public ArrayList<Pair<String,Integer>> relativeStrength(String date, boolean treeMap, boolean highest , int rsiPeriod) {
        date += " 9:30:00";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date d;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        long selectedDateSeconds = d.getTime() / 1000;


        if (treeMap){
            // tree map of tree maps
            var stockRSIs = new TreeMap<String,TreeMap<Long,Integer>>();
            // initially store time, rsi pairs for each stock
            for (Stock stock : stocks){
                System.out.println(stock.getTicker());
                TreeMap<Long,Integer> rsiDateMap = new TreeMap<>();
                for (Pair<Long,Integer> p : getRsiDatePairs(stock,rsiPeriod)){
                    rsiDateMap.put(p.getKey(),p.getValue());
                }
                stockRSIs.put(stock.getTicker(),rsiDateMap);
            }
            // calculate and sort using merge sort with Collections.sort()
            var stockRSIsAtTime = new ArrayList<Pair<String,Integer>>();
            for (Stock stock : stocks){
                int stockRsiAtTime = stockRSIs.get(stock.getTicker()).get(selectedDateSeconds);
                stockRSIsAtTime.add(new Pair<>(stock.getTicker(),stockRsiAtTime));
                stockRSIsAtTime.sort(new StockRSIComparator());
            }
            var returned = new ArrayList<Pair<String,Integer>>();
            for (int i = 0; i < 5; i++){
                returned.add(stockRSIsAtTime.get(i));
            }
            return returned;
        } else {


            // hash map of hash maps
            var stockRSIs = new HashMap<String,HashMap<Long,Integer>>();
            for (Stock stock : stocks){
                System.out.println(stock.getTicker());
                HashMap<Long,Integer> rsiDateMap = new HashMap<>();
                for (Pair<Long,Integer> p : getRsiDatePairs(stock,rsiPeriod)){
                    rsiDateMap.put(p.getKey(),p.getValue());
                }
                stockRSIs.put(stock.getTicker(),rsiDateMap);
            }
            // calculate and sort using merge sort with Collections.sort()
            var stockRSIsAtTime = new ArrayList<Pair<String,Integer>>();
            for (Stock stock : stocks){
                int stockRsiAtTime = stockRSIs.get(stock.getTicker()).get(selectedDateSeconds);
                stockRSIsAtTime.add(new Pair<>(stock.getTicker(),stockRsiAtTime));
                stockRSIsAtTime.sort(new StockRSIComparator());
            }
            var returned = new ArrayList<Pair<String,Integer>>();
            if (highest){
                for (int i = 0; i < 5; i++){
                    returned.add(stockRSIsAtTime.get(i));
                }
            } else {
                for (int i = stockRSIsAtTime.size() - 1; i > stockRSIsAtTime.size() - 6; i--){
                    returned.add(stockRSIsAtTime.get(i));
                }
            }
            return returned;
        }
    }
}

class StockRSIComparator implements Comparator<Pair<String,Integer>>{
    @Override
    public int compare(Pair<String,Integer> p1, Pair<String,Integer> p2){
        return Integer.compare(p2.getValue(), p1.getValue());
    }
}

class StockTotalVolumeComparatorHigh implements Comparator<Stock>{
    @Override
    public int compare(Stock s1, Stock s2){
        long s1v = s1.getTotalVolume();
        long s2v = s2.getTotalVolume();
        return Long.compare(s2v, s1v);
    }
}

class StockTotalVolumeComparatorLow implements Comparator<Stock>{
    @Override
    public int compare(Stock s1, Stock s2){
        long s1v = s1.getTotalVolume();
        long s2v = s2.getTotalVolume();
        return -(Long.compare(s2v, s1v));
    }
}