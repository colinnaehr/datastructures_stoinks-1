package backend;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockPrices {

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

}