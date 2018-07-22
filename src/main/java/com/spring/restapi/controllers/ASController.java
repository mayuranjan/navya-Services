/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.restapi.controllers;

import com.spring.restapi.models.AnswerSet;
import com.spring.restapi.repositories.ASRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Answer Set Controller
 * 
 * @author Mayur Ranjan
 */
@RestController
public class ASController {

	@Autowired
	ASRepository asRepository;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/answerSets")
	public Iterable<AnswerSet> answerSet() {
		return asRepository.findAll();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/answerSet")
	public int save(@RequestBody AnswerSet answerSet) {
		asRepository.save(answerSet);

		return answerSet.getResponseId();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/answerSets/{answerId}")
	public Optional<AnswerSet> show(@PathVariable int answerId) {
		return asRepository.findByResponseId(answerId);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/answerSetsByQuestion/{questionId}")
	public ArrayList<AnswerSet> showByQuestion(@PathVariable int questionId) {
		return asRepository.findByQuestionId(questionId);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/answerSets/{answerId}")
	public AnswerSet update(@PathVariable int answerId, @RequestBody AnswerSet newAnswerSet) {
		Optional<AnswerSet> oldAnswerSet = asRepository.findByResponseId(answerId);
		if (newAnswerSet.getAnswers() != null)
			oldAnswerSet.get().setAnswers(newAnswerSet.getAnswers());
		asRepository.save(oldAnswerSet.get());
		return oldAnswerSet.get();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/answerSets/count")
	public long count() {
		long noOfQASets = asRepository.count();

		return noOfQASets;
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/answerSetsByQuestion/count/{questionId}")
	public long countByAnswer(@PathVariable int questionId) {
		long noOfQASets = asRepository.countByQuestionId(questionId);

		return noOfQASets;
	}
}