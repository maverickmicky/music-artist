package com.abhinav.service.handler.json;

import java.util.Map;

public class WikiQuery {
	public Map<String, Map<String, String>> pages;
	
	@Override
	public String toString() {
		return String.format("WikiQuery [pages=%s]", pages);
	}
}
