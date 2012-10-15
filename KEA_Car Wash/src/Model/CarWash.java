package Model;

/**
 * 
 * @author Timmy Carstensen
 *
 */
public class CarWash {

	private int howManyWashes_ChangeSoap;
	private final int canWash = 10;
	private int money;
	private int howManyWashes;
	
	public CarWash(){
		Run.days = 0;
		this.money = 100;
	}
	
	/**
	 * This method wash a car.
	 */
	public void washCar(CarOwner co){
		// No more soap in the machine!
		if (howManyWashes_ChangeSoap == canWash){
			System.out.println(Run.dt + " - No more soap in car wash, can't wash your car! Please ask personale to refill!");
			System.out.println();
			}
		// wash a car!
		else if(howManyWashes_ChangeSoap < canWash && co.getCar().needWash()){

			// Lastwashed in car is set here
			co.getCar().setLastWash(Run.days);
			howManyWashes_ChangeSoap++;
			System.out.println(Run.dt + " - Washing your "+ co.getCar().getModel() + " now!! SUCCES!!!" + " How many washes left: " + (canWash - howManyWashes_ChangeSoap));
			System.out.println();
			co.payForWash();
			money += 20;
			incrementWashes();
			
		}
		// Car doesn't need to be washed right now.
		else {
			System.out.println(Run.dt + " - Car does not need to be washed right now!");
			System.out.println("Car need a wash in: " + (Run.days - co.getCar().getDaysLastWash()) + " days.");
			System.out.println();
		}
	}
	
	
	
	public void refillSoap(){
		howManyWashes_ChangeSoap = 0;
		money -= 130;
		System.out.println(Run.dt + " - Machine have been refilled!" + " Money earned on washes: " + getMoney());
		System.out.println();
	}
	
	public void setDay(int d){Run.days = d;}
	public int getDays(){return Run.days;}
	public int getMoney(){return this.money;}
	public int getHowManyWashes(){return this.howManyWashes;}
	public int getWashesLeft(){return howManyWashes_ChangeSoap;}
	public void incrementWashes(){howManyWashes++;}
}
