package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.DTO.UserDTO;

import java.util.Set;

public interface UserService {
    Set<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    void addNewUser(UserDTO userDTO);
    void updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
