package com.example.demo.controller;


import com.example.demo.domain.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(value = "/add-subject")
    private void addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
    }

    @DeleteMapping(value = "/delete-subject/{subjectId}")
    private void deleteSubject(@PathVariable Long subjectId ){
        subjectService.deleteSubject(subjectId);
    }

    @GetMapping(value = "/get-all-subjects")
    private List<Subject> getAllSubJects(){
        return  subjectService.getAllSubjects();
    }
}
