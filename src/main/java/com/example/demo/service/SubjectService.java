package com.example.demo.service;

import com.example.demo.controller.SubjectController;
import com.example.demo.domain.Student;
import com.example.demo.domain.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void addSubject(Subject subject){
        Optional<Subject> isSubjectAvailable = subjectRepository.findBySubjectCode(subject.getSubjectCode());
        if (isSubjectAvailable.isPresent()) {
            throw new IllegalStateException("subject already exists");
        }

        subjectRepository.save(subject);
    };

    public void deleteSubject(Long id) {
        boolean isSubjectPresent = subjectRepository.existsById(id);

        if (!isSubjectPresent) {
            throw new IllegalStateException("student does not exist");
        }

        subjectRepository.deleteById(id);
    }


    public List<Subject> getAllSubjects() {
        if (subjectRepository.findAll().isEmpty()){
            throw new IllegalStateException("they are no subjects");
        }
        return subjectRepository.findAll();
    }

}
