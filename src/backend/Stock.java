package backend;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stock {

    private String ticker = "";

    @SerializedName("prices")
    @Expose
    private List<Price> prices = null;

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public long getTotalVolume(){
        long sum = 0;
        for (Price price : prices){
            if (price.getVolume() != null){
                sum += price.getVolume();
            }
        }
        return sum;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }
}