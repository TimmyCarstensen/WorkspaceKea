package db;

import controlEntity.Bag;
import controlEntity.Bag.BagType;
import controlEntity.Present;
import controlEntity.Present.PresentType;
import controlEntity.Santa;
import controlEntity.Sled;

public class FakeDbConnector implements IDbConnector {


	public boolean getConnection() 
	{
		return true;
	}


	public Sled loadOneSledFromDb() 
	{
		Santa santa = new Santa("Julemanden", 140);

		Sled sled = new Sled(santa);

		sled.addBag(new Bag(10, BagType.PAPIR));

		Present present1 = new Present("Thomas the train", 4, PresentType.NORMAL);
		Present present2 = new Present("Lucky Lou", 3, PresentType.HARD);
		Present present3 = new Present("Flyvemaskine", 3, PresentType.NORMAL);
		Present present4 = new Present("Flashlight", 4, PresentType.SOFT);
		Present present5 = new Present("Bear", 5, PresentType.SOFT);
		Present present6 = new Present("Thomas the train", 4, PresentType.NORMAL);
		Present present7 = new Present("Lucky Lou", 3, PresentType.HARD);
		Present present8 = new Present("Flyvemaskine", 3, PresentType.NORMAL);
		Present present9 = new Present("Flashlight", 4, PresentType.SOFT);
		Present present10 = new Present("Bear", 5, PresentType.SOFT);
		Present present11 = new Present("Thomas the train", 4, PresentType.NORMAL);
		Present present12 = new Present("Lucky Lou", 3, PresentType.HARD);
		Present present13 = new Present("Flyvemaskine", 3, PresentType.NORMAL);
		Present present14 = new Present("Flashlight", 4, PresentType.SOFT);
		Present present15 = new Present("Bear", 5, PresentType.SOFT);


		sled.addPresentAndNewBagIfNeeded(present1);
		sled.addPresentAndNewBagIfNeeded(present2);
		sled.addPresentAndNewBagIfNeeded(present3);
		sled.addPresentAndNewBagIfNeeded(present4);
		sled.addPresentAndNewBagIfNeeded(present5);
		sled.addPresentAndNewBagIfNeeded(present6);
		sled.addPresentAndNewBagIfNeeded(present7);
		sled.addPresentAndNewBagIfNeeded(present8);
		sled.addPresentAndNewBagIfNeeded(present9);
		sled.addPresentAndNewBagIfNeeded(present10);
		sled.addPresentAndNewBagIfNeeded(present11);
		sled.addPresentAndNewBagIfNeeded(present12);
		sled.addPresentAndNewBagIfNeeded(present13);
		sled.addPresentAndNewBagIfNeeded(present14);
		sled.addPresentAndNewBagIfNeeded(present15);

		
		return sled;
	}

}
