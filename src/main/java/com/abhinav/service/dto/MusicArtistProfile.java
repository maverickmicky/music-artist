package com.abhinav.service.dto;

import java.util.List;

public class MusicArtistProfile {

	public String mbid;
	public String name;
	public String gender;
	public String country;
	public String disambiguation;
	public String description;
	public List<Album> albums;

	@Override
	public String toString() {
		return String.format("MusicArtist [mbid=%s, name=%s, description=%s, albums=%s]", mbid, name, description,
				albums);
	}
}
