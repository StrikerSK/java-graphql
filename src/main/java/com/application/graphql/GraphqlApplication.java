package com.application.graphql;

import com.oembedler.moon.graphql.boot.GraphQLWebAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = GraphQLWebAutoConfiguration.class)
@SpringBootApplication
@EnableJpaRepositories
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

}
