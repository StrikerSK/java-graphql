package com.application.graphql.service;

import com.application.graphql.entity.TodoEntity;

import java.util.List;

public interface ITodoService {

	TodoEntity getTodo(Long id);
	List<TodoEntity> getTodos();
	void createTodo(TodoEntity todo);
	void updateTodo(Long id, TodoEntity todo);
	void deleteTodo(Long id);

}
