package com.mh453Uol.image_manipulation_api.core.effects;

import java.awt.image.BufferedImage;

public class Flip implements Effect {

	@Override
	public BufferedImage transform(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int pixel;
		BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int xLeft = 0, xRight = width - 1; xLeft < width; xLeft++, xRight--) {
			for (int y = 0; y < height; y++) {
				pixel = image.getRGB(xLeft, y);
				flippedImage.setRGB(xRight, y, pixel);
			}
		}
		return flippedImage;
	}

}
