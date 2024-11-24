package com.art.questions_generator.controllers;


import com.art.questions_generator.domain.Question;
import com.art.questions_generator.services.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;


    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/questions/{amount}")
    public Collection<Question> qetQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }

}
