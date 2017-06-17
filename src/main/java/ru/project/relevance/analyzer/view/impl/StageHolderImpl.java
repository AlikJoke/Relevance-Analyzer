package ru.project.relevance.analyzer.view.impl;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import javafx.stage.Stage;
import ru.project.relevance.analyzer.view.StageHolder;

@Component
public class StageHolderImpl implements StageHolder {

	private Stage stage;

	@Override
	public Stage getStage() {
		return this.stage;
	}

	@Override
	public void holdStage(Stage stageToHold) {
		this.stage = stageToHold;
	}

	@PreDestroy
	public void destroy() {
		this.stage.close();
	}
}
