package com.abhinav.service.handler.json;

public class MBRelation {
	public String type;
	public MBRelationUrl url;

	@Override
	public String toString() {
		return String.format("Relation [type=%s, url=%s]", type, url);
	}

}