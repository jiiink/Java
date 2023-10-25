package prob2;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleManager() {}

    public void add(Vehicle v) {
        // for (Vehicle item : vehicles) {
        //     if (!item.equals(v)) {
        //         vehicles.add(v);
        //     }
        // }
        vehicles.add(v);
    }

    public int getCount() {
        return vehicles.size();
    }

    public String get(int i) {
        Vehicle target = null;
        int index = 0;
        for (Vehicle v : vehicles) {
            if (index == i) {
                target = v;
                break;
            }
            index++;
        }
        String msg = target.toString();
        return msg;
    }

    public int getTotalPrice() {
        int result = 0;
        for (Vehicle v : vehicles) {
            result += v.getPrice();
        }
        return result;
    }
}
