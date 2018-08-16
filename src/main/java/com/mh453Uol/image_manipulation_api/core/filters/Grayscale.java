package com.mh453Uol.image_manipulation_api.core.filters;

import java.awt.image.BufferedImage;

public class Grayscale implements Filter {

	@Override
	public BufferedImage transform(BufferedImage image) {
		// Grayscale: for each pixel do (R+G+B)/3
		// Pixel: OPAQUE (8 BITS) . RED (B BITS) . GREEN (8 BITS) . BLUE (8 BITS)
		int pixel;
		int alpha;
		int red;
		int green;
		int blue;
		int average;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				pixel = image.getRGB(x, y);
				alpha = (pixel & 0xff000000) >> 24;
				red = (pixel & 0Xff0000) >> 16;
				green = (pixel & 0x00ff00) >> 8;
				blue = (pixel & 0x0000ff);
				average = (red + green + blue) / 3;
				pixel = alpha << 24 | average << 16 | average << 8 | average;

				image.setRGB(x, y, pixel);
			}
		}
		return image;
	}

}
