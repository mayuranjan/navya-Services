package com.spring.restapi.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.restapi.models.QuestionSet;
import com.spring.restapi.repositories.QSRepository;
import com.spring.restapi.models.MultipleChoice;
import com.spring.restapi.models.Question;

@RunWith(SpringRunner.class)
@WebMvcTest(value = QSController.class, secure = false)
public class QuestionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QSRepository qsRepository;

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
	Optional<QuestionSet> mockQuestion;

	@Test
	public void getQuestionSets() throws Exception {
		ArrayList<MultipleChoice> multipleChoices = new ArrayList<MultipleChoice>();
		Question value = new Question("Paragraph", false, multipleChoices, "Untitled Question");
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(value);
		mockQuestion = Optional.of(new QuestionSet(1, questions, true));

		Mockito.when(qsRepository.findByQuestionId(Mockito.anyInt())).thenReturn(mockQuestion);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/questionSets/2")
				
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("here" + result.getResponse().getContentAsString());
		String expected = "{'id':null,'questionId':1,'isPublished':true,'value':[{'answerType':'Paragraph','isRequired':false,'multipleChoices':[],'question':'Untitled Question'}]}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}
}
