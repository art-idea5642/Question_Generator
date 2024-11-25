package com.art.questions_generator;


import com.art.questions_generator.services.ExaminerServiceImpl;
import com.art.questions_generator.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.art.questions_generator.TestConstants.ALL_QUESTIONS;
import static com.art.questions_generator.TestConstants.FIRST_QUESTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionService mock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void shouldGetQuestions (){

        when(mock.getSize()).thenReturn(1);

        when(mock.getRandomQuestion()).thenReturn(FIRST_QUESTION);

        assertEquals(ALL_QUESTIONS, out.getQuestions(1));
    }
}
