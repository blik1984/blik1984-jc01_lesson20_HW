package com.edu.educational_system.controller.impl;

import java.util.List;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceProvider;

public class GetAllCoursesCommand implements Command {

	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService courseService = courseServiceProvider.getCourseService();

	@Override
	public String execute(String request) {

		String response = null;

		List<Course> data = courseService.getAllCourses();

		response = data.toString();
		return response;

	}

}
