package lk.ijse.micro_service.vehicle_service.controller;

import lk.ijse.micro_service.vehicle_service.dto.VehicleDTO;
import lk.ijse.micro_service.vehicle_service.entity.Vehicle;
import lk.ijse.micro_service.vehicle_service.repository.VehicleRepository;
import lk.ijse.micro_service.vehicle_service.service.VehicleService;
import lk.ijse.micro_service.vehicle_service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseUtil save(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.createVehicle(vehicleDTO);
        return new ResponseUtil("200","SuccessFully saved vehicle",null);
    }
    @GetMapping
    public ResponseUtil getAllVehicles() {
        return new ResponseUtil("200","SuccessFully fetch all vehicle",vehicleService.getAllVehicles());
    }

    @GetMapping(params = "vehicleId" ,path = "/getVehicle")
    public ResponseUtil getVehicleById(@RequestParam("vehicleId") String vehicleId) {
        return new ResponseUtil("200","SuccessFully fetch  vehicle",vehicleService.getVehicleById(vehicleId));

    }
    @PostMapping
    public ResponseUtil update(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseUtil("200","SuccessFully saved vehicle",null);
    }

    @DeleteMapping
    public ResponseUtil delete(@RequestBody String id){
        vehicleService.deleteVehicle(id);
        return new ResponseUtil("200","SuccessFully saved vehicle",null);
    }

}
