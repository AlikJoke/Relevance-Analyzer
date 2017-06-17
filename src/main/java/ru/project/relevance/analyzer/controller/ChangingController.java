package ru.project.relevance.analyzer.controller;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.util.StringUtils;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import ru.project.relevance.analyzer.RelevanceAnalyzerApplication;

public class ChangingController extends BaseController {

	@FXML
	private ChoiceBox<String> choiceBox;

	@Override
	@PostConstruct
	public void init() {
		choiceBox.setTooltip(new Tooltip("Select the direction"));
		this.updateChoiceBox();
	}

	@Override
	public void back() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("setupView");
	}

	@FXML
	public void actualize() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("actualizeView");
	}

	@FXML
	public void addDirection() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("addingView");
	}

	protected void updateChoiceBox() {
		choiceBox.setItems(FXCollections.<String>observableArrayList(this.directionHolder.getDirections()
				.parallelStream().filter(direction -> direction != null && StringUtils.hasLength(direction.getName()))
				.map(direction -> direction.getName()).collect(Collectors.toList())));
	}

}
