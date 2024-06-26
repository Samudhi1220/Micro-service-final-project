package lk.ijse.micro_service.vehicle_service.service;

import lk.ijse.micro_service.vehicle_service.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehicleService {
    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(String id);
    void createVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String id);

    void updateVehicle(VehicleDTO vehicleDTO);
}
