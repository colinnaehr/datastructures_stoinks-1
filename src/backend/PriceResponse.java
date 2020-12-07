package backend;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceResponse {

    @SerializedName("prices")
    @Expose
    private List<DayPriceData> prices = null;

    public List<DayPriceData> getPrices() {
        return prices;
    }

    public void setPrices(List<DayPriceData> prices) {
        this.prices = prices;
    }

}