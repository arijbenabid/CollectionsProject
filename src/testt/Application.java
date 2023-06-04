package testt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import models.Student;

public class Application {

	/**
	 * Lists: ArrayList() => list["h","aa",""]{ List<String> testList = new
	 * ArrayList<>(); HashMap() =><key, value> { HashMap<Integer,Student> test = new
	 * HashMap<>(); } Set<String> testSet = new HashSet<>(); testSet.add("hatem");
	 * testSet.add("arij"); testSet.add("hatem") => throw an Exception
	 */
	// static Logger logger = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		// declare the HashMap
		HashMap<Integer, Student> map = new HashMap<>();

		// create new student1
		Student student1 = new Student(2001, "Jason");
		student1.addCourses("Math");
		student1.addCourses("science");
		student1.addCourses("History");


		// create new student2
		Student student2 = new Student(2002, "Ava");
		student2.addCourses("English");
		student2.addCourses("Science");
		student2.addCourses("Art");
		
		//create new student
		
		Student student3 = new Student(2003, "Mike");
		student3.addCourses("Math");
		student3.addCourses("History");
		student3.addCourses("Geography");



		// add students to the HashMap map
		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);

		// get the student by id
		/*
		 * try { Student studentOut = map.get(2); System.out.println("Student Id: "
		 * +studentOut.getId()); System.out.println("Student name: "
		 * +studentOut.getName()); System.out.println("Student courses: "
		 * +studentOut.getCourses());
		 * 
		 * }catch(final Exception exception) {
		 * System.out.println("There is no Student: ");
		 * 
		 * }
		 */

		// loop over the Hashmap map
		for (Map.Entry<Integer, Student> st : map.entrySet()) {
			int stId = st.getKey();
			Student student = st.getValue();
			System.out.println("Name: " + student.getName() + " ID: " + stId + " Courses: " + student.getCourses());
		}
		/*
		 * logger.info( "Name: " +student.getName() + " ID: " +stId+ " Courses: "
		 * +student.getCourses());
		 */

		/**
		 * Q 6
		 */
		List<String> allCourses = new ArrayList<>();

		for (Map.Entry<Integer, Student> course : map.entrySet()) {
			Student student = course.getValue();
			List<String> listC = student.getCourses();
			allCourses.addAll(listC);
		}
		/*
		 * System.out.println("Courses"); for(String courses : allCourses) {
		 * System.out.println(courses); }
		 */

		/**
		 * Q7
		 */
		Set<String> uniqueCourse = new HashSet<>(allCourses);

		/**
		 * Q8
		 */
		System.out.print("Unique Courses: ");
		for (String course : uniqueCourse) {
			System.out.print(course + " ");
		}

		/**
		 * Q9
		 */

		HashMap<String, List<Student>> courseMap = new HashMap<>();

		for (Map.Entry<Integer, Student> s : map.entrySet()) {
			int idst = s.getKey();
			Student student = s.getValue();
			List<String> studentByCourse = student.getCourses();
			for (String c : studentByCourse) {
				List<Student> st = courseMap.getOrDefault(c, new ArrayList<>());
				st.add(student);
				courseMap.put(c, st);
			}
		}
		/**
		 * Q10
		 */
		System.out.println();
		for (Map.Entry<String, List<Student>> c : courseMap.entrySet()) {
			List<Student> st = c.getValue();
			String course = c.getKey();
			System.out.print(course + ": [");
			boolean isFirst = true;
			for (Student student : st) {
				if (isFirst) {
					System.out.print(student.getName());
					isFirst = false;
				} else {
					System.out.print(", " + student.getName());
				}
				// System.out.print(",");
			}

			System.out.print("]");
			System.out.println();
		}

		/**
		 * Q11
		 */
		List<Student> streams = map
				.values()
				.stream()
				.filter(s -> s.getName().startsWith("J"))
				.collect(Collectors.toList());
		
		System.out.println("Students with J Names:");
		for (Student unSt : streams) {
			System.out.println(unSt.getName());
		}
	}
}