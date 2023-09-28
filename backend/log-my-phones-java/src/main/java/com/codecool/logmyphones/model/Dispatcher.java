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
public class Dispatcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dispatcherId;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Phone phone;
    @OneToMany(mappedBy = "dispatcher", cascade = CascadeType.ALL)
    private Set<Call> calls;
    @ManyToOne(cascade = CascadeType.ALL)
    private CompanyUser user;
}
