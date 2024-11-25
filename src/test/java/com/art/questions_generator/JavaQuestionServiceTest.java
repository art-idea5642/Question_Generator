package com.art.questions_generator;

import com.art.questions_generator.domain.Question;
import com.art.questions_generator.exceptions.QuestionAlreadyAddedException;
import com.art.questions_generator.exceptions.QuestionNotFoundException;
import com.art.questions_generator.services.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Random;

import static com.art.questions_generator.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private Random random;

    @Test
    public void shouldAddQuestionsWhenTheyDontExist1() {
        assertEquals(0, out.getAll().size());
        assertFalse(out.getAll().contains(FIRST_QUESTION));

        out.addQuestion(FIRST_QUESTION);

        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(FIRST_QUESTION));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenTheyExist1() {
        out.addQuestion(FIRST_QUESTION);

        assertThrows(QuestionAlreadyAddedException.class, () -> {
            out.addQuestion(FIRST_QUESTION);
        });

        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(FIRST_QUESTION));
    }

    @Test
    public void shouldRemoveQuestionWhenTheyExist() {
        out.addQuestion(SECOND_QUESTION);

        assertEquals(1, out.getAll().size());

        out.removeQuestion(SECOND_QUESTION);

        assertEquals(0, out.getAll().size());
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemovingNonExistentEmployee() {
        out.addQuestion(THIRD_QUESTION);
        assertFalse(out.getAll().contains(SECOND_QUESTION));

        assertThrows(QuestionNotFoundException.class, () -> {
            out.removeQuestion(SECOND_QUESTION);
        });
    }

    @Test
    public void shouldReturnAllQuestionsWhenQuestionsExist() {
        out.addQuestion(FIRST_QUESTION);
        out.addQuestion(SECOND_QUESTION);
        out.addQuestion(THIRD_QUESTION);
        out.addQuestion(FOURTH_QUESTION);

        Collection<Question> allQuestions = out.getAll();

        assertEquals(4, allQuestions.size());
        assertTrue(allQuestions.contains(FIRST_QUESTION));
        assertTrue(allQuestions.contains(SECOND_QUESTION));
        assertTrue(allQuestions.contains(THIRD_QUESTION));
        assertTrue(allQuestions.contains(FOURTH_QUESTION));
    }

    @Test
    public void shouldGetRandomQuestion() {
        out.addQuestion(FIRST_QUESTION);
        out.addQuestion(SECOND_QUESTION);
        out.addQuestion(THIRD_QUESTION);
        out.addQuestion(FOURTH_QUESTION);

        when(random.nextInt(anyInt())).thenReturn(1);
        out.setRandom(random);

        assertEquals(SECOND_QUESTION, out.getRandomQuestion());
    }
}

