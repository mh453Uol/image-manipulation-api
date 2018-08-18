package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.mh453Uol.image_manipulation_api.messagebodywriters.BufferedImageBodyWriter;
import com.mh453Uol.image_manipulation_api.resources.FilterResource;

public class FilterResourcesTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(FilterResource.class);
	}
	
	public void filterToGrayscale_WhenBodyContainsBinaryImageData_Returns201WithImage() {
		
		BufferedImage image = getGoogleLogoImage();
		
		Response response = target("/binaryimage")
				.request()
				.post(Entity.entity(image, MediaType.APPLICATION_OCTET_STREAM));
			
	}
	
	public BufferedImage getGoogleLogoImage() {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new URL("https://www.google.co.uk/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"));
		} catch (IOException e) {
			System.out.println("Couldnt get google logo");
			e.printStackTrace();
		}
		return image;
	}
}
