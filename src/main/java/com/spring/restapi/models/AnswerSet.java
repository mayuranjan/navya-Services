/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.restapi.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Mayur Ranjan
 */

@Document(collection = "answerSets")
public class AnswerSet {
	@Id
	String id;
	int responseId;
	int questionId;
	ArrayList<Answer> answers;

	public AnswerSet() {
	}

	public AnswerSet(int responseId, int questionId, ArrayList<Answer> answers) {
		this.responseId = responseId;
		this.questionId = questionId;
		this.answers = answers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

}

class Answer {
	String answerType;
	String paragraph;
	int multipleChoiceIndex;

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public int getMultipleChoiceIndex() {
		return multipleChoiceIndex;
	}

	public void setMultipleChoiceIndex(int multipleChoiceIndex) {
		this.multipleChoiceIndex = multipleChoiceIndex;
	}

}