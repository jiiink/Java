package prob2;

public class VehicleManagerTest {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        Car c1 = new Car("Kia", 2000, "Kim");
        Car c2 = new Car("Kia", 2000, "Kim");
        Ship s1 = new Ship("Hyundai", 1000000, 20);

        manager.add(c1);
        manager.add(c2);
        manager.add(s1);

        for (int i=0; i<manager.getCount(); i++) {
            System.out.println(manager.get(i));
        }

        System.out.println(manager.getTotalPrice());
    }
}
