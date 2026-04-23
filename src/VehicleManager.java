import java.util.List;


public class VehicleManager{
    private final VehicleRepository vehicleRepository;

    public VehicleManager(VehicleRepository vr) {
        this.vehicleRepository = vr;
    }
    public Vehicle registerVehicle(String driverId,String model, int year,String color ,String plateNumber,VehicleType type){
        if (vehicleRepository.existsByPlateNumber(plateNumber)) {
            throw new IllegalArgumentException("Plate number "+plateNumber+" isalready used ");
        }
        List<Vehicle> driverVehicles=vehicleRepository.findByDriverID(driverId);
        if(!driverVehicles.isEmpty() )
            throw new IllegalStateException("Driver ID: "+ driverId+" is already registered. ");
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



