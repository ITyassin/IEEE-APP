import java.util.List;
public class VehicleManager{
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public VehicleManager(VehicleRepository vr, DriverRepository dr) {
        this.vehicleRepository = vr;
        this.driverRepository = dr;
    }
    public Vehicle registerVehicle(String driverId,String model, int year,String color ,String plateNumber,VehicleType type){
        if (vehicleRepository.existsByPlateNumber(plateNumber)) {
            throw new IllegalArgumentException("Plate number "+plateNumber+" isalready used ");
        }
        Vehicle newVehicle=new Vehicle(driverId,model,year,color,plateNumber,type);
        vehicleRepository.save(newVehicle);
        return newVehicle;
    }
    public Vehicle getVehicleById(String id){
        return vehicleRepository.findById(id);
    }
    public Vehicle getVehicleByPlateNumber(String plateNumber){
        return vehicleRepository.findByPlateNumber(plateNumber);
    }

    public List<Vehicle> getVehiclesByType(VehicleType type){
        return vehicleRepository.findByType(type);}



    public void removeVehicle(String vehicleId){
        vehicleRepository.deleteById(vehicleId);
      }
}



