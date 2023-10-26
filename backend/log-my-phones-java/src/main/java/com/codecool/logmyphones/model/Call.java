package com.codecool.logmyphones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Dispatcher dispatcher;
    @ManyToOne
    private ClientPhone clientPhone;
    private LocalDateTime startTime;
    private CallStatus callStatus;
    private CallDirection callDirection;
    private int duration;
}
