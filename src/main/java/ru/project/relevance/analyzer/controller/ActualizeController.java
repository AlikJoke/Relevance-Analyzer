package ru.project.relevance.analyzer.controller;

import ru.project.relevance.analyzer.RelevanceAnalyzerApplication;

public class ActualizeController extends BaseController {

	@Override
	public void init() {

	}

	@Override
	public void back() {
		RelevanceAnalyzerApplication.getInstance().gotoScene("changingView");
	}

}
