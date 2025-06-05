package com.edu.educational_system.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private final String name;
	private final List<Person> participants;
	private final List<Person> managers;

	public Course(String name) {
		this.name = name;
		this.participants = new ArrayList<>();
		this.managers = new ArrayList<>();
	}
	
	public Course(String name, List<Person> participants, List<Person> managers) {
		this.name = name;
		this.participants = participants;
		this.managers = managers;
	}
	

	public String getName() {
		return name;
	}

	public boolean addParticipant(Person person) {
		if (person instanceof Student ) {
			for (Person p : participants) {
				if (p.getEmail().equals(person.getEmail()))
					return false;
			}
			return participants.add(person);
		} else if (person instanceof Teacher  || person instanceof Administrator ) {
			for (Person p : managers) {
				if (p.getEmail().equals(person.getEmail()))
					return false;
			}
			return managers.add(person);
		}
		return false;
	}

	public void conductLesson() {
		for (Person p : participants) {
			p.performRole();
		}
	}

	public double calculateAverageGrade() {
		int count = 0;
		double sum = 0.0;
		for (Person p : participants) {
			if (p instanceof Student s) {
				sum += s.getAverageGrade();
				count++;
			}
		}
		return count > 0 ? sum / count : 0.0;
	}
	
	public void obfuscationPaticipantsData() {
		
		for(Person p:participants) {
			p.setName(p.getObfuscationCod(p.getName()));
		}
	}

	public List<Person> getParticipants() {
		return participants;
	}

	public List<Person> getManagers() {
		return managers;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "|participants=" + participants + "|managers=" + managers + "]";
	}
	
}
