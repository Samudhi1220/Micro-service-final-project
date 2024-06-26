package lk.ijse.microservice.userservice.controller;

import lk.ijse.microservice.userservice.dto.UserDTO;
import lk.ijse.microservice.userservice.repository.UserRepository;
import lk.ijse.microservice.userservice.service.UserService;
import lk.ijse.microservice.userservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseUtil save(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseUtil("200","SuccessFully saved vehicle",null);
    }
    @GetMapping
    public ResponseUtil getAllUsers() {
        return new ResponseUtil("200","SuccessFully fetch all vehicle",userService.getAllUsers());
    }

    @GetMapping(params = "userId" ,path = "/getUser")
    public ResponseUtil getUserById(@RequestParam("userId") String userId) {
        return new ResponseUtil("200","SuccessFully fetch  vehicle",userService.getUserById(userId));

    }
    @PostMapping
    public ResponseUtil update(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseUtil("200","SuccessFully saved vehicle",null);
    }

    @DeleteMapping
    public ResponseUtil delete(@RequestBody String id){
        userService.deleteUser(id);
        return new ResponseUtil("200","SuccessFully saved vehicle",null);
    }
}
