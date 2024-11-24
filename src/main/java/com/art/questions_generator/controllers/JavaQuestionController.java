package com.art.questions_generator.controllers;

import com.art.questions_generator.domain.Question;
import com.art.questions_generator.exceptions.QuestionAlreadyAddedException;
import com.art.questions_generator.exceptions.QuestionNotFoundException;
import com.art.questions_generator.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public String addQuestion(@RequestParam Question question) {

        try {
            questionService.addQuestion(question);
            return "Вопрос добавлен";
        } catch (QuestionAlreadyAddedException e) {
            return "Ошибка: Вопрос уже добавлен";
        } catch (IllegalArgumentException e) {
            return "Ошибка: Некоректные данные";
        }
    }
    @GetMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {

        try {
            questionService.addQuestion(question, answer);
            return "Вопрос добавлен";
        } catch (QuestionAlreadyAddedException e) {
            return "Ошибка: Вопрос уже добавлен";
        } catch (IllegalArgumentException e) {
            return "Ошибка: Некоректные данные";
        }
    }

    @GetMapping ("/remove")
    public String remove (@RequestParam Question question){
        try {
            questionService.removeQuestion(question);
            return "Вопрос успешно удален";
        } catch (QuestionNotFoundException e) {
            return "Вопрос не найден";
        } catch (IllegalArgumentException e) {
            return "Ошибка: Некорректные данные";
        }
    }



}
