package backend;

public class RequestTest {
    public static void main(String[] args) {
        RequestHandler handler = new RequestHandler();
        PriceResponse res = handler.getPrices("TSLA");
        System.out.println(res.getPrices().get(0).getHigh());
    }
}
