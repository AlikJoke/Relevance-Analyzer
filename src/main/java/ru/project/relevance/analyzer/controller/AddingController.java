package ru.project.relevance.analyzer.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.project.relevance.analyzer.RelevanceAnalyzerApplication;
import ru.project.relevance.analyzer.view.StageHolder;

public class AddingController extends BaseController {

	@Autowired
	private SetUpController setUpController;

	@Autowired
	private StageHolder stageHolder;

	@Autowired
	private ChangingController changingController;

	@FXML
	private TextField name;

	@Override
	@PostConstruct
	public void init() {
		name.setTooltip(new Tooltip("Enter the name of direction"));
	}

	@Override
	public void back() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("changingView");
	}

	@FXML
	public void save() {
		if (StringUtils.hasLength(this.name.getText())) {
			boolean isLoaded = this.directionHolder.loadDirection(name.getText());

			if (isLoaded) {
				this.name.setText("");

				this.changingController.updateChoiceBox();
				this.setUpController.updateChoiceBox();
			} else {
				createWarningWindow("Direction with the same name is exists! \nEnter another name!");
			}
		} else {
			createWarningWindow("Name of direction can't be empty!");
		}
	}

	private void createWarningWindow(String text) {
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.initOwner(stageHolder.getStage());
		VBox dialogVbox = new VBox(20);
		dialogVbox.getChildren().add(new Text(text));
		Scene dialogScene = new Scene(dialogVbox, 220, 50);
		dialog.setScene(dialogScene);
		dialog.centerOnScreen();
		dialog.show();
	}
}
