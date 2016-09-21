package com.abhinav.service.handler.json;

public class MBReleaseGroup {

	public String id;
	public String title;

	@Override
	public String toString() {
		return String.format("MBReleaseGroup [id=%s, title=%s]", id, title);
	}
}
