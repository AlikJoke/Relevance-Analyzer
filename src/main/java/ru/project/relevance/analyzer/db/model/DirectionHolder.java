package ru.project.relevance.analyzer.db.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Интерфейс, представляющий из себя кэш имеющихся в базе научных направлений.
 * 
 * @author Alimurad A. Ramazanov
 * @since 17.06.2017
 * @version 1.0.0
 *
 */
public interface DirectionHolder {

	/**
	 * Сохраняет в кэш все объекты направлений, имеющиеся в базе. Периодически
	 * запускается для исключения случая наличия в кэше данных, которые были
	 * удалены из базы "ручками".
	 * <p>
	 * 
	 * @see DirectionModel
	 */
	void loadDirections();

	/**
	 * Сохраняет в кэш объект направления.
	 * <p>
	 * 
	 * @param name
	 *            - имя направления; не может быть {@code null}.
	 * @see DirectionModel
	 * @return {@code true} - если направление было сохранено, {@code false} -
	 *         иначе.
	 */
	boolean loadDirection(@NotNull @NotEmpty String name);

	/**
	 * Проверяет наличие в кэше модели.
	 * <p>
	 * 
	 * @see DirectionModel
	 * @param uuid
	 *            - идентификатор направления; не может быть {@code null}.
	 * @return {@code true} - если объект с таким именем уже существует,
	 *         {@code false - иначе}.
	 */
	boolean containsDirection(@NotNull Integer uuid);

	/**
	 * Возвращает имеющиеся в кэше направления.
	 * <p>
	 * 
	 * @see DirectionModel
	 * @return не может быть {@code null}.
	 */
	@NotNull
	List<DirectionModel> getDirections();
}
