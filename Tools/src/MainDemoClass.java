public class MainDemoClass {

	public static void main(String[] args) {

		Student studentArr[] = {
				new Student(1, "CSE", "Tom", 20),
				new Student(2, "ME", "Max", 4),
				new Student(3, "ECE", "Jack", 48),
				new Student(4, "EEE", "Jerry", 6),
				new Student(5, "EE", "Charlie", 18),
				new Student(6, "BT", "Franky", 21),
				new Student(7, "AE", "Dasy", 17),
				new Student(8, "EE", "Luna", 63),
				new Student(9, "ME", "Coco", 31),
				new Student(10, "CSE", "Ruby", 22)
		};
		
		// For-each loop to print data.
		for(Student s: studentArr) {
			s.displayData();
		}
	}
}

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void displayData() {
		System.out.println("Name: " + name + " Age: " + age);
	}
}

class Student extends Person {
	int rollNo;
	String branch;
	
	public Student(int rollNo, String branch, String name, int age) {
		super(name, age);		// Passing arguments to the Person class constructor.
		this.rollNo = rollNo;
		this.branch = branch;
		
	}
	
	// Overriding the Person class displayData method.
	// This method prints the Name, Age, RollNo, Branch
	public void displayData() {
		System.out.println("RollNo: " + rollNo + " Branch: " + branch + " Name: " + name + " Age: " + age);
	}
	
}