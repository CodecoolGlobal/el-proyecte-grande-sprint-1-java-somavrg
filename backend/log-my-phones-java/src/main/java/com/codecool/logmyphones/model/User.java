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
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int userId;
   private String name;
   private String email;
   @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
   private Set<Contact> contacts;
   @ManyToOne(cascade = CascadeType.ALL)
   private Set<Dispatcher> dispatchers;
}
