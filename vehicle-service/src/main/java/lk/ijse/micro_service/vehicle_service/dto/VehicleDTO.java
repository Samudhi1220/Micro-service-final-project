package lk.ijse.micro_service.vehicle_service.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    @Id

    private String id;

    private String licensePlateNumber;


    private String userId;
    private String model;
}
