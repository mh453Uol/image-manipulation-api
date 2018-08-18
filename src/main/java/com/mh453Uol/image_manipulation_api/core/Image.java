package com.mh453Uol.image_manipulation_api.core;

import java.awt.image.BufferedImage;

import com.mh453Uol.image_manipulation_api.core.effects.Effect;
import com.mh453Uol.image_manipulation_api.core.filters.Filter;

public class Image {
	private Filter filter;
	private BufferedImage image;
	private Effect effect;
	
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public BufferedImage getImage() {
		
		if(filter != null) {			
			image = filter.transform(image);
		}
		
		if(effect != null) {
			image = effect.transform(image);
		}
		
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void setEffect(Effect effect) {
		this.effect =  effect;
	}
}
