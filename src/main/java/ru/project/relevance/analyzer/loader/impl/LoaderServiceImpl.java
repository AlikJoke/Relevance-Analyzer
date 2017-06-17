package ru.project.relevance.analyzer.loader.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;

import ru.project.relevance.analyzer.loader.LoaderService;
import ru.project.relevance.analyzer.loader.model.Data;
import ru.project.relevance.analyzer.props.Properties;

@Service
public class LoaderServiceImpl implements LoaderService {

	@Autowired
	private Properties props;

	@Override
	public List<Data> loadToObjects(String key) throws IOException {
		CSVReader reader = new CSVReader(new InputStreamReader(
				ClassLoader.getSystemResourceAsStream(props.getProperty("directory") + key + ".csv")));
		List<Data> dataList = Lists.newArrayList();
		String[] line;
		try {
			while ((line = reader.readNext()) != null)
				dataList.add(new Data(key.hashCode(), line[0], Integer.parseInt(line[1])));
		} finally {
			reader.close();
		}
		return dataList;
	}

	@Override
	public void loadToDB() {
		// TODO
	}

}
