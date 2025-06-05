package com.edu.educational_system.controller.impl;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceProvider;

public class CreateCourseCommand implements Command {

	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService courseService = courseServiceProvider.getCourseService();

	@Override
	public String execute(String request) {

		String response = null;
		String[] params;

		params = request.split("\n");

		Course newCorse = new Course(params[1]);
		courseService.createCourse(newCorse);

		response = "Course created";
		return response;
	}

}
