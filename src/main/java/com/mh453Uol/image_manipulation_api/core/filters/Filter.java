package com.mh453Uol.image_manipulation_api.core.filters;

import java.awt.image.BufferedImage;

public interface Filter {
	BufferedImage transform(BufferedImage image);
}
