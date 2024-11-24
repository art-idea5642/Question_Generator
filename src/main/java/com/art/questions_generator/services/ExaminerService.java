package com.art.questions_generator.services;

import com.art.questions_generator.domain.Question;


import java.util.Collection;


public interface ExaminerService {

    public Collection<Question> getQuestions (int amount);
}
