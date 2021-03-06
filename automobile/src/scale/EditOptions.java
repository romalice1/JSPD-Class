package scale;

import adapter.AutoConfigAPI;

public class EditOptions implements Runnable{
	// Counters
	int max=50;
	int iterator =0;
	
	// function Picker
	private String pick;
	
	private static AutoConfigAPI auto;
	
	public EditOptions(AutoConfigAPI auto) {
		EditOptions.auto = auto;
	}
	
	// Update optionSetName
	public void updateOptionSetName(String autoKey, String oldOptionSetName, String newOptionSetName)
	{
		auto.updateOptionSetName("TOYOTA_PRIUS_TWO", "color", "Colour");
	}
	
	// update optionPrice
	public void updateOptionPrice(String autoKey, String optionSetName, String optionName, double newPrice)
	{
		auto.updateOptionPrice("TOYOTA_PRIUS_TWO", "color", "mica-blue", 100);
	}
	
	// Update optionName
	public void updateOptionName(String autoKey, String optionSetName, String oldOptionName, String newOptionName)
	{
		auto.updateOptionName(autoKey, optionSetName, oldOptionName, newOptionName);
	}
	
	// Delete optionSet
	public void deleteOptionSet(String autoKey, String optionSetName)
	{
		auto.deleteOptionSet(autoKey, optionSetName);
	}
	
	// Delete optionPrice
	public void deleteOptionPrice(String autoKey, String optionSetName, String optionName)
	{
		auto.deleteOptionPrice(autoKey, optionSetName, optionName);
	}
	
	// Delete option
	public void deleteOption(String autoKey, String optionSetName, String optionName)
	{
		auto.deleteOption(autoKey, optionSetName, optionName);
	}
	
	@Override
	public void run() 
	{
		
		while(iterator < max)
		{
			pick = Thread.currentThread().getName();
			
			switch(pick)
			{
			case "1": updateOptionSetName("TOYOTA_PRIUS_TWO", "color", "Colour");
					updateOptionPrice("TOYOTA_PRIUS_TWO", "color", "Mica-Blue", 900);
				//break;
			case "2": deleteOptionPrice("TOYOTA_PRIUS_TWO", "color", "Mica-Blue");
				updateOptionSetName("TOYOTA_PRIUS_TWO", "color", "Colour");
			//break;
			default: deleteOptionSet("TOYOTA_PRIUS_TWO", "color");
			}
			
			System.out.println(Thread.currentThread().getName().toUpperCase() + " IS ON: \n\n");
			//auto.printAuto("TOYOTA_PRIUS_TWO");
					
		//iterator++;
		}
	}
	
}
