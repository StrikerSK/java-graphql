package com.application.graphql.service;

import com.application.graphql.entity.TodoEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@AllArgsConstructor
public class TodoServiceImpl implements ITodoService {

	private final PagingAndSortingRepository<TodoEntity, Long> todoRepository;

	@Override
	public TodoEntity getTodo(Long id) {
		return todoRepository.findById(id).orElse(null);
	}

	@Override
	public List<TodoEntity> getTodos() {
		return (List<TodoEntity>) todoRepository.findAll();
	}

	@Override
	public void createTodo(TodoEntity todo) {
		todoRepository.save(todo);
	}

	@Override
	public void updateTodo(Long id, TodoEntity todo) {
		todo.setId(id);
		createTodo(todo);
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
}
