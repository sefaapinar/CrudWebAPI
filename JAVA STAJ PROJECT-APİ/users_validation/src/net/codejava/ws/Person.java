package net.codejava.ws;

public class Person {
	@Override
	public String toString() {
		return "Person [userID=" + userID + ", UserName=" + UserName + ", Password=" + Password + "]";
	}
	private int userID;
	private String UserName;
	private String Password;
	public Person() {
		
	}
	public Person(String userName, String password) {
		
		
		UserName = userName;
		Password = password;
	}
	public Person(int userID, String userName, String password) {
	
		this.userID = userID;
		UserName = userName;
		Password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (userID != other.userID)
			return false;
		return true;
	}
	
}
