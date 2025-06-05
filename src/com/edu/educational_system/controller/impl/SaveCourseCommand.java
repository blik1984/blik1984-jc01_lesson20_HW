package com.edu.educational_system.controller.impl;

import com.edu.educational_system.controller.Command;
import com.edu.educational_system.model.Course;
import com.edu.educational_system.parser.Parser;
import com.edu.educational_system.service.CourseService;
import com.edu.educational_system.service.CourseServiceProvider;

public class SaveCourseCommand implements Command {

	private final CourseServiceProvider courseServiceProvider = CourseServiceProvider.getInstance();
	private final CourseService courseService = courseServiceProvider.getCourseService();

	@Override
	public String execute(String request) {

		Course course = Parser.parseCourse(request).get(0);
		courseService.saveCourse(course);
		String response = "Course saved";
		return response;
	}

}
