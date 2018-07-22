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

@Document(collection = "questionSets")
public class QuestionSet {
	@Id
	String id;
	int questionId;
	Boolean isPublished;
	ArrayList<Question> value;

	public QuestionSet() {
	}

	public QuestionSet(int id, ArrayList<Question> value, Boolean isPublisher) {
		this.questionId = id;
		this.value = value;
		this.isPublished = isPublisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public ArrayList<Question> getValue() {
		return value;
	}

	public void setValue(ArrayList<Question> value) {
		this.value = value;
	}

	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

}