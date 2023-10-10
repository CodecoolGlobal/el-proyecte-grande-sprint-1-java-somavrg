package com.codecool.logmyphones.authentication;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.RegisterUserDTO;
import com.codecool.logmyphones.model.UserRole;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public RegisterUserDTO register(RegisterUserDTO registerUserDTO) {
        CompanyUser newUser = CompanyUser.builder()
                .name(registerUserDTO.name())
                .email(registerUserDTO.email())
                .password(passwordEncoder.encode(registerUserDTO.password()))
                .role(UserRole.ADMIN)
                .build();

        userRepository.save(newUser);

        return registerUserDTO;
    }

}
