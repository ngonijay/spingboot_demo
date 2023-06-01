package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Average {

    @Id
    @SequenceGenerator(
            name = "average_sequence",
            sequenceName = "average_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "average_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String GWA;
}
