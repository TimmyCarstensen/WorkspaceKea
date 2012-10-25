package control;

import model.School;
import view.MainFrame;
import model.Student;
import model.Class;

public class DemoData {
	
	public DemoData()
	{
		demoInitialise();
	}
	
	public School demoInitialise()
	{
		School school = new School("Københavns Erhvervs Akademi");
		
		Class cl1 = new Class("Class A");
		
//		1. klasse
		Student s1 = new Student("Timmy", 123123, 24, true, "KEA", "Lifeguard", 155);
		Student s2 = new Student("Lennart", 213213, 22, true, "KEA", "Economi", 130);
		Student s3 = new Student("Nanna", 321321, 19, false, "KEA", "Grafiker", 130);
		Student s4 = new Student("Christina", 312312, 20, false, "Hjemmepleje", "Student", 130);
		Student s5 = new Student("Marie Toxværd", 142312, 21, true, "KEA", "Student", 130);
		Student s6 = new Student("Fanny Emilie Bostinius", 127123, 22, true, "KEA", "Lifeguard", 123);
		Student s7 = new Student("Mark Falgren", 512315, 23, false, "KEA", "Student", 130);
		Student s8 = new Student("Kasper Dyrmose Andersen", 512315, 23, false, "KEA", "Student", 130);
		Student s9 = new Student("Morten Ib Munk-Nielsen", 512315, 23, false, "KEA", "Student", 130);
		
		cl1.addStudent(s1);
		cl1.addStudent(s2);
		cl1.addStudent(s3);
		cl1.addStudent(s4);
		cl1.addStudent(s5);
		cl1.addStudent(s6);
		cl1.addStudent(s7);
		cl1.addStudent(s8);
		cl1.addStudent(s9);
		
		Class cl2 = new Class("Class B");
//		2.klasse
		Student t1 = new Student("Christian Schou Jensen", 216433, 24, true, "Dykker", "Student", 130);
		Student t2 = new Student("Mads Christensen", 233336, 21, true, "Racekører", "traktorkører", 130);
		Student t3 = new Student("Morten Espensen", 236134, 20, true, "Datalogi", "chosting", 130);
		Student t4 = new Student("Tobias Dyrmose Jespersen", 266423, 17, true, "", "Netto", 98);
		Student t5 = new Student("Caroline Faarvang Møller Andersen", 222263, 15, false, "", "Netto", 130);
		Student t6 = new Student("Mie Fenger", 236462, 26, false, "", "Lifeguard", 130);
		Student t7 = new Student("Mie Louise J. Sørensen", 267553, 24, false, "", "Lifeguard", 175);
		Student t8 = new Student("Signe Kristiane Sebech", 257753, 22, false, "", "Lifeguard", 146);
		Student t9 = new Student("Eva Dyreborg", 111223, 43, false, "", "Netto", 123);
		
		cl2.addStudent(t1);
		cl2.addStudent(t2);
		cl2.addStudent(t3);
		cl2.addStudent(t4);
		cl2.addStudent(t5);
		cl2.addStudent(t6);
		cl2.addStudent(t7);
		cl2.addStudent(t8);
		cl2.addStudent(t9);
		
		Class cl3 = new Class("Class C");
//		3. klasse
		Student r1 = new Student("Melanie Ivy Kyhnæb", 722772, 22, false, "", "Netto", 128);
		Student r2 = new Student("Nanna Helena Treschow", 277237, 20, false, "", "Lifeguard", 188);
		Student r3 = new Student("Danielle Nadia Schütt", 285558, 18, false, "", "Lifeguard", 211);
		Student r4 = new Student("Helene Dyrmose A", 282582, 20, false, "", "Netto", 111);
		Student r5 = new Student("Pelle Ethelberg-Findsen", 285822, 24, true, "", "Netto", 122);
		Student r6 = new Student("Kati Eriikka Arikoski", 828558, 28, false, "", "Lifeguard", 174);
		Student r7 = new Student("Mia Jeanette Skov", 525582, 25, false, "", "Netto", 120);
		Student r8 = new Student("Lykke Christina Andersen", 444542, 24, false, "", "Netto", 110);
		Student r9 = new Student("Joyce Byager Jensen", 488985, 24, false, "", "Lifeguard", 168);
		
		cl3.addStudent(r1);
		cl3.addStudent(r2);
		cl3.addStudent(r3);
		cl3.addStudent(r4);
		cl3.addStudent(r5);
		cl3.addStudent(r6);
		cl3.addStudent(r7);
		cl3.addStudent(r8);
		cl3.addStudent(r9);
		
		school.addClass(cl1);
		school.addClass(cl2);
		school.addClass(cl3);
		
		return school;
	}
}
