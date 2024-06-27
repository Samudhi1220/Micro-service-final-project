package lk.ijse.microservice.userservice.service.impl;

import lk.ijse.microservice.userservice.dto.UserDTO;
import lk.ijse.microservice.userservice.entity.User;
import lk.ijse.microservice.userservice.repository.UserRepository;
import lk.ijse.microservice.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepository.findAll(),new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public UserDTO getUserById(String id) {
        if (userRepository.existsById(id)){
            return modelMapper.map(userRepository.findById(id).get(),UserDTO.class);
        }else {
            throw new RuntimeException("User Id Not Found");
        }
    }

    @Override
    public void saveUser(UserDTO userDTO) {

    }

    @Override
    public void deleteUser(String id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else{
            throw new RuntimeException("User Not Found");
        }

    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public boolean existById(String id) {
        return userRepository.existsById(id);
    }
}
