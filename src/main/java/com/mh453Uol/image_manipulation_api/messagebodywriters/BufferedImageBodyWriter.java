package com.mh453Uol.image_manipulation_api.messagebodywriters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.imageio.ImageIO;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces({ "image/png", "image/jpg" })
public class BufferedImageBodyWriter implements MessageBodyWriter<BufferedImage> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return type == BufferedImage.class;
	}

	@Override
	public long getSize(BufferedImage t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1; //not used in JAX-RS 2
	}

	@Override
	public void writeTo(BufferedImage image, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		ImageIO.write(image,mediaType.getSubtype(), entityStream);
	}

}
