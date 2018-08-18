package com.mh453Uol.image_manipulation_api.core;

import java.awt.image.BufferedImage;

import com.mh453Uol.image_manipulation_api.core.effects.Effects;
import com.mh453Uol.image_manipulation_api.core.filters.Filters;

public interface IImageBuilder {
	public BufferedImage build();
	public IImageBuilder filter(Filters filter);
	public IImageBuilder effect(Effects effect);
	
}
