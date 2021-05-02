package com.application.graphql.resolver;

import com.application.graphql.entity.TodoEntity;
import com.application.graphql.service.ITodoService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TodoQueryResolver implements GraphQLQueryResolver {

	private final ITodoService todoService;

	public TodoEntity getTodo(Integer id) {
		return todoService.getTodo(id.longValue());
	}

	public List<TodoEntity> getTodos() {
		return todoService.getTodos();
	}
}
