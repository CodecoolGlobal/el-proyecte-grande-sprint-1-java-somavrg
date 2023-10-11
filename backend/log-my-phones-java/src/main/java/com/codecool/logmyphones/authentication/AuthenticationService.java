package com.codecool.logmyphones.authentication;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserCredentialDTO;
import com.codecool.logmyphones.model.UserRole;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public UserCredentialDTO register(UserCredentialDTO userCredentialDTO) {
        CompanyUser newUser = CompanyUser.builder()
                .name(userCredentialDTO.name())
                .email(userCredentialDTO.email())
                .password(passwordEncoder.encode(userCredentialDTO.password()))
                .role(UserRole.ADMIN)
                .build();

        userRepository.save(newUser);

        return userCredentialDTO;
    }

    public AuthenticationResponse authenticate(UserCredentialDTO userCredentialDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentialDTO.email(),
                        userCredentialDTO.password()
                )
        );

        CompanyUser companyUser = userRepository.getCompanyUserByEmail(userCredentialDTO.email());

        String jwtToken = jwtService.generateToken(companyUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

}
