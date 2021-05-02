package com.application.graphql.service;

import com.application.graphql.fetcher.TodoFetchers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class TodoGraphQLService {

	private final TodoFetchers todoFetchers;
	private GraphQL graphQL;

	@Value("classpath:types.graphqls")
	private Resource resource;

	public TodoGraphQLService(TodoFetchers todoFetchers) {
		this.todoFetchers = todoFetchers;
	}

	@PostConstruct
	public void loadSchema() throws IOException {

		InputStream inputStream = resource.getInputStream();
		Reader inputStreamReader = new InputStreamReader(inputStream);

		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(inputStreamReader);
		RuntimeWiring wiring = buildRuntimeWiring();

		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();

	}

	private RuntimeWiring buildRuntimeWiring() {

		return RuntimeWiring.newRuntimeWiring()
				.type("Query", builder -> builder
						.dataFetcher("todo", todoFetchers.getTodo())
						.dataFetcher("todos", todoFetchers.getTodos()))
				.build();

	}

	public GraphQL getGraphQL() {
		return graphQL;
	}

}
