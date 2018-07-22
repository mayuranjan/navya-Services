/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.restapi.controllers;

import com.spring.restapi.models.QuestionSet;
import com.spring.restapi.repositories.QSRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Question Set Controller
 * @author Mayur Ranjan
 */
@RestController
public class QSController {

	@Autowired
	QSRepository qsRepository;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/questionSets")
	public Iterable<QuestionSet> questionSet() {
		return qsRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/questionSet")
	public int save(@RequestBody QuestionSet questionSet) {
		qsRepository.save(questionSet);

		return questionSet.getQuestionId();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/questionSets/{questionId}")
	public Optional<QuestionSet> show(@PathVariable int questionId) {
		return qsRepository.findByQuestionId(questionId);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/questionSets/{questionId}")
	public QuestionSet update(@PathVariable int questionId, @RequestBody QuestionSet newQuestionSet) {
		Optional<QuestionSet> oldQuestionSet = qsRepository.findByQuestionId(questionId);
		if (newQuestionSet.getValue() != null)
			oldQuestionSet.get().setValue(newQuestionSet.getValue());
		if (newQuestionSet.getIsPublished() != null)
			oldQuestionSet.get().setIsPublished(newQuestionSet.getIsPublished());
		qsRepository.save(oldQuestionSet.get());
		return oldQuestionSet.get();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/questionSets/count")
	public long count() {
		long noOfQASets = qsRepository.count();

		return noOfQASets;
	}
}