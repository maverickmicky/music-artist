package com.abhinav.service.handler.json;

public class CAImage {
	public String image;
	public Boolean front;

	@Override
	public String toString() {
		return String.format("CAImage [image=%s, front=%s]", image, front);
	}

}
