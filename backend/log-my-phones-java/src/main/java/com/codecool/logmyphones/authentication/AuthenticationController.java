package com.codecool.logmyphones.authentication;

import com.codecool.logmyphones.model.DTO.UserCredentialDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public UserCredentialDTO register(@RequestBody UserCredentialDTO registerUserDTO) {
        return authenticationService.register(registerUserDTO);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody UserCredentialDTO registerUserDTO) {
        return authenticationService.authenticate(registerUserDTO);
    }

    @GetMapping("/authenticate")
    public void authenticattte(@RequestBody UserCredentialDTO registerUserDTO) {
        System.out.println("hello");
    }

}
