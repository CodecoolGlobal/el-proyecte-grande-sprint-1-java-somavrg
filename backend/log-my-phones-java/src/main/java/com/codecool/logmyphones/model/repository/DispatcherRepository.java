package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface DispatcherRepository extends JpaRepository<Dispatcher,Long> {
    Set<Dispatcher> findByUser_Id(Long userId);
    Set<Dispatcher> findByUser_Email(String email);
    Optional<Dispatcher> findByPhoneNumber(String dispatcherPhoneNumber);
}
