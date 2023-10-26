package com.codecool.logmyphones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    @OneToMany(mappedBy = "clientPhone")
    private Set<Call> calls;
    @OneToMany(mappedBy = "clientPhone")
    private Set<Contact> contacts;

}
