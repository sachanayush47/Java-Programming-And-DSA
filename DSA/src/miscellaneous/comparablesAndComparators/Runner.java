package miscellaneous.comparablesAndComparators;

import java.util.*;


public class Runner {

	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(23, "Ayush"));
		studentList.add(new Student(35, "Anurag"));
		studentList.add(new Student(18, "Akash"));
		studentList.add(new Student(13, "Varun"));
		studentList.add(new Student(65, "Hemant"));
		
		Collections.sort(studentList);
		studentList.forEach(System.out::println);
	}

}
