package lk.ijse.microservice.userservice.service;

import lk.ijse.microservice.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    void saveUser(UserDTO vehicleDTO);

    void deleteUser(String id);

    void updateUser(UserDTO vehicleDTO);

    boolean existById(String id);
}
