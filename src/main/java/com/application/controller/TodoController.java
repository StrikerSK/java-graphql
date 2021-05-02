package com.application.controller;

import com.application.graphql.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class TodoController {

	private final GraphQLService graphQLService;

	public TodoController(GraphQLService graphQLService) {
		this.graphQLService = graphQLService;
	}

	@PostMapping
	public ResponseEntity<Object> getAllStudents(@RequestBody String query){
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
