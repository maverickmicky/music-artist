package com.abhinav.service.external;

public interface WikiService {

	static final String PATH_PARAM = "_wikiTitle_";
	String getArtistDescription(String wikiTitle);
}
