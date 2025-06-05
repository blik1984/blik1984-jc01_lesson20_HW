package com.edu.educational_system.repository.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.edu.educational_system.model.Course;
import com.edu.educational_system.parser.Parser;
import com.edu.educational_system.repository.CourseRepository;

public class MemoryCourseRepository implements CourseRepository {
	private final List<Course> courses = extractData();

	public void addCourse(Course course) {
		courses.add(course);
	}

	public List<Course> getAllCourses() {
		return new ArrayList<>(courses);
	}

	public void saveCourse(Course course) {
		courses.add(course);
		writeData(courses);
	}

	public List<Course> extractData() {

		String data = readData();
		List<Course> result = Parser.parseCourse(data);
		return result;
	}

	public String readData() {
		URL location = MemoryCourseRepository.class.getProtectionDomain().getCodeSource().getLocation();
		String filePath = location.getPath() + "data/Courses.txt";
		StringBuilder content = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.println("Ошибка при чтении файла: " + e.getMessage());
		}
		String file = content.toString();
		return file;
	}

	public void writeData(List<Course> data) {
		URL location = MemoryCourseRepository.class.getProtectionDomain().getCodeSource().getLocation();

		String filePath = location.getPath() + "data/Courses.txt";

		try (FileWriter writer = new FileWriter(filePath); PrintWriter printWriter = new PrintWriter(writer)) {

			for (Object o : data) {
				String s = o.toString();
				printWriter.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
