package com.abhinav.service.external;

import com.abhinav.service.dto.Album;
import com.abhinav.service.handler.json.MBReleaseGroup;

public interface CoverArtService {

	static final String PATH_PARAM = "_id_";
	Album getFrontCoverImageById(MBReleaseGroup relGrp);
}
