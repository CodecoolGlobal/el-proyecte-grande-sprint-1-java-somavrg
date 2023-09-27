package com.codecool.logmyphones.model.DAO;

import com.codecool.logmyphones.model.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<CompanyUser,Long> {
}
