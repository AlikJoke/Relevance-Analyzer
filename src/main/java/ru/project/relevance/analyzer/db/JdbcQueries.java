package ru.project.relevance.analyzer.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ru.project.relevance.analyzer.db.model.DirectionModel;

public class JdbcQueries {

	public final static String INSERT = "INSERT INTO directions VALUES (?, ?, ?::timestamp)";
	public final static String DELETE = "DELETE FROM directions WHERE uuid = ?";
	public final static String SELECT = "SELECT uuid, name, dt FROM directions WHERE uuid = ?";
	public final static String SELECT_ALL = "SELECT uuid, name, dt FROM directions";

	private static DirectionModel wrapObject(ResultSet rse) throws SQLException {
		DirectionModel model = null;
		if (rse.next()) {
			model = new DirectionModel(rse.getString("name"));
			model.setTimestamp(rse.getTimestamp("dt"));
		}
		return model;
	}

	public static ResultSetExtractor<DirectionModel> extractor = rse -> wrapObject(rse);

	public static RowMapper<DirectionModel> mapper = (rs, rw) -> wrapObject(rs);

	public static Function<String, Integer> convertToUUID = name -> name.hashCode();
}
