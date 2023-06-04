/**
 * META Gmbh
 * company tech
 * Copyright 2023
 */
package models;
/**
 * @author benab
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String name;  
	private List<String> courses;
	
	/**
	 * Constructor  for student
	 * @param id
	 * @param name
	 * @param courses
	 */
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new ArrayList<>();
	}
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void addCourses(String courses) {
		this.courses.add(courses);
	}
	
	
	
	
}
