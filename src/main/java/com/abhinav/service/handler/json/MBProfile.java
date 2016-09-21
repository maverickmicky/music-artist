package com.abhinav.service.handler.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MBProfile {

	public String country;
	public String name;
	public String gender;
	public String disambiguation;
	public List<MBRelation> relations;
	@JsonProperty(value="release-groups")
	public List<MBReleaseGroup> releaseGroups;

	@Override
	public String toString() {
		return String.format(
				"MBProfile [country=%s, name=%s, gender=%s, disambiguation=%s, relations=%s, releaseGroups=%s]",
				country, name, gender, disambiguation, relations, releaseGroups);
	}

}
