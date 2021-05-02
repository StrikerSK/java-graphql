package com.application.graphql.resolver;

import com.application.graphql.entity.TodoEntity;
import com.application.graphql.service.ITodoService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class TodoFetcher implements DataFetcher<TodoEntity> {

	private final ITodoService todoService;

	public TodoFetcher(ITodoService todoService) {
		this.todoService = todoService;
	}

	@Override
	public TodoEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
		Integer id = dataFetchingEnvironment.getArgument("id");
		return todoService.getTodo(id.longValue());
	}
}
