package com.abhinav.service.controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.service.dto.Album;
import com.abhinav.service.dto.MusicArtistProfile;
import com.abhinav.service.external.CoverArtService;
import com.abhinav.service.external.MusicBrainzService;
import com.abhinav.service.external.WikiService;
import com.abhinav.service.handler.json.MBProfile;

@RestController
@Validated
@RequestMapping("/viaplay/music-artist")
public class MusicArtistController {
	private static final Logger logger = LoggerFactory.getLogger(MusicArtistController.class);

	@Autowired
	MusicBrainzService mbService;

	@Autowired
	WikiService wikiService;

	@Autowired
	CoverArtService caService;

	@RequestMapping(value = "/details/{mbid}", method = RequestMethod.GET, produces = "application/json")
	public MusicArtistProfile getArtistDetails(@NotNull @PathVariable String mbid) {
		MBProfile mbProfile = mbService.getArtistProfile(mbid);

		String wikiTitle = mbProfile.relations.stream()
											.filter(relation -> relation.type.equals("wikipedia"))
											.findFirst().get().url.resource;
		String artistDesc = wikiService.getArtistDescription(wikiTitle.split("http://en.wikipedia.org/wiki/")[1]);

		MusicArtistProfile profile = new MusicArtistProfile();
		profile.description = artistDesc;
		profile.mbid = mbid;
		profile.name = mbProfile.name;
		profile.country = mbProfile.country;
		profile.gender = mbProfile.gender;
		profile.disambiguation = mbProfile.disambiguation;
		profile.albums = new ArrayList<Album>();

		mbProfile.releaseGroups.stream()
							.forEach(relGroup -> profile.albums.add(caService.getFrontCoverImageById(relGroup)));
		return profile;
	}

}
