package com.abhinav.service.external.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.abhinav.service.external.WikiService;
import com.abhinav.service.handler.json.WikiInfo;

@Service
public class WikiServiceImpl extends AbstractService implements WikiService{

	@Async
	public String getArtistDescription(String wikiTitle) {
		try {
			WikiInfo wikiProfile = template.getForEntity(config.getWikiUrl().replace(PATH_PARAM, wikiTitle), WikiInfo.class).getBody();
			return wikiProfile.query.pages.entrySet()
										.stream()
										.findFirst()
										.get()
										.getValue().get("extract");
		} catch (Exception e) {
			return "Wiki info not found";
		}
	}
}
