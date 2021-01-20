package test;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;


@Path(value = "hello")
public class Hello {

	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello()
	{
		String resource=",?xml version='1.0'?>"+
	"<hello> Hi its Fasih here hi from xml </hello>";
		return resource;
	}
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJASON()
	{
		String resource=null;
		return resource;
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML()
	{
		String resource="<h1> hi its Fasih here hi from html </h1>";
		return resource;
		
	}
*/	
}

