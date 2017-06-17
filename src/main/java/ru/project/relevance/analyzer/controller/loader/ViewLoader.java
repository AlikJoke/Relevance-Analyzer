package ru.project.relevance.analyzer.controller.loader;

import java.io.IOException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;

import ru.project.relevance.analyzer.controller.model.SimpleView;

/**
 * Интерфейс для загрузки представлений из файлов-моделей.
 * 
 * @author Alimurad A. Ramazanov
 * @since 17.06.2017
 * @version 1.0.0
 *
 */
public interface ViewLoader {

	/**
	 * Получение объекта {@linkplain SimpleView} по имени файла-модели.
	 * <p>
	 * 
	 * @param fileName
	 *            - имя файла; не может быть {@code null} или
	 *            {@code String#isEmpty()}.
	 * @return может быть {@code null}.
	 * @throws IOException
	 */
	@Null
	SimpleView load(@NotNull @NotEmpty String fileName) throws IOException;
}
