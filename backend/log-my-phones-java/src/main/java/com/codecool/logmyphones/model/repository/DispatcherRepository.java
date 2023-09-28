package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DispatcherRepository extends JpaRepository<Dispatcher,Long> {
    Set<Dispatcher> getDispatchersByUserUserId(Long userId);
}
