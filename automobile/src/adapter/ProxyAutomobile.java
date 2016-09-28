package adapter;

import java.util.*;

import Model.*;

import util.AutoBuildFromFile;

public abstract class ProxyAutomobile {
	// A linked hash map of autoconfigs
	private static LinkedHashMap<String, AutoConfig> configs = new LinkedHashMap<String, AutoConfig>();
	// Builds the automobile and adds it to the LinkedHashMap
	public void buildAuto(String autoKey, String fileName) 
	{
		configs.put(autoKey, AutoBuildFromFile.buildAutoObject(fileName));
	}
	// Prints the automobile given its Map key
	public void printAuto(String autoKey) 
	{
		// This key may crush if key is not found.
		configs.get(autoKey).print();
	}
	public void UpdateOptionSetName(String autoKey, String oldOptionSetName, String newOptionSetName) 
	{
		configs.get(autoKey).updateOptionSetName(oldOptionSetName, newOptionSetName);
	}
	public void UpdateOptionPrice(String autoKey, String optionSetName, String optionName, double newPrice) 
	{
		configs.get(autoKey).updateOptionPrice(optionSetName, optionName, newPrice);
	}
}
