/**
 * @author Romalice Ishimwe
 */

package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Model.AutoConfig;

public class AutoBuildFromFile {

	 // Create AutoCongif from the file
	public static AutoConfig buildAutoObject(String filename) 
	{
		AutoConfig auto = null; // Allocate object space
		try{
		String line;
		
		// Open file
		FileReader file = new FileReader(filename);
		BufferedReader buff = new BufferedReader(file);
		
		// Create Automobile object
    	auto = new AutoConfig();
		
    	// Read the first 4 lines (make, model, style, base price) respectively
		auto.setMake(buff.readLine());
		auto.setModel(buff.readLine());
		auto.setStyle(buff.readLine());
		auto.setBasePrice(Double.parseDouble(buff.readLine()));
		
		// Read option sets and options
		line = buff.readLine(); // Read next line
		if(line.equalsIgnoreCase("--option"))
		{
			while(line != null)
			{
				line = buff.readLine();
				String optionSetName = line;
				auto.addOptionSet(optionSetName); 
				// Start adding options to optionSets
				while(line!=null)
				{
					if(line.equalsIgnoreCase("--option"))
					{
						break;
					}
					// Read the next line to capture the option
					line = buff.readLine();
					if(line!=null)
					{
						if(line.equalsIgnoreCase("--option"))
						{
							break;
						}
						// Tokenize the line 
						StringTokenizer token = new StringTokenizer(line);
						// Add option with arguments (optionSetName, optionName, price)
						auto.addOption(optionSetName, token.nextToken(), Double.parseDouble(token.nextToken()));
					}else{
						break;
					}
				}
			}
		}else{}
		// Close the buffer
		buff.close();
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return auto;
	}
}
