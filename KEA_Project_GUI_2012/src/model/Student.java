package model;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Student 
{
	private String name;
	private int studentID;
	private int age;
	private boolean male;
	private String background;
	private String studentJob;
	private int hourPay;
	
	/**
	 * 
	 * @param name
	 * @param age
	 */
	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	/**
	 * 
	 * @param name
	 * @param age
	 * @param male
	 * @param studentJob
	 * @param background
	 */
	public Student(String name, int studentID, int age, boolean male, String background, String studentJob, int hourPay)
	{
		this.name = name;
		this.studentID = studentID;
		this.age = age;
		this.male = male;
		this.background = background;
		this.studentJob = studentJob;
		this.hourPay = hourPay;
	}
	
	public String getName(){return this.name;}
	public int getStudentID() {return studentID;}
	public int getAge(){return this.age;}
	public boolean isMale(){return male;}
	public String getBackground(){return background;}
	public String getStudentJob(){return studentJob;}
	public int getHourPay(){return hourPay;}
}
