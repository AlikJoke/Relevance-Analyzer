package ru.project.relevance.analyzer.db.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.project.relevance.analyzer.db.JdbcQueries;
import ru.project.relevance.analyzer.db.model.DirectionModel;
import ru.project.relevance.analyzer.db.repository.JdbcRepository;

@Repository
@Service
public class JdbcRepositoryImpl implements JdbcRepository {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(DirectionModel direction) {
		template.update(JdbcQueries.INSERT, pss -> {
			pss.setInt(1, direction.getUUID());
			pss.setString(2, direction.getName());
			pss.setTimestamp(3, direction.getTimestamp());
		});
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void delete(String name) {
		template.update(JdbcQueries.DELETE, pss -> pss.setInt(1, JdbcQueries.convertToUUID.apply(name)));
	}

	@Override
	@Transactional(readOnly = true)
	public DirectionModel get(String name) {
		return template.query(JdbcQueries.SELECT, new Object[] { JdbcQueries.convertToUUID.apply(name) },
				JdbcQueries.extractor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DirectionModel> getAll() {
		return template.query(JdbcQueries.SELECT_ALL, JdbcQueries.mapper);
	}

}
