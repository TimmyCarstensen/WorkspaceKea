package model;

import java.util.ArrayList;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class School {

	private String name;
	private ArrayList<Class> classes;
	
	/**
	 * 
	 * @param name
	 */
	public School(String name)
	{
		this.name = name;
		classes = new ArrayList<Class>();
		
	}
	
	public String[] getClassNames()
	{
		String[] classNames = new String[classes.size()];
		int i = 0;
		for(Class c : classes)
		{
			classNames[i] = c.getName();
			i++;
		}
		
		return classNames;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void addClass(Class c)
	{
		classes.add(c);
	}
	
	/**
	 * 
	 * @param className
	 * @return
	 */
	public Class getAClass(String className)
	{
		for(Class c : classes)
		{
			if(c.getName().equalsIgnoreCase(name))
			{
				return c;
			}
		}
	return null;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Student findStudentFromSchool(String name)
	{
		for(Class c : classes)
		{
			for(Student s : c.getStudents())
			{
				if(s.getName().equalsIgnoreCase(name))
				{
					System.out.println(s.getName() + " is a student at " + getName());
					return s;
					
				}
			}
		}
		return null;
	}
	
	/**
	 * Don't know it I want to use this method.
	 * @param name
	 * @return
	 */
	public double calculateAverageHourlyPay(String firmName)
	{
		int i = 0;
		int sum = 0;
		for(Class c : classes)
		{
			for(Student s : c.getStudents())
			{
				if(s.getStudentJob().equalsIgnoreCase(firmName))
				{
					sum = sum + s.getHourPay();
					i++;
				}
			}
		}
		double result = (double)sum / (double)i;
		System.out.println(firmName + " employee average hourly pay: " + result +  " kr."); // print out the average hourly pay of the specified firm
		return result;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Class getClass(int index)
	{
		if(index < classes.size())
			return classes.get(index);
		else
			System.out.println("Wrong index given, no class exits at this entity!");
		
		return null;
	}
	
	public String getName(){return this.name;}
	public ArrayList<Class> getClasses() {return classes;}
	public void setName(String name){this.name = name;}
	
	
}