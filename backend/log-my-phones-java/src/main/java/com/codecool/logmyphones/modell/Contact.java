package com.codecool.logmyphones.modell;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;
    private String name;
    @OneToOne(mappedBy = "phone")
    private Phone phone;
    private String info;
    @Transient
    @ManyToOne
    private User user;
}
