package ru.project.relevance.analyzer.db.model.impl;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import ru.project.relevance.analyzer.db.model.DirectionHolder;
import ru.project.relevance.analyzer.db.model.DirectionModel;
import ru.project.relevance.analyzer.db.repository.JdbcRepository;

@Component
public class DirectionHolderImpl implements DirectionHolder {

	@Autowired
	private JdbcRepository repository;

	private ConcurrentMap<Integer, DirectionModel> models;

	@PostConstruct
	public void init() {
		this.models = Maps.newConcurrentMap();
		this.loadDirections();
	}

	@Override
	@Scheduled(initialDelay = 0, fixedDelay = 3000000)
	public void loadDirections() {
		this.models.clear();
		this.repository.getAll().parallelStream()
				.filter(model -> model != null && StringUtils.hasLength(model.getName()))
				.forEach(model -> models.put(model.getUUID(), model));
	}

	@Override
	public boolean containsDirection(Integer uuid) {
		return this.models.containsKey(uuid);
	}

	@Override
	public List<DirectionModel> getDirections() {
		return Lists.newArrayList(this.models.values());
	}

	@Override
	public boolean loadDirection(String name) {
		if (!this.containsDirection(name.hashCode())) {
			DirectionModel model = new DirectionModel(name);
			this.repository.save(model);
			this.models.put(model.getUUID(), model);
			return true;
		}
		return false;
	}

}
