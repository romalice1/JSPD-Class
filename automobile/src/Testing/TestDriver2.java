package Testing;

import adapter.*;

public class TestDriver2 {

	public static void main(String[] args) 
	{
		AutoConfigAPI car1 = new AutoConfigAPI();
		// BUILD AUTO
		car1.buildAuto("toyotaPruisTwo", "prius.txt");
		//UPDATING THE OPTION PRICE BY AUTO'S LINKEDHASHMAP KEY
		car1.UpdateOptionPrice("toyotaPruisTwo", "color", "mica-blue", 100);
		// DELETE OPTIONSET
		car1.UpdateOptionSetName("toyotaPruisTwo", "color", "Colour");
		// PRINT AUTO BY ITS LINKEDHASHMAP KEY
		car1.printAuto("toyotaPruisTwo");
		
	}
}
