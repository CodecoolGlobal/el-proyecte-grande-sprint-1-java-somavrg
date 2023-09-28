package com.codecool.logmyphones.model;

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
    private Long contactId;
    private String name;
    @OneToOne
    private Phone phone;
    private String info;

    @ManyToOne(cascade = CascadeType.ALL)
    private CompanyUser user;
}
