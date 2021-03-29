package net.codejava.ws;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/persons")

public class PersonResource {
	private PersonDAO dao=PersonDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> list(){
		return dao.ListAll();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Person person) throws URISyntaxException {
		int newPersonuserID = dao.add(person);
		URI uri = new URI("/user_validation/rest/persons/" + newPersonuserID);
		return Response.created(uri).build();
	}
	@GET
	@Path("{userID}")
	public Response get(@PathParam("userID")int userID) {
		Person person =dao.get(userID);
		if(person !=null) {
			return Response.ok(person,MediaType.APPLICATION_JSON).build();
		}else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{userID}")
	public Response update(@PathParam("userID")int userID, Person person) {
		person.setUserID(userID);
		if(dao.update(person)) {
			return Response.ok().build();
		}else {
			return Response.notModified().build();
		}
	}
	
	@DELETE
	@Path("{userID)")
	public Response delete(@PathParam("userID")int userID, Person person) {
		if(dao.delete(userID)) {
			return Response.ok().build();
		}else {
			return Response.notModified().build();
		}
	}
	
	
}
