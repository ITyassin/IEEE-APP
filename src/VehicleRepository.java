import java.util.List;
public interface VehicleRepository {
    void save(Vehicle vehicle);

    Vehicle findById(String id);

    Vehicle findByPlateNumber(String plateNumber);

    List<Vehicle> findByDriverId(String driverId);

    List<Vehicle> findByType(VehicleType type);

    List<Vehicle> findAll();

    void deleteById(String id);

    boolean existsByPlateNumber(String plateNumber);
}
private Map<String, Vehicle> database = new HashMap<>();
@Override
public Vehicle findById(String id) {
    return database.get(id);
}
@Override
public void save(Vehicle vehicle) {
    database.put(vehicle.getId(), vehicle);
}

void main() {
}