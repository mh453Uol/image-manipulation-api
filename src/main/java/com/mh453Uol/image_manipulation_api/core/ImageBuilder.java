package com.mh453Uol.image_manipulation_api.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.mh453Uol.image_manipulation_api.core.effects.Effects;
import com.mh453Uol.image_manipulation_api.core.effects.Flip;
import com.mh453Uol.image_manipulation_api.core.effects.MirrorImage;
import com.mh453Uol.image_manipulation_api.core.effects.Rotate;
import com.mh453Uol.image_manipulation_api.core.filters.BinaryImage;
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
		switch (filter) {
			case GRAYSCALE: {
				image.setFilter(new Grayscale());
				break;
			}
			case BINARYIMAGE: {
				image.setFilter(new BinaryImage());
				break;
			}
		}
		return this;
	}

	@Override
	public IImageBuilder effect(Effects effect) {
		switch (effect) {
			case MIRROR_IMAGE: {
				image.setEffect(new MirrorImage());
				break;
			}
			case FLIP: {
				image.setEffect(new Flip());
				break;
			}
			case ROTATE_90_DEGREES : {
				image.setEffect(new Rotate(Effects.ROTATE_90_DEGREES));
			}
			case ROTATE_180_DEGREES: {
				image.setEffect(new Rotate(Effects.ROTATE_180_DEGREES));
			}
			case ROTATE_270_DEGREES: {
				image.setEffect(new Rotate(Effects.ROTATE_270_DEGREES));
			}
		}
		return this;
	}

}
