package com.art.questions_generator.services;

import com.art.questions_generator.domain.Question;
import com.art.questions_generator.exceptions.LessQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (questionService.getAll().size() < amount) {
            throw new LessQuestionsException
                    ("Количество запрашиваемых вопросов превышает количество существующих.");
        }
        Set<Question> getUniqueQuestions = new HashSet<>();
        while (getUniqueQuestions.size() < amount) {
            getUniqueQuestions.add(questionService.getRandomQuestion());
        }
        return getUniqueQuestions;
    }


}
