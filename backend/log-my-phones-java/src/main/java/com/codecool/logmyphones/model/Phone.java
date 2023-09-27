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
public class Phone {
    @Id
    private String phoneNumber;
    @Transient
    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Set<Call> call;
    @Transient
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL)
    private Contact contact;
    @Transient
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL)
    private Dispatcher dispatcher;
}
