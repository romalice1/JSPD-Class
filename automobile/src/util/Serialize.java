package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.AutoConfig;

public class Serialize {

	public static void serializeAuto(AutoConfig auto)
	{
		try {
			ObjectOutputStream out = new ObjectOutputStream(new 
										FileOutputStream("prius.dat"));
			// Write the object
			out.writeObject(auto);
			out.close();
			
		}catch (IOException e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
	
	public static AutoConfig deserializeAuto(String dataFile)
	{
		AutoConfig returnValue = null;
		try {
			//Read object from serialized data
			ObjectInputStream in = new ObjectInputStream(new
			                           FileInputStream(dataFile));
			AutoConfig newAuto = (AutoConfig) in.readObject();
			in.close();
			returnValue =  newAuto;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
}
