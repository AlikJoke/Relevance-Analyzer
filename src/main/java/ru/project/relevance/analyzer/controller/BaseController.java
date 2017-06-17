package ru.project.relevance.analyzer.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.fxml.FXML;
import ru.project.relevance.analyzer.RelevanceAnalyzerApplication;
import ru.project.relevance.analyzer.db.model.DirectionHolder;

/**
 * Базовый контроллер.
 * 
 * @author Alimurad A. Ramazanov
 * @since 17.06.2017
 * @version 1.0.0
 *
 */
public abstract class BaseController {
	
	@Autowired
	protected DirectionHolder directionHolder;
	
	/**
	 * Метод инициализации бинов, наследующий данный класс.
	 * <p>
	 * 
	 * @see PostConstruct
	 */
	public abstract void init();

	/**
	 * Метод инициализации объекта-контроллера.
	 */
	@FXML
	public void initialize() {

	}

	/**
	 * Метод выхода из программы.
	 * <p>
	 * 
	 * @see System
	 */
	@FXML
	public void exit() {
		System.runFinalization();
		System.exit(0);
	}

	/**
	 * Метод, выполняющий переход на страницу, контроллер которой определяется
	 * по переданному имени.
	 * <p>
	 * 
	 * @see {@linkplain RelevanceAnalyzerApplication#gotoScene(String)}
	 */
	@FXML
	public abstract void back();
}
