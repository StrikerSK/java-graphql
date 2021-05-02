package com.application.graphql.entity;

import javax.persistence.Entity;

@Entity
public class TodoEntity extends AbstractTodo {

	public TodoEntity() {
	}

	public TodoEntity(Long id, String name, String description, Boolean done) {
		super(id, name, description, done);
	}
}
