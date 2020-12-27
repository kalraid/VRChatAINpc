package com.dnd.project.party.dndOffApi.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface DnDOffSeleniumCrawler {

	public List<HashMap<String, String>> getData() throws InterruptedException;
	
}
