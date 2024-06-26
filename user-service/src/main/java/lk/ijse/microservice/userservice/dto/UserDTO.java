package lk.ijse.microservice.userservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @Id
    private String nic;
    private String name;
    private String contactNo;
}
