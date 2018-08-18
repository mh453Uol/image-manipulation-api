package com.mh453Uol.image_manipulation_api.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mh453Uol.image_manipulation_api.core.ImageBuilder;
import com.mh453Uol.image_manipulation_api.core.effects.Effects;

@Path("/")
public class EffectResource {
	
	@Path("/mirrorimage")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response addMirrorImageEffect(InputStream inputImage) throws IOException {
		
		BufferedImage image = new ImageBuilder(inputImage)
				.effect(Effects.MIRROR_IMAGE)
				.build();
		
		return Response.ok(image).build();
	}
	
	@Path("/flip")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response addFlipImageEffect(InputStream inputImage) throws IOException {
		
		BufferedImage image = new ImageBuilder(inputImage)
				.effect(Effects.FLIP)
				.build();
		
		return Response.ok(image).build();
	}
	
	
}
