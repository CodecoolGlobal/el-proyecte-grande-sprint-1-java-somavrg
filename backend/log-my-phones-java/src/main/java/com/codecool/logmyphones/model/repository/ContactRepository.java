package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    Set<Contact> getContactsByUserUserId(Long companyId);
    Set<Contact> getContactsByUser_Email(String email);
}
