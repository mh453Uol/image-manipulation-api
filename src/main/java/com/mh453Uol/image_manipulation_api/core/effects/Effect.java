package com.mh453Uol.image_manipulation_api.core.effects;

import java.awt.image.BufferedImage;

public interface Effect {
	public BufferedImage transform(BufferedImage image);
}
