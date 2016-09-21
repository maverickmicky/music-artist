package com.abhinav.service.external.impl;

import org.springframework.stereotype.Service;

import com.abhinav.service.exception.ServiceException;
import com.abhinav.service.external.MusicBrainzService;
import com.abhinav.service.handler.json.MBProfile;

@Service
public class MusicBrainzServiceImple extends AbstractService implements MusicBrainzService {

	public MBProfile getArtistProfile(String mbid) {
		try {
			return template.getForEntity(config.getMbUrl().replace(PATH_PARAM, mbid), MBProfile.class).getBody();
		} catch (Exception e) {
			throw new ServiceException("mbid.not.found");
		}
	}

}
