package com.edu.educational_system.model;

public abstract class Person {
	protected String name;
	protected final String email;

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public abstract void performRole();

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getObfuscationCod (String s) {
		String answer = "" + s.hashCode();
		return answer;
	}
	public abstract String getRoleDescription();
}
