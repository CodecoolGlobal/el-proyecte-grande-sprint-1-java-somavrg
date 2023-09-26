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
public class Phone {
    @Id
    private int phoneNumber;
    @Transient
    @OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
    private Call call;
    @Transient
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL)
    private Contact contact;
    @Transient
    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL)
    private Dispatcher dispatcher;
}
