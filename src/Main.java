
public class Main {
    public static void main(String []args) {

        Service service1 = new Service("Gardening", 10);
        System.out.println(service1.getName());
        System.out.println(service1.getCostPerHour());
        System.out.println(service1.toString());
    }
}