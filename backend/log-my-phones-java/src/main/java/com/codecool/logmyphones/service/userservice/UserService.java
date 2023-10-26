package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    ResponseEntity<Set<UserDTO>> getAllUsers();
    ResponseEntity<UserDTO> getUserById(String token);
    ResponseEntity<UserDTO> addNewUser(UserDTO userDTO);
    ResponseEntity<UserDTO> updateUser(String token, UserDTO userDTO);
    HttpStatus deleteUser(String token);
    UserDTO getUserByEmail(String email);
}
