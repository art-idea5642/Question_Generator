package com.art.questions_generator;

import com.art.questions_generator.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestConstants {
public static final String QUESTION1 = "Вопрос №1";
public static final String QUESTION2 = "Вопрос №2";
public static final String QUESTION3 = "Вопрос №3";
public static final String QUESTION4 = "Вопрос №4";
public static final String ANSWER1 = "Ответ №1";
public static final String ANSWER2 = "Ответ №2";
public static final String ANSWER3 = "Ответ №3";
public static final String ANSWER4 = "Ответ №4";

public static final Question FIRST_QUESTION = new Question(QUESTION1, ANSWER1);
public static final Question SECOND_QUESTION = new Question(QUESTION2, ANSWER2);
public static final Question THIRD_QUESTION = new Question(QUESTION3, ANSWER3);
public static final Question FOURTH_QUESTION = new Question(QUESTION4, ANSWER4);

    public static final Collection<Question> ALL_QUESTIONS = new HashSet<>();

    static {
        ALL_QUESTIONS.add(FIRST_QUESTION);

    }
}
