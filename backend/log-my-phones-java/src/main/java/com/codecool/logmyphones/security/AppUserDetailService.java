package com.codecool.logmyphones.security;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AppUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<CompanyUser> appUser = userRepository.findByEmail(email);

        if (appUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        CompanyUser user = appUser.get();

//        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));

        return new User(user.getEmail(), user.getPassword(), List.of());


    }
}