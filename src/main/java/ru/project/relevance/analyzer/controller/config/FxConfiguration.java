package ru.project.relevance.analyzer.controller.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ru.project.relevance.analyzer.controller.ActualizeController;
import ru.project.relevance.analyzer.controller.AddingController;
import ru.project.relevance.analyzer.controller.AssessmentController;
import ru.project.relevance.analyzer.controller.ChangingController;
import ru.project.relevance.analyzer.controller.SetUpController;
import ru.project.relevance.analyzer.controller.loader.ViewLoader;
import ru.project.relevance.analyzer.controller.model.SimpleView;
import ru.project.relevance.analyzer.props.Properties;

@Configuration
public class FxConfiguration {

	@Autowired
	private ViewLoader loader;

	@Autowired
	private Properties props;

	@Bean("setupView")
	@Primary
	public SimpleView getSetUpView() throws IOException {
		return loader.load(props.getProperty("setUp.view.location"));
	}

	@Bean
	public SetUpController getSetUpController() throws IOException {
		return (SetUpController) getSetUpView().getController();
	}

	@Bean("assessmentView")
	public SimpleView getAssessmentView() throws IOException {
		return loader.load(props.getProperty("assessment.view.location"));
	}

	@Bean
	public AssessmentController getAssessmentController() throws IOException {
		return (AssessmentController) getAssessmentView().getController();
	}

	@Bean("changingView")
	public SimpleView getChangingView() throws IOException {
		return loader.load(props.getProperty("changing.view.location"));
	}

	@Bean
	public ChangingController getChangingController() throws IOException {
		return (ChangingController) getChangingView().getController();
	}

	@Bean("actualizeView")
	public SimpleView getActualizeView() throws IOException {
		return loader.load(props.getProperty("actualize.view.location"));
	}

	@Bean
	public ActualizeController getActualizeController() throws IOException {
		return (ActualizeController) getActualizeView().getController();
	}

	@Bean("addingView")
	public SimpleView getAddingView() throws IOException {
		return loader.load(props.getProperty("adding.view.location"));
	}

	@Bean
	public AddingController getAddingController() throws IOException {
		return (AddingController) getAddingView().getController();
	}
}
