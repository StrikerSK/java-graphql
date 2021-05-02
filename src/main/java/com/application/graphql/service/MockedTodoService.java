package com.application.graphql.service;

import com.application.graphql.entity.TodoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockedTodoService implements ITodoService {

	Logger LOG = LoggerFactory.getLogger(MockedTodoService.class);

	@Override
	public TodoEntity getTodo(Long id) {
		return new TodoEntity(id, "Mocked todo", "Mocked todo", false);
	}

	@Override
	public List<TodoEntity> getTodos() {
		List<TodoEntity> todos = new ArrayList<>();
		todos.add(new TodoEntity(1L, "Todo 1", "Todo 1", false));
		todos.add(new TodoEntity(2L, "Todo 2", "Todo 2", false));
		todos.add(new TodoEntity(3L, "Todo 3", "Todo 3", false));
		return todos;
	}

	@Override
	public void createTodo(TodoEntity todo) {
		LOG.info("Called creteTodo() wit data {}", todo.toString());
	}

	@Override
	public void updateTodo(Long id, TodoEntity todo) {
		todo.setId(id);
		LOG.info("Called updateTodo() wit data {}", todo.toString());
	}

	@Override
	public void deleteTodo(Long id) {
		LOG.info("Called deleteTodo() wit id [{}]", id);
	}
}
