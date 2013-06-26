package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/MyServices")
public class Services {
	@GET
	@Produces("text/plain")
	public String getName(){
		return "sukumar sen";
	}
	@GET
	@Path("/subpath")
	public String getVersion(){
		return "version 1.2.3";
	}
}
