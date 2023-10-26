package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.ClientPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientPhoneRepository extends JpaRepository<ClientPhone,String> {
    Optional<ClientPhone> findByPhoneNumber(String phoneNumber);
}
