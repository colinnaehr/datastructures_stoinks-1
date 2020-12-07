package backend;

import java.io.File;

public class RequestTest {
    public static void main(String[] args) {
        BackendController controller = new BackendController();
        System.out.println(new File(".").getAbsolutePath());
//        controller.fetchStocks();;

//        System.out.println(controller.data.get(0).getTotalVolume());
    }
}
