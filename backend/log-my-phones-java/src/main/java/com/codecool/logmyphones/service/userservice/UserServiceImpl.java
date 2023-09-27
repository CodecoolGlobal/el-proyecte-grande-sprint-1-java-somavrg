package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;
import com.codecool.logmyphones.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void addNewUser(UserDTO userDTO) {
        userRepository.save(userDTO);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        CompanyUser userToUpdate = userRepository.getById(id);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
