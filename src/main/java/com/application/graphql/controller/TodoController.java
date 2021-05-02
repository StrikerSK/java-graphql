package com.application.graphql.controller;

import com.application.graphql.service.TodoGraphQLService;
import graphql.ExecutionResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/alternative")
public class TodoController {

	private final TodoGraphQLService todoGraphQLService;

	@PostMapping
	public ResponseEntity<Object> getAllStudents(@RequestBody String query){
		ExecutionResult execute = todoGraphQLService.getGraphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
