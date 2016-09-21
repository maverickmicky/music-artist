package com.abhinav.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

	@Value("${musicbrainz.url}")
	private String mbUrl;

	@Value("${wiki.url}")
	private String wikiUrl;

	@Value("${coverartarchive.url}")
	private String caUrl;

	public String getMbUrl() {
		return mbUrl;
	}

	public String getWikiUrl() {
		return wikiUrl;
	}

	public String getCaUrl() {
		return caUrl;
	}

}
