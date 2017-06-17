package ru.project.relevance.analyzer.loader.model;

import javax.validation.constraints.NotNull;

public class Data {

	@NotNull
	private Integer uuid;

	@NotNull
	private Integer count;

	@NotNull
	private String year;

	public Data(Integer uuid, String year, Integer count) {
		super();
		this.uuid = uuid;
		this.year = year;
		this.count = count;
	}

	public Data() {
		super();
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
