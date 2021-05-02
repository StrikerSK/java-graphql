package com.application.graphql.fetcher;

import com.application.graphql.entity.TodoEntity;
import com.application.graphql.service.ITodoService;
import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TodoFetchers {

	private final ITodoService todoService;

	public DataFetcher<TodoEntity> getTodo() {
		return dataFetchingEnvironment -> {
			Integer todoId = dataFetchingEnvironment.getArgument("id");
			return todoService.getTodo(todoId.longValue());
		};
	}

	public DataFetcher<List<TodoEntity>> getTodos() {
		return dataFetchingEnvironment -> {
			return todoService.getTodos();
		};
	}
}
