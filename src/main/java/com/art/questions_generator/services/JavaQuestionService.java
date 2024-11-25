package com.art.questions_generator.services;

import com.art.questions_generator.domain.Question;
import com.art.questions_generator.exceptions.QuestionAlreadyAddedException;
import com.art.questions_generator.exceptions.QuestionNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    private Random random = new Random();

    public void setRandom (Random random) {
        this.random = random;
    }

    @Override
    public void addQuestion(Question question) {

        if (StringUtils.isBlank(question.getQuestion()) || StringUtils.isBlank(question.getAnswer())) {
            throw new IllegalArgumentException("Вопрос и ответ не могут быть пустыми.");
        }

        String formattedQuestion = StringUtils.capitalize(question.getQuestion());
        String formattedAnswer = StringUtils.capitalize(question.getAnswer());

        Question formattedQuestionAndAnswer = new Question(formattedQuestion, formattedAnswer);

        if (questions.contains(formattedQuestionAndAnswer)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже добавлен.");
        }

        questions.add(formattedQuestionAndAnswer);
    }

    @Override
    public void addQuestion(String question, String answer) {

        if (StringUtils.isBlank(question) || StringUtils.isBlank(answer)) {
            throw new IllegalArgumentException("Вопрос и ответ не могут быть пустыми.");
        }

        String formattedQuestion = StringUtils.capitalize(question);
        String formattedAnswer = StringUtils.capitalize(answer);

        Question formattedQuestionAndAnswer = new Question(formattedQuestion, formattedAnswer);

        if (questions.contains(formattedQuestionAndAnswer)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже добавлен.");
        }

        questions.add(formattedQuestionAndAnswer);

    }

    @Override
    public void removeQuestion(Question question) {
        if (StringUtils.isBlank(question.getQuestion()) || StringUtils.isBlank(question.getAnswer())) {
            throw new IllegalArgumentException("Вопрос и ответ не могут быть пустыми.");
        }

        String formattedQuestion = StringUtils.capitalize(question.getQuestion());
        String formattedAnswer = StringUtils.capitalize(question.getAnswer());


        Question formattedQuestionAndAnswer = new Question(formattedQuestion, formattedAnswer);

        if (!questions.contains(formattedQuestionAndAnswer)) {
            throw new QuestionNotFoundException("Такой вопрос не найден.");
        }
        questions.remove(formattedQuestionAndAnswer);
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {

        List<Question> questionList = new ArrayList<>(questions);

        int randomIndex = random.nextInt(questionList.size());

        return questionList.get(randomIndex);
    }

    @Override
    public int getSize() {
        return questions.size();
    }


}
