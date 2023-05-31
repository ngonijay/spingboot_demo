package com.example.demo.students;

import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getStudent() {
        return studentsRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> student1 = studentsRepository.findStudentByEmail(student.getEmail());
        if (student1.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentsRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean isStudentPresent = studentsRepository.existsById(id);

        if (!isStudentPresent) {
            throw new IllegalStateException("student does not exist");
        }

        studentsRepository.deleteById(id);
    }


    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        boolean exists = studentsRepository.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("Student does not exist");
        }

        Student student = studentsRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id" + studentId));

        student.setFirstName(name);
        student.setEmail(email);
    }
}
