package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CompanyUser,Long> {
    Optional<CompanyUser> findByEmail(String email);
}
