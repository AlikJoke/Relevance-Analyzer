package ru.project.relevance.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.project.relevance.analyzer.controller.model.SimpleView;
import ru.project.relevance.analyzer.props.Properties;
import ru.project.relevance.analyzer.view.StageHolder;

@SpringBootApplication
public class RelevanceAnalyzerApplication extends JavaFxApplication {

	@Autowired
	private Properties props;

	@Autowired
	private SimpleView view;

	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private StageHolder stageHolder;

	private static RelevanceAnalyzerApplication instance;

	public RelevanceAnalyzerApplication() {
		instance = this;
	}

	public static RelevanceAnalyzerApplication getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		startApplication(RelevanceAnalyzerApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stageHolder.holdStage(primaryStage);
		primaryStage.setTitle(this.props.getProperty("fx.ui.title"));
		primaryStage.setScene(new Scene(view.getView()));
		primaryStage.setResizable(true);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public void gotoScene(final String beanName) {
		SimpleView view = ctx.getBean(beanName, SimpleView.class);
		if (view == null)
			throw new IllegalArgumentException("View can't be null! Check bean name!");

		Parent page = view.getView();
		stageHolder.getStage().getScene().setRoot(page);
		stageHolder.getStage().sizeToScene();
	}
}
