package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
