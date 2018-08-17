package com.mh453Uol.image_manipulation_api.resources;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mh453Uol.image_manipulation_api.core.ImageBuilder;
import com.mh453Uol.image_manipulation_api.core.filters.Filter;
import com.mh453Uol.image_manipulation_api.core.filters.Filters;

/*
 * Incoming request look as follows /api/images/filter
 */
@Path("/")
public class FilterResource {
	
	@Path("grayscale")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response filterToGrayscale(InputStream inputStream) throws IOException {
		BufferedImage image = new ImageBuilder(inputStream)
			.filter(Filters.GRAYSCALE)
			.build();
		
		return Response.ok(image).build();
	}
	
	@Path("binaryimage")
	@POST
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces({ "image/png", "image/jpg" })
	public Response filterToBinaryImage(InputStream inputStream) throws IOException {

		BufferedImage image = new ImageBuilder(inputStream)
				.filter(Filters.BINARYIMAGE)
				.build();
		
		return Response.ok(image).build();
	}
}
