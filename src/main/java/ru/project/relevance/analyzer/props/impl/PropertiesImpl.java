package ru.project.relevance.analyzer.props.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ru.project.relevance.analyzer.props.Properties;

@Service
@PropertySource(value = { "classpath:application.properties" })
public class PropertiesImpl implements Properties {

	@Autowired
	private Environment env;

	@Override
	public String getProperty(String name) {
		return env.getProperty(name);
	}
}
