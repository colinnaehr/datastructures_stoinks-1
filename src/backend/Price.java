package backend;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("open")
    @Expose
    private Double open;
    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("close")
    @Expose
    private Double close;
    @SerializedName("volume")
    @Expose
    private Integer volume;
    @SerializedName("adjclose")
    @Expose
    private Double adjclose;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getAdjclose() {
        return adjclose;
    }

    public void setAdjclose(Double adjclose) {
        this.adjclose = adjclose;
    }
}
