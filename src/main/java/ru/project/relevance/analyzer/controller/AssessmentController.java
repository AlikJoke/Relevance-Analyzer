package ru.project.relevance.analyzer.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import ru.project.relevance.analyzer.RelevanceAnalyzerApplication;
import ru.project.relevance.analyzer.loader.LoaderService;
import ru.project.relevance.analyzer.loader.model.Data;

public class AssessmentController extends BaseController {

	@FXML
	private LineChart<String, Integer> chart;

	@Autowired
	private LoaderService loader;

	@Override
	@PostConstruct
	public void init() {

	}

	@Override
	public void back() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("setupView");
	}

	public void buildLineChart(String key) {
		chart.getData().clear();
		chart.setAccessibleText(key);
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
		series.setName(key);
		try {
			for (Data data : loader.loadToObjects(key))
				series.getData().add(new XYChart.Data<String, Integer>(data.getYear(), data.getCount()));
		} catch (Exception e) {
			// TODO
		}
		chart.getData().add(series);
	}
}
