package com.dnd.party.dndOffApi.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface DnDOffCrawler {

	
	public List<HashMap<String, String>> getData() throws IOException, ParseException;
	
}
