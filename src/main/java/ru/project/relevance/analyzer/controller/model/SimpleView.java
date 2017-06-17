package ru.project.relevance.analyzer.controller.model;

import javafx.scene.Parent;
import ru.project.relevance.analyzer.controller.BaseController;

/**
 * Связка представление - контроллер.
 * 
 * @author Alimurad A. Ramazanov
 * @since 17.06.2017
 * @version 1.0.0
 *
 */
public class SimpleView {

	private BaseController controller;
	private Parent view;

	public BaseController getController() {
		return controller;
	}

	public void setController(BaseController controller) {
		this.controller = controller;
	}

	public Parent getView() {
		return view;
	}

	public void setView(Parent view) {
		this.view = view;
	}

	public SimpleView(BaseController controller, Parent view) {
		super();
		this.controller = controller;
		this.view = view;
	}

	public SimpleView() {
		super();
	}
}
