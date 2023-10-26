package com.codecool.logmyphones.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyUser {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   private String password;

   @Enumerated(EnumType.STRING)
   private UserRole role;

   @OneToMany(mappedBy = "user")
   private Set<Contact> contacts = new HashSet<>();
   @OneToMany(mappedBy = "user")
   private Set<Dispatcher> dispatchers = new HashSet<>();

}