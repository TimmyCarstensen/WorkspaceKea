package model;

import java.util.ArrayList;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Class {
	
	private ArrayList<Student> students;
	private String name;
	
	/**
	 * create a Class object.
	 * @param name
	 */
	public Class(String className)
	{
		this.name = className;
		students = new ArrayList<Student>();	
	}
	
	/**
	 * create a Class object given a list of students
	 * @param className
	 * @param students
	 */
	public Class(String className, ArrayList<Student> students)
	{
		this.name = className;
		this.students = students;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void addStudent(Student s)
	{
		if(students.size() < 35){
			students.add(s);
		} else {
			System.out.println("Class is full!!! No more than 35 students.");
		}
	}
	
	/**
	 * We assume we only have unique students in our class to use the method. We can't get to a second Henrik for example, cause the if sentence will always stop
	 * and return at the first Henrik.
	 * @return
	 */
	public Student findStudent(String name)
	{
		for(Student s : students)
		{
			if(name.equalsIgnoreCase(s.getName()))
			{
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Give a list of students from class with same background.
	 * @param background
	 * @return
	 */
	public ArrayList<Student> getSameBackground(String background)
	{
		
		ArrayList<Student> sameBackground = new ArrayList<Student>();
		
		for(Student s : students)
		{
			if(s.getBackground().equalsIgnoreCase(background))
			{
				sameBackground.add(s);
			}
		}
		return sameBackground;
	}
	
	/**
	 * 
	 */
	public void printAllStudent()
	{
		for(Student s : students)
		{
			System.out.println("Name: " + s.getName() + " - Student ID: " + s.getStudentID() + " - Age: " + s.getAge() + " - Male: " + s.isMale() + " - Student Job:" +s.getStudentJob());
		}
	}
	
	public ArrayList<Student> getStudents(){return students;}
	public String getName(){return this.name;}	
}
