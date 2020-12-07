package backend;

import java.io.File;

public class RequestTest {
    public static void main(String[] args) {
        BackendController controller = new BackendController();
        controller.fetchStocks();
        System.out.println("    ");
        for (int i = 0; i < 5; i++){
            System.out.println(controller.volumeQuery(true).get(i).getKey());
        }

    }
}
