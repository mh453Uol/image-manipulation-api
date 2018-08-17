package resources;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import com.mh453Uol.image_manipulation_api.resources.FilterResource;

public class FilterResourcesTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(FilterResource.class);
	}
}
