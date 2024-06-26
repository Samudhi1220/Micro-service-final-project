package lk.ijse.micro_service.vehicle_service.repository;

import lk.ijse.micro_service.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
