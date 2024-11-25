package com.art.questions_generator.services;

import com.art.questions_generator.domain.Question;
import com.art.questions_generator.exceptions.QuestionAlreadyAddedException;
import com.art.questions_generator.exceptions.QuestionNotFoundException;

import java.util.Collection;

public interface QuestionService {

    void addQuestion(Question question)
            throws QuestionAlreadyAddedException, IllegalArgumentException;

    void addQuestion(String question, String answer)
            throws QuestionAlreadyAddedException, IllegalArgumentException;

    void removeQuestion(Question question)
            throws QuestionNotFoundException, IllegalArgumentException;

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSize ();

}
