package ru.project.relevance.analyzer.loader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.opencsv.CSVReader;

import ru.project.relevance.analyzer.loader.model.Data;

/**
 * Интерфейс для операций загрузки файла в хранилище.
 * 
 * @author Alimurad A. Ramazanov
 * @since 17.06.2017
 * @version 1.0.0
 *
 */
public interface LoaderService {

	/**
	 * Выгрузка файла в формате csv или xls в список объектов.
	 * <p>
	 * 
	 * @see CSVReader
	 * @see Data
	 * @throws IOException
	 * @return список объектов для загрузки.
	 */
	@NotNull
	List<Data> loadToObjects(@NotNull @NotEmpty String key) throws IOException;

	/**
	 * Загрузка файла в формате csv или xls в БД.
	 * <p>
	 * 
	 * @see File
	 */
	void loadToDB();
}
