package com.edu.educational_system.service.impl;

import java.util.List;

import com.edu.educational_system.model.Course;
import com.edu.educational_system.model.Person;
import com.edu.educational_system.repository.CourseRepository;
import com.edu.educational_system.repository.CourseRepositoryProvider;
import com.edu.educational_system.service.CourseService;

public class CourseServiceVariantOne implements CourseService{
	private final CourseRepository courseRepository;

	{
		CourseRepositoryProvider provider = CourseRepositoryProvider.getInstance();
		courseRepository = provider.getCourseRepository();
	}

	public CourseServiceVariantOne() {
	}

	public void createCourse(Course course) {
		courseRepository.addCourse(course);
	}

	public boolean enrollPerson(Course course, Person person) {
		return course.addParticipant(person);
	}

	public void conductLesson(Course course) {
		course.conductLesson();
	}

	public List<Person> getParticipants(Course course) {
		return course.getParticipants();
	}

	public double getAverageGrade(Course course) {
		return course.calculateAverageGrade();
	}

	public List<Course> getAllCourses() {
		return courseRepository.getAllCourses();
	}

	public void saveCourse(Course currentCourse) {
		courseRepository.saveCourse(currentCourse);

	}
}
