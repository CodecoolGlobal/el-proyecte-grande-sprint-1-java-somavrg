package com.codecool.logmyphones.service.userservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<Set<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(
                userMapper.toUserDTOs(userRepository.findAll().stream().collect(Collectors.toSet())),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) {
        return new ResponseEntity<>(userMapper.toUserDTO(userRepository.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> addNewUser(UserDTO newUserDTO) {
        CompanyUser user = userMapper.toCompanyUser(newUserDTO);
        user.setContacts(new HashSet<>());
        user.setDispatchers(new HashSet<>());
        userRepository.save(user);
        return new ResponseEntity<>(newUserDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO) {
        CompanyUser userToUpdate = userRepository.getById(id);
        return null;
    }

    @Override
    public HttpStatus deleteUser(Long id) {
        userRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    @Override
    public Optional<CompanyUser> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
