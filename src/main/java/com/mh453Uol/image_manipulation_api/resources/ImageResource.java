package com.mh453Uol.image_manipulation_api.resources;


import javax.ws.rs.Path;

@Path("images")
public class ImageResource {

	//Let sub resource handle this request
	@Path("/filter")
	public FilterResource getFilterResource() {
		return new FilterResource();
	}
	
}
