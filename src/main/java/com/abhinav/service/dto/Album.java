package com.abhinav.service.dto;

public class Album {
	public String id;
	public String title;
	public String imageUrl;
	@Override
	public String toString() {
		return String.format("Album [id=%s, title=%s, imageUrl=%s]", id, title, imageUrl);
	}
}
