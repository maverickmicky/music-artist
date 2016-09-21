package com.abhinav.service.external;

import com.abhinav.service.handler.json.MBProfile;

public interface MusicBrainzService {

	static final String PATH_PARAM = "_mbid_";
	MBProfile getArtistProfile(String mbid);
}
