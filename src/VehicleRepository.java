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
