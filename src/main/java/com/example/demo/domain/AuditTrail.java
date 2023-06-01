package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditTrail {
    @Id
    @SequenceGenerator(
            name = "grades_sequence",
            sequenceName = "grades_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "grades_sequence"
    )
    private Long id;
    private Long userId;
    private LocalDate dateLogin;
    private LocalTime LoginTime;
    private String Action;
}
