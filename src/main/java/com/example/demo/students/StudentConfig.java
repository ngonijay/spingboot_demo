package com.example.demo.students;

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
            Student mariam = new Student(1L,
                    "Mariam",
                    LocalDate.now(),
                    "test@gmail.com");

            Student alex = new Student(2L,
                    "Alex",
                    LocalDate.now(),
                    "test2@gmail.com");

            studentsRepository.saveAll(List.of(mariam, alex));
        };
    }
}
