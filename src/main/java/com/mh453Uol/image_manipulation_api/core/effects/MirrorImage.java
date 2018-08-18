package com.mh453Uol.image_manipulation_api.core.effects;

import java.awt.image.BufferedImage;

public class MirrorImage implements Effect {

	@Override
	public BufferedImage transform(BufferedImage image) {
		// To create a mirror image do
		// 1. create a buffered image where its width is x 2 the original width
		// 2. From x to width (LEFT to RIGHT) and (width * 2)-1 to 0 (RIGHT to LEFT)

		// -------------------
		// |X 		| 		X |
		// <XLEFT> 		<XRIGHT>
		// For the left image we start from the top left corner (X)
		// For the right image we start from top right corner
		int width = image.getWidth();
		int height = image.getHeight();
		int pixel;
		BufferedImage mirrorEffect = new BufferedImage(width * 2, height, BufferedImage.TYPE_INT_ARGB);

		for (int xLeft = 0, xRight = (width * 2) - 1; xLeft < width; xLeft++, xRight--) {
			for (int y = 0; y < height; y++) {
				pixel = image.getRGB(xLeft, y);
				mirrorEffect.setRGB(xLeft, y, pixel);
				mirrorEffect.setRGB(xRight, y, pixel);
			}
		}
		
		return mirrorEffect;
	}

}
