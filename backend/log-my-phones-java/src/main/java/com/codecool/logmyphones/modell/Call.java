package com.codecool.logmyphones.modell;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.proxy.Dispatcher;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int callId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Phone caller;
    @ManyToOne(cascade = CascadeType.ALL)
    private Phone target;
    private LocalDateTime startTime;
    private CallStatus callStatus;
    private int duration;
    @Transient
    @ManyToOne(cascade = CascadeType.ALL)
    private Dispatcher dispatcher;
}
