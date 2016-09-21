package com.abhinav.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhinav.service.dto.MusicArtistProfile;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MusicServiceControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetDetailsHappyCase() throws Exception {
		MusicArtistProfile body = this.restTemplate.getForObject(
				"/viaplay/music-artist/details/f27ec8db-af05-4f36-916e-3d57f91ecf5e", MusicArtistProfile.class);
		assertThat(body.country).isEqualTo("US");
	}
	
	@Test
	public void testGetDetailsNullCase() throws Exception {
		MusicArtistProfile body = this.restTemplate.getForObject(
				"/viaplay/music-artist/details/", MusicArtistProfile.class);
		assertThat(body.country).isNull();
	}

}
