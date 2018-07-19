/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.restapi.controllers;

import com.spring.restapi.models.Product;
import com.spring.restapi.repositories.ProductRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author didin
 */
@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public Iterable<Product> product() {
		return productRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public String save(@RequestBody Product product) {
		productRepository.save(product);

		return product.getId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
	public Optional<Product> show(@PathVariable String id) {
		return productRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public Product update(@PathVariable String id, @RequestBody Product product) {
		Optional<Product> prod = productRepository.findById(id);
		if (product.getProdName() != null)
			prod.get().setProdName(product.getProdName());
		if (product.getProdDesc() != null)
			prod.get().setProdDesc(product.getProdDesc());
		if (product.getProdPrice() != null)
			prod.get().setProdPrice(product.getProdPrice());
		if (product.getProdImage() != null)
			prod.get().setProdImage(product.getProdImage());
		productRepository.save(prod.get());
		return prod.get();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public String delete(@PathVariable String id) {
		Optional<Product> product = productRepository.findById(id);
		productRepository.delete(product.get());

		return "product deleted";
	}
}