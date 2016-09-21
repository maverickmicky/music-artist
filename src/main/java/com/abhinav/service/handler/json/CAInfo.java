package com.abhinav.service.handler.json;

import java.util.List;

public class CAInfo {

	public List<CAImage> images;

	@Override
	public String toString() {
		return String.format("CAInfo [images=%s]", images);
	}

}
