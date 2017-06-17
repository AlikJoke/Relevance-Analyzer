package ru.project.relevance.analyzer.db.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class DirectionModel {

	private Integer uuid;
	private String name;
	private Timestamp dt;

	public Integer getUUID() {
		return uuid;
	}

	public Timestamp getTimestamp() {
		return dt;
	}

	public void setTimestamp(Timestamp dt) {
		this.dt = dt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DirectionModel(@NotNull @NotEmpty String name) {
		this.uuid = name.hashCode();
		this.dt = Timestamp.valueOf(LocalDateTime.now());
		this.name = name;
	}
}
