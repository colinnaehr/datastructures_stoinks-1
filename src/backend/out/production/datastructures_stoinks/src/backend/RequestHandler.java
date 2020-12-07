package backend;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestHandler {
    private final String API_KEY = "c38dd0ab0fmsh23d79e093de2477p1fb600jsnf351e6af676a";
    public RequestHandler(){}

    public StockPrices getPrices(String ticker){
        var client = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://apidojo-yahoo-finance-v1.p.rapidapi.com/stock/v3/get-historical-data?symbol=%s&region=US&rapidapi-key=%s",ticker,this.API_KEY)))
                .GET()
                .build();
        try{
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), StockPrices.class);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

