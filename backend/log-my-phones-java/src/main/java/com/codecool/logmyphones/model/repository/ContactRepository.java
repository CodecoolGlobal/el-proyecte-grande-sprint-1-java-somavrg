package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
