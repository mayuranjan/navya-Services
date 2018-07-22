package com.spring.restapi.models;

import java.util.ArrayList;

public class Question {
	String answerType;
	Boolean isRequired;
	ArrayList<MultipleChoice> multipleChoices;
	String question;

	public Question() {
	}

	public Question(String answerType, Boolean isRequired, ArrayList<MultipleChoice> multipleChoices, String question) {
		this.answerType = answerType;
		this.isRequired = isRequired;
		this.multipleChoices = multipleChoices;
		this.question = question;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public ArrayList<MultipleChoice> getMultipleChoices() {
		return multipleChoices;
	}

	public void setMultipleChoices(ArrayList<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}