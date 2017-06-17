package ru.project.relevance.analyzer.controller.loader.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import javafx.fxml.FXMLLoader;
import ru.project.relevance.analyzer.controller.loader.ViewLoader;
import ru.project.relevance.analyzer.controller.model.SimpleView;

@Service
public class ViewLoaderImpl implements ViewLoader {

	@Override
	public SimpleView load(String fileName) throws IOException {
		InputStream stream = null;
		FXMLLoader loader = null;
		try {
			stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
			loader = new FXMLLoader();
			loader.load(stream);
			return new SimpleView(loader.getController(), loader.getRoot());
		} finally {
			if (stream != null)
				stream.close();
		}
	}

}
