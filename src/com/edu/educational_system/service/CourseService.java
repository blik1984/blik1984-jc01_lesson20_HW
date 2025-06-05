package com.edu.educational_system.service;

import java.util.List;

import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;

public interface CourseService {

	public void createCourse(Course course);

	public boolean enrollPerson(Course course, Person person);
	
	public void conductLesson(Course course);
	
	public List<Course> getAllCourses();
	
	public void saveCourse(Course currentCourse);
	
	public List<Person> getParticipants(Course course);

	public double getAverageGrade(Course course);
}
  