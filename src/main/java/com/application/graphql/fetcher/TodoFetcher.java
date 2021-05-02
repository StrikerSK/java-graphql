package com.application.graphql.fetcher;

import com.application.graphql.entity.TodoEntity;
import com.application.graphql.service.ITodoService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TodoFetcher implements DataFetcher<TodoEntity> {

	private final ITodoService todoService;

	@Override
	public TodoEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
		Integer id = dataFetchingEnvironment.getArgument("id");
		return todoService.getTodo(id.longValue());
	}
}
