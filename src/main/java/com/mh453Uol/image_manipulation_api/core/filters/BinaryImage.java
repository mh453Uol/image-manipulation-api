package com.mh453Uol.image_manipulation_api.core.filters;

import java.awt.image.BufferedImage;

public class BinaryImage implements Filter {
	public static final byte THRESHOLD = 127;
	@Override
	public BufferedImage transform(BufferedImage image) {
		// To convert to a binary image
		// 1. Convert image to grayscale
		// 2. Iterate through each pixel p
		// 3. If p > threshold remember p is from (0-255) [BLACK -> WHITE]
		// a. Either return 0 (black) or 1 (white) for all RGB

		int pixel;
		int alpha;
		int red;
		int green;
		int blue;
		int average;
		int newBlackOrWhitePixel;
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				pixel = image.getRGB(x, y);
				alpha = (pixel & 0xff000000) >> 24;
				red = (pixel & 0Xff0000) >> 16;
				green = (pixel & 0x00ff00) >> 8;
				blue = (pixel & 0x0000ff);
				average = (red + green + blue) / 3;
				
				if(average > THRESHOLD) {
					newBlackOrWhitePixel = 0xffffffff; //255 is white
				} else {
					newBlackOrWhitePixel = 0xff000000;
				}

				image.setRGB(x, y, newBlackOrWhitePixel);
			}
		}
		return image;
	}

}
