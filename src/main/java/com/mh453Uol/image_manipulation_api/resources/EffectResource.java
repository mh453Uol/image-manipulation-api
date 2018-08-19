package com.mh453Uol.image_manipulation_api.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mh453Uol.image_manipulation_api.core.ImageBuilder;
import com.mh453Uol.image_manipulation_api.core.effects.Effects;

@Path("/")
public class EffectResource {

	@Path("/mirrorimage")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response addMirrorImageEffect(InputStream inputImage) throws IOException {

		BufferedImage image = new ImageBuilder(inputImage).effect(Effects.MIRROR_IMAGE).build();

		return Response.ok(image).build();
	}

	@Path("/flip")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response addFlipImageEffect(InputStream inputImage) throws IOException {

		BufferedImage image = new ImageBuilder(inputImage).effect(Effects.FLIP).build();

		return Response.ok(image).build();
	}

	@Path("/rotate/{clockwise_degree}")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response addRotateEffect(InputStream inputImage, @PathParam("clockwise_degree") int clockwise_degree)
			throws IOException {
		Effects rotation = null;

		if (clockwise_degree == 90) {
			rotation = Effects.ROTATE_90_DEGREES;
		} else if (clockwise_degree == 180) {
			rotation = Effects.ROTATE_180_DEGREES;
		} else if (clockwise_degree == 270) {
			rotation = Effects.ROTATE_270_DEGREES;
		}

		if (rotation == null) {
			Response.status(Status.BAD_REQUEST).build();
		}

		BufferedImage image = new ImageBuilder(inputImage).effect(rotation).build();

		return Response.ok(image).build();
	}

}
