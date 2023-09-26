package com.codecool.logmyphones.model.DAO;

import com.codecool.logmyphones.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDAO extends JpaRepository<Contact,Long> {
}
