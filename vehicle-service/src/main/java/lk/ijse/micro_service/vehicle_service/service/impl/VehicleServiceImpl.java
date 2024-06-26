package lk.ijse.micro_service.vehicle_service.service.impl;

import lk.ijse.micro_service.vehicle_service.dto.VehicleDTO;
import lk.ijse.micro_service.vehicle_service.entity.Vehicle;
import lk.ijse.micro_service.vehicle_service.repository.VehicleRepository;
import lk.ijse.micro_service.vehicle_service.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<VehicleDTO> getAllVehicles() {
        return modelMapper.map(vehicleRepository.findAll(),new TypeToken<List<VehicleDTO>>(){}.getType());
    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        if (vehicleRepository.existsById(id)){
            return modelMapper.map(vehicleRepository.findById(id).get(),VehicleDTO.class);
        }else {
            throw new RuntimeException("Vehicle Id Not Found");
        }

    }

    @Override
    public void createVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepository.existsById(modelMapper.map(vehicleDTO,Vehicle.class).getId())){
            vehicleRepository.save(modelMapper.map(vehicleDTO, Vehicle.class));
        }else{
            throw new RuntimeException("Vehicle Id is already Exist");
        }

    }

    @Override
    public void deleteVehicle(String id) {
       if (vehicleRepository.existsById(id)){
           vehicleRepository.deleteById(id);
       }else{
           throw new RuntimeException("VehicleId Not Found");
       }

    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepository.existsById(modelMapper.map(vehicleDTO,Vehicle.class).getId())) {
            vehicleRepository.save(modelMapper.map(vehicleDTO,Vehicle.class));
        } else {
            throw new RuntimeException("Vehicle Not Found!");
        }
    }
}