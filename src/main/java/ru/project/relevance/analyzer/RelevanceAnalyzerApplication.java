package ru.project.relevance.analyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.stage.Stage;
import ru.project.relevance.analyzer.props.Properties;

@SpringBootApplication
public class RelevanceAnalyzerApplication extends JavaFxApplication {

	@Autowired
	private Properties props;

	public static void main(String[] args) {
		startApplication(RelevanceAnalyzerApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(this.props.getProperty("fx.ui.title"));
	}
}
