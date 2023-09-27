package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;

import java.util.Set;

public interface UserService {
    Set<CompanyUser> getAllUsers();
    CompanyUser getUserById(Long id);
    boolean addNewUser(UserDTO userDTO);
    void updateUser(Long id,UserDTO userDTO);
    boolean deleteUser(Long id);
}
