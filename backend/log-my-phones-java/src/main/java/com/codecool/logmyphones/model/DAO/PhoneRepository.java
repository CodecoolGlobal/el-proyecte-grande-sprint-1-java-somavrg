package com.codecool.logmyphones.model.DAO;

import com.codecool.logmyphones.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,String> {
}
