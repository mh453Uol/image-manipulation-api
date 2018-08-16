package com.mh453Uol.image_manipulation_api.core;

import java.awt.image.BufferedImage;

import com.mh453Uol.image_manipulation_api.core.filters.Filter;

public class Image {
	private Filter filter;
	private BufferedImage image;

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public BufferedImage getImage() {
		image = filter.transform(image);
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
