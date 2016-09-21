package com.abhinav.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.abhinav.service.external.MusicBrainzService;

@RunWith(SpringRunner.class)
@RestClientTest(MusicBrainzService.class)
@Ignore
public class MusicBrainzServiceTest {

	@Autowired
	private MusicBrainzService service;
	
	@Autowired
	private MockRestServiceServer server;
	
	@Test
    public void getProfileFromMB()
            throws Exception {
//        this.server.expect(requestTo(Mockito.anyString()))
//                .andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));
//        String greeting = this.service.getArtistProfile("");
//        assertThat(greeting).isEqualTo("hello");
    }
}
