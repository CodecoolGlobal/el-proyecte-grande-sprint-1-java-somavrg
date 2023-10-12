package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    ResponseEntity<Set<UserDTO>> getAllUsers();
    ResponseEntity<UserDTO> getUserById(Long id);
    ResponseEntity<UserDTO> addNewUser(UserDTO userDTO);
    ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO);
    HttpStatus deleteUser(Long id);
    Optional<CompanyUser> getUserByEmail(String email);
}
