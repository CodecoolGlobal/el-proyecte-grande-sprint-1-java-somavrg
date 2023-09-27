package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.DTO.UserDTO;

import java.util.Set;

public interface UserService {
    Set<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    boolean addNewUser(UserDTO userDTO);
    void updateUser(Long id, UserDTO userDTO);
    boolean deleteUser(Long id);
}
