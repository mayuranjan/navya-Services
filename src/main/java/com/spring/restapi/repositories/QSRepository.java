/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.restapi.repositories;

import com.spring.restapi.models.QuestionSet;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

/**
 * Question Set Repository
 * @author Mayur Ranjan
 */
public interface QSRepository extends CrudRepository<QuestionSet, String> {
	@Override
    Optional<QuestionSet> findById(String id);
	
    Optional<QuestionSet> findByIdAndIsPublished(String id, Boolean isPublished);

	Optional<QuestionSet> findByQuestionId(int questionId);
	
	@Override
	long count();

    @Override
    void delete(QuestionSet deleted);
}
