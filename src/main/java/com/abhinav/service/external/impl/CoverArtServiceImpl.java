package com.abhinav.service.external.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.abhinav.service.dto.Album;
import com.abhinav.service.external.CoverArtService;
import com.abhinav.service.handler.json.CAInfo;
import com.abhinav.service.handler.json.MBReleaseGroup;

@Service
public class CoverArtServiceImpl extends AbstractService implements CoverArtService {

	@Async
	public Album getFrontCoverImageById(MBReleaseGroup relGrp) {
		Album album = new Album();
		album.id = relGrp.id;
		album.title = relGrp.title;
		try {
			CAInfo caProfile = template.getForEntity(config.getCaUrl().replace(PATH_PARAM, relGrp.id), CAInfo.class).getBody();
			album.imageUrl = caProfile.images.stream()
											.filter(image -> image.front.booleanValue())
											.findFirst()
											.get().image;
		} catch (Exception e) {
			album.imageUrl = "Front cover art not found";
		}
		return album;
	}
}
