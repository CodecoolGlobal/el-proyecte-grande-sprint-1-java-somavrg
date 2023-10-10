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
public class CompanyUser {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long userId;
   private String name;
   private String email;
   private String password;

   @Enumerated(EnumType.STRING)
   private UserRole role;

   @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
   private Set<Contact> contacts;
   @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
   private Set<Dispatcher> dispatchers;


   public void addContact(Contact contact){contacts.add(contact);}
}
