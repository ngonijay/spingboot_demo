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
public class Grades {
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
    private Long studentId;
    private String firstName;
    private String lastName;
    private String subjectCode;
    private String subjectDescription;
    private String firstGrading;
    private String secondGrading;
    private String thirdGrading;
    private String fourthGrading;
    
}
