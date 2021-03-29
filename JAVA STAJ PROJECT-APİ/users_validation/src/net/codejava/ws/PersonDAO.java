package net.codejava.ws;

import java.util.List;
import java.util.ArrayList;

public class PersonDAO {
	private static PersonDAO instance;
	private static List<Person> data = new ArrayList<>();
	
	static {
		data.add(new Person(1,"Sefa","12345"));
		data.add(new Person(2,"Ýrem","12345"));
		data.add(new Person(3,"Fatih","2345"));
		data.add(new Person(4,"Mehmet","1f21f"));
		data.add(new Person(5,"Osman","5442g1d"));
	}
	private PersonDAO() {}
		public static PersonDAO getInstance() {
			if(instance==null) {
				instance = new PersonDAO();
			}
			return instance;
		}
	public List<Person>ListAll(){
		return new ArrayList<Person>(data);
	}
	
	public int add(Person person) {
		int newID = data.size()+1;
		person.setUserID(newID);
		data.add(person);
		
		return newID;
	}
	
	public Person get(int userID) {
		Person personToFind = new Person(userID, null, null);
		int index = data.indexOf(personToFind);
		if(index>=0) {
			return data.get(index);
			
		}
		return null;
	}
	public boolean update(Person person) {
		int index = data.indexOf(person);
		if(index>=0) {
			data.set(index, person);
			return true;
		}
		return false;
	}
	public boolean delete(int userID) {

			Person personToFind = new Person(userID, null, null);
			
			int index = data.indexOf(personToFind);
			if(index>=0) {
				data.remove(index);
				return true;
				
			}
			return false;
	}
}
