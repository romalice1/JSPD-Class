package Testing;

import Model.AutoConfig;
import util.AutoBuildFromFile;
import util.Serialize;

public class TestDriver {

	public static void main(String[] args) 
	{
		// Build Automobile Object from a file.
		AutoBuildFromFile auto = new AutoBuildFromFile();
		AutoConfig prius = auto.buildAutoObject("prius.txt");
		
		System.out.println("OBJECT BEFORE SERIALIZATION");
		System.out.println("-----------------------------");
		prius.print();
		
		// Serialize object
		Serialize.serializeAuto(prius);
		
		// Deserialize
		AutoConfig newPrius =  Serialize.deserializeAuto("prius.dat");
		
		newPrius.deleteOptionSet("Color");
		newPrius.deleteOption("Gear shift know trim", "leather");
		
		System.out.println("OBJECT AFTER SERIALIZATION");
		System.out.println("-----------------------------");
		newPrius.print();
	}
}
