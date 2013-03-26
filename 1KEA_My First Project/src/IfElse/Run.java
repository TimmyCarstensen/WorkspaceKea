package IfElse;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person1 = new Person("Peter", "Jensen", 12, true);
		
		//Skal returnere true
		System.out.println("Is age: " + person1.isAge(12));
		
		//Skal returnere true
		System.out.println("Is persons name: " + person1.isPersonsName("Peter Jensen"));
		
		//Skal returnere false
		System.out.println("Is persons name not(operator): " + person1.isPersonsNameNot("Peter Hansen"));
		
		//Skal returnere true
		System.out.println("Is persons name not but age is: " + person1.isPersonsNameNotButAgeIs("Peter hansen", 12));
		
		//Skal returnere true
		System.out.println("Is person age and name: " + person1.isPersonAgeAndName("Peter Jensen", 12));
		
		//Skal returnere true
		System.out.println("Is person identical: " + person1.isPersonIdentical("Peter Jensen", 12, true));
		
		//Skal returnere true
		System.out.println("Is persons name caseinsensitive: " + person1.isPersonsNameCasInsensitive("peter jensen"));
		
		
//		age between 0 - 5: return "Small Child"
//		age between 6 - 12: return "Child"
//		age between 13 - 19: return "Teenager"
//		age between 20 - 45: return "Adult"
//		age between 46 - 60: return "Mid age"
//		age between 61 - 75: return "Old"
//		age between 76 and up: return "Very Old"
		
		
		
		//Extended - try using your IsPersonIDentical method with this object. Is it working? Try fixing it if it does not work.
		//You will need to use the debugger to examine why it is not working to find out how to fix it.
		Person person2 = new Person("Tea", "Petersen", 42, false);
		Person person4 = new Person("Ole", "Kofoed", 63, true);
		Person person5 = new Person("Margit", "Carstensen", 83, false);
		Person person6 = new Person("Ida", "Mortensen", 3, false);
		
		System.out.println("Is person identical: " + person2.isPersonIdentical("Tea Petersen", 42, false));
		
		
		System.out.println("Which agegroup for Peter Jensen: " + person1.whichAgeGroup());
		System.out.println("Which agegroup for Tea Petersen: " + person2.whichAgeGroup());
		System.out.println("Which agegroup for Ole Kofoed: " + person4.whichAgeGroup());
		System.out.println("Which agegroup for Margit Carstensen: " + person5.whichAgeGroup());
		System.out.println("Which agegroup for Ida Mortensen: " + person6.whichAgeGroup());
	}
}
