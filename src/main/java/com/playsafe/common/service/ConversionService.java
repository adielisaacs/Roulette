package com.playsafe.common.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/conversions")
public class ConversionService {

	@GET
	@Path("/ktoc/{param}")
	public Response getCelsiusValue(@PathParam("param") String msg) {

		String output = "Converting kelvin to Celsius is : " + (new Integer(msg) - 273)+"*";

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/ctok/{param}")
	public Response getKelvin(@PathParam("param") String msg) {

		String output = "Converting celsius to Kelvin is : " + (new Double(msg) + 273)+"*";

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/mtok/{param}")
	public Response getKilometers(@PathParam("param") String msg) {

		String output = "Converting miles to Kilometers is : " + ((new Double(msg)/5)*8)+" km";

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/ktom/{param}")
	public Response getMiles(@PathParam("param") String msg) {

		String output = "Converting Kilometers to miles is : " + ((new Double(msg)/8)*5)+" miles";

		return Response.status(200).entity(output).build();

	}
}