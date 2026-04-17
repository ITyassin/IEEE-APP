import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class InMemoryVehicleRepository implements VehicleRepository{
    private Map<String, Vehicle> database = new HashMap<>();

    @Override
    public Vehicle findById(String id) {
        return database.get(id);
    }

    @Override
    public void save(Vehicle vehicle) {
        database.put(vehicle.getId(), vehicle);
    }
}

