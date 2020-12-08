package backend;


public class RequestTest {
    public static void main(String[] args) {
        BackendController controller = new BackendController();
        controller.fetchStocks();
        System.out.println("    ");
//        var c = controller.volumeQuery(false,false);
//        for (int i = 0; i < 5; i++){
//            System.out.println(c.get(i).getKey());
//        }
        var r = controller.relativeStrength("6/31/2020",true,false,14);
        for (int i = 0; i < 5; i++){
            System.out.println(r.get(i).getKey());
            System.out.println(r.get(i).getValue());
        }
    }
}
