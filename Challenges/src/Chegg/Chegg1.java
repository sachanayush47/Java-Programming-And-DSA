package Chegg;

public class Chegg1 {

	public static void main(String[] args) {
		
		Course course = new Course("Math");
		
		// Adding students.
		course.addStudent("S1");
		course.addStudent("S2");
		course.addStudent("S3");
		
		System.out.println("Before dropping");
		
		// Printing students.
		String temp[] = course.getStudents();
		for(int i = 0; i < temp.length; ++i) {
			System.out.print(temp[i] + " ");
		}
		
		// Dropping student "S1.
		course.dropStudent("S1");
		
		
		// Printing students.
		temp = course.getStudents();
		System.out.println("\nAfter dropping");
		for(int i = 0; i < temp.length; ++i) {
			System.out.print(temp[i] + " ");
		}
	}
	
}

class Course {
	
	String courseName;
	String students[];
	int numberOfStudents;
	
	public Course(String courseName) {
		students = new String[1];
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void addStudent(String student) {
		
		// If no space left in the "students" array.
		if(numberOfStudents == students.length) {
			
			// Creating a new array of double the size of previous one.
			String newStudents[] = new String[students.length * 2];
			
			// Copying items of fully filled array to "newStudents" array.
			System.arraycopy(students, 0, newStudents, 0, numberOfStudents);
			
			// "students" array will now reference to "newStudent" array.
			students = newStudents;
		}
		
		// Adding "student" to the "students" array.
		students[numberOfStudents] = student;
		
		// Total number of students will be increased by 1.
		++numberOfStudents;
	}
	
	public void dropStudent(String student) {
		
		// Finding the student and deleting it.
		for(int i = 0; i < numberOfStudents; ++i) {
			if(students[i].equals(student)) {	// If student founded.
				
				students[i] = null;				// Deleting
				
				// Shifting the students towards the deleted student.
				for(int j = i; j < numberOfStudents-1; ++j) {
					students[j] = students[j+1];
				}
				
				students[numberOfStudents] = null;
				
				// Total number of students will be decreased by 1.
				--numberOfStudents;
				break;
			}
		}
	}
	
	public String[] getStudents() {
		
		// New array to store all the students.
		String allStudent[] = new String[numberOfStudents];
		
		// Adding all students to the new array.
		for(int i = 0; i < numberOfStudents; ++i) {
			allStudent[i] = students[i];
		}
		
		return allStudent;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public void clear() {
		
		// Setting all students to null.
		for(int i = 0; i < numberOfStudents; ++i) {
			students[i] = null;
		}
		
		numberOfStudents = 0;
	}
}
