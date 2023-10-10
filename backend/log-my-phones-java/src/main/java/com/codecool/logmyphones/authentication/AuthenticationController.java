package com.codecool.logmyphones.authentication;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.RegisterUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public RegisterUserDTO register(@RequestBody RegisterUserDTO registerUserDTO) {
        return authenticationService.register(registerUserDTO);
    }

}
