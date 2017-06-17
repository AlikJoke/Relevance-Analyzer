package ru.project.relevance.analyzer.db.repository;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.jdbc.core.JdbcTemplate;

import ru.project.relevance.analyzer.db.model.DirectionModel;

/**
 * Интерфейс доступа к операциям с РСУБД.
 * 
 * @author Alimurad A. Ramazanov
 * @since 17.06.2017
 * @version 1.0.0
 *
 */
public interface JdbcRepository {

	/**
	 * Операция сохранения в БД.
	 * <p>
	 * 
	 * @see DirectionModel
	 * @see JdbcTemplate
	 * 
	 * @param direction
	 *            - объект для сохранения; не может быть {@code null}.
	 */
	void save(@NotNull DirectionModel direction);

	/**
	 * Операция удаления из БД.
	 * <p>
	 * 
	 * @see DirectionModel
	 * @see JdbcTemplate
	 * 
	 * @param name
	 *            - идентификатор для удаления; не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 */
	void delete(@NotNull @NotEmpty String name);

	/**
	 * Операция получения объекта из БД по идентификатору.
	 * <p>
	 * 
	 * @see BaseWrapper
	 * @see JdbcTemplate
	 * 
	 * @param name
	 *            - идентификатор объекта; не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 * @return может быть {@code null}
	 */
	@Null
	DirectionModel get(@NotNull @NotEmpty String name);

	/**
	 * Операция получения объекта из БД <b>всех</b> объектов.
	 * <p>
	 * 
	 * @see DirectionModel
	 * @see JdbcTemplate
	 * 
	 * @return не может быть {@code List#isEmpty()}
	 */
	@NotNull
	List<DirectionModel> getAll();
}
