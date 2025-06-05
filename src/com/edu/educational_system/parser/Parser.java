package com.edu.educational_system.parser;

import java.util.ArrayList;
import java.util.List;

import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.model.Student;
import com.edu.educational_system.model.Teacher;

public class Parser {

	public static List<Course> parseCourse(String data) {

		List<Course> dataToReturn = new ArrayList<>();
		String[] dataAllCourses = data.split("Course");
		for (int i = 1; i < dataAllCourses.length; i++) {
			String s = dataAllCourses[i];
			String[] dataOneCourse = s.split("\\|");
			String nameCourse = dataOneCourse[0].split("name=")[1];
			Course curs = new Course(nameCourse);
			String[] users = dataOneCourse[1].split("/");
			for (String s2 : users) {
				Person p = parsePerson(s2);
				if (p != null) {
					curs.addParticipant(p);
				}
			}
			dataToReturn.add(curs);
		}
		return dataToReturn;
	}

	public static Person parsePerson(String s) {
		String[] person = s.split(", | ");
		if (person[0].equalsIgnoreCase("Student")) {
			String group = person[1].split("group=")[1];
			double grade = Double.parseDouble(person[2].split("averageGrade=")[1]);
			String name = person[3].split("name=")[1];
			String email = person[4].split("email=")[1];
			Person balbes = new Student(name, email, group, grade);
			return balbes;
		} else if (person[0].equalsIgnoreCase("Teacher")) {
			String subject = person[1].split("subject=")[1];
			String name = person[2].split("name=")[1];
			String email = person[3].split("email=")[1];
			Person balbes = new Teacher(name, email, subject);
			return balbes;
		} else if (person[0].equalsIgnoreCase("Administrator")) {
			String department = person[1].split("department=")[1];
			String name = person[2].split("name=")[1];
			String email = person[3].split("email=")[1];
			Person balbes = new Teacher(name, email, department);
			return balbes;
		} else {
			return null;
		}
	}

}
