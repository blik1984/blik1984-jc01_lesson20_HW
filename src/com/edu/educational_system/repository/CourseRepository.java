package com.edu.educational_system.repository;

import java.util.List;

import com.edu.educational_system.model.Course;

public interface CourseRepository {

	void addCourse(Course course);

	List<Course> getAllCourses();

	void saveCourse(Course course);

	List<Course> extractData();

	void writeData(List<Course> data);

}
