package ru.project.relevance.analyzer.controller;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import ru.project.relevance.analyzer.RelevanceAnalyzerApplication;

public class SetUpController extends BaseController {

	@FXML
	private ChoiceBox<String> choiceBox;

	@Autowired
	private AssessmentController assessment;

	@Override
	@PostConstruct
	public void init() {
		choiceBox.setTooltip(new Tooltip("Select the direction"));
		this.updateChoiceBox();
	}

	@FXML
	private void assessment() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("assessmentView");
		assessment.buildLineChart(this.choiceBox.getValue());
	}

	@Override
	public void back() {
		throw new UnsupportedOperationException("This view is main. Can't back to previous page!");
	}

	@FXML
	public void changing() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("changingView");
	}

	protected void updateChoiceBox() {
		choiceBox.setItems(FXCollections.<String>observableArrayList(this.directionHolder.getDirections()
				.parallelStream().filter(direction -> direction != null && StringUtils.hasLength(direction.getName()))
				.map(direction -> direction.getName()).collect(Collectors.toList())));
	}
}
