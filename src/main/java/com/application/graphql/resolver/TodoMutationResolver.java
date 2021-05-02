package com.application.graphql.resolver;

import com.application.graphql.entity.TodoEntity;
import com.application.graphql.service.ITodoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TodoMutationResolver implements GraphQLMutationResolver {

	private final ITodoService todoService;

	public TodoEntity createTodo(String name, String description, Boolean done) {
		TodoEntity todo = new TodoEntity(1L, name, description, done != null && done);
		todoService.createTodo(todo);
		return todo;
	}

	public TodoEntity updateTodo(Long id, String name, String description, Boolean done) {
		TodoEntity todo = new TodoEntity(id, name, description, done != null && done);
		todoService.updateTodo(id, todo);
		return todo;
	}

	public Long deleteTodo(Long id) {
		todoService.deleteTodo(id);
		return id;
	}

}
