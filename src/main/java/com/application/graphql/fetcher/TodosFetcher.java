package com.application.graphql.fetcher;

import com.application.graphql.entity.TodoEntity;
import com.application.graphql.service.ITodoService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TodosFetcher implements DataFetcher<List<TodoEntity>> {

	private final ITodoService todoService;

	@Override
	public List<TodoEntity> get(DataFetchingEnvironment dataFetchingEnvironment) {
		return todoService.getTodos();
	}
}
