package net.codejava.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;



public class PersonClient {
	private static String baseURI="http://localhost/users_validation/rest/persons";
	
	public static void main(String[] args) {
		testList();
		//testGet();
		//testAdd();
		testUpdate();
		testList();
		testDelete();
		
	}
	static void testDelete() {
		WebTarget target = getWebTarget();
		String userID="1";
		Response response = target.path(userID).request().delete(Response.class);
		
		
		System.out.println(response);
	}
	static void testUpdate() {
		WebTarget target = getWebTarget();
		String userID="77";
		Person person = new Person(7, "Salih","4781");
		Response response = target.path(userID).request().put(Entity.entity(person,MediaType.APPLICATION_JSON),Response.class);
		
		System.out.println(response);
	}
	static void testAdd() {
		WebTarget target = getWebTarget();
		Person person = new Person(7, "Selim","4321");
		Response response = target.request().post(Entity.entity(person,MediaType.APPLICATION_JSON),Response.class);
		
		System.out.println(response.getLocation().toString());
	}
	static void testGet() {
		WebTarget target = getWebTarget();
		String userID="1";
		Person person = target.path(userID).request().accept(MediaType.APPLICATION_JSON).get(Person.class);
		
		System.out.println(person);
		
		}
	static void testList() {
		WebTarget target = getWebTarget();
		String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		
		System.out.print(response);
	}
	static WebTarget getWebTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		return client.target(baseURI);
	}

}
