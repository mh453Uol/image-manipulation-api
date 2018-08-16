package com.mh453Uol.image_manipulation_api.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.mh453Uol.image_manipulation_api.core.filters.Filters;
import com.mh453Uol.image_manipulation_api.core.filters.Grayscale;

public class ImageBuilder implements IImageBuilder {
	private Image image;
	
	public ImageBuilder(InputStream stream) throws IOException {
		image = new Image();
		image.setImage(ImageIO.read(stream));
	}
	
	@Override
	public BufferedImage build() {
		return image.getImage();
	}

	@Override
	public IImageBuilder filter(Filters filter) {
		switch(filter) {
			case GRAYSCALE:{
				image.setFilter(new Grayscale());
				break;
			}
		}
		return this;
	}

}
