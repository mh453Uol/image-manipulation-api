package com.mh453Uol.image_manipulation_api.core.effects;

import java.awt.image.BufferedImage;

public class Rotate implements Effect {
	private Effects rotate_degrees;

	public Rotate(Effects rotation) {
		this.rotate_degrees = rotation;
	}

	@Override
	public BufferedImage transform(BufferedImage image) {

		switch (rotate_degrees) {
			case ROTATE_90_DEGREES: {
				image = rotate90DegreesClockwise(image);
				break;
			}
			case ROTATE_180_DEGREES: {
				image = rotate180DegreesClockwise(image);
				break;
			}
			case ROTATE_270_DEGREES: {
				image = rotate270DegreesClockwise(image);
				break;
			}
		}
		
		return image;
	}

	public BufferedImage rotate90DegreesClockwise(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		int pixel;
		BufferedImage rotated = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				pixel = image.getRGB(x, y);
				rotated.setRGB(height - y - 1, x, pixel);
			}
		}
		return rotated;
	}

	public BufferedImage rotate180DegreesClockwise(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		int pixel;
		BufferedImage rotated = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int y = 0, yBottom = (height - 1); y < height; y++, yBottom--) {
			for (int x = 0, xRight = (width - 1); x < width; x++, xRight--) {
				pixel = image.getRGB(x, y);
				rotated.setRGB(xRight, yBottom, pixel);
			}
		}
		return rotated;
	}
	
	public BufferedImage rotate270DegreesClockwise(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		int pixel;
		BufferedImage rotated = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				pixel = image.getRGB(x, y);
				rotated.setRGB(y, x, pixel);
			}
		}
		return rotated;
	}

}
