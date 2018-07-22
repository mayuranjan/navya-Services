/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.restapi.repositories;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.spring.restapi.models.AnswerSet;

/**
 * Answer Set Repository
 * @author Mayur Ranjan
 */
public interface ASRepository extends CrudRepository<AnswerSet, String> {
	@Override
    Optional<AnswerSet> findById(String id);

	ArrayList<AnswerSet> findByQuestionId(int questionId);
	
	Optional<AnswerSet> findByResponseId(int responseId);

	@Override
	long count();

	long countByQuestionId(int questionId);
}
