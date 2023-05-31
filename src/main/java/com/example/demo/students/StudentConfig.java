package com.example.demo.students;

import com.example.demo.domain.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentsRepository studentsRepository) {
        return args -> {
            Student mariam = Student.builder()
                    .id(1L)
                    .firstName( "Mariam")
                    .middleName("Tino")
                    .lastName("John")
                    .dateOfBirth(LocalDate.now())
                    .academicLevel("Grade 2")
                    .contactNumber("077452653")
                    .contactPerson("Tim John")
                    .contactPersonNumber("0773223848")
                    .email("maria@gmail.com")
                    .build();


            Student alex =  Student.builder()
                    .id(1L)
                    .firstName( "Alex")
                    .middleName("Tino")
                    .lastName("Blue")
                    .dateOfBirth(LocalDate.now())
                    .academicLevel("Grade 1")
                    .contactNumber("0774526234")
                    .contactPerson("Tim John")
                    .contactPersonNumber("0773223532")
                    .email("Alex@gmail.com")
                    .build();

            studentsRepository.saveAll(List.of(mariam, alex));

        };
    }
}
