package Testing;

import adapter.*;

public class TestDriver2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Instantiating a createAuto object
		AutoConfigAPI car = new AutoConfigAPI();
		// BUILD AUTO
		car.buildAuto("carConfig.txt");
		car.updateBasePrice("MAZDA_ZUMA_IPS", 12000);
		car.printAuto("MAZDA_ZUMA_IPS");
	}
}
