/**
 * @author Romalice Ishimwe
 */

package Model;

import java.io.Serializable;
import java.util.*;

import Model.OptionSet;

public class AutoConfig implements Serializable{

	private static final long serialVersionUID = 8047377050463585263L;
	// Instance variables
	private String make; 
	private String model;
	private String style;
	private double basePrice;
	private ArrayList<OptionSet> options;

	private double finalPrice;
	
	/*************************************/
	public AutoConfig()
	{
		this.options = new ArrayList<OptionSet>();
	}
	public AutoConfig(String make, String model, String style, int maxOptionSet) {
		this.make = make;
		this.model = model;
		this.style = style;
		this.options = new ArrayList<OptionSet>();
	}
		
	public AutoConfig(String make, String model, String style) {
		this.make = make;
		this.model = model;
		this.style = style;
	}
	
	public AutoConfig(String make, String model) {
		this.make = make;
		this.model = model;
	}
	
	public AutoConfig(String make) {
		this.make = make;
	}
	
	/************** ******************************/
	
	// add an optionSet
	public void addOptionSet(String optionSetName)
	{
		options.add( new OptionSet(optionSetName));
	}
	
	// Add an option to the optionSet
	public void addOption(String optionSetName, String optionName, double optionPrice)
	{
		int index = findOptionSet(optionSetName);
		if( index != -1)
		{
			options.get(index).addOption(optionName, optionPrice);
			calculateFinalPrice(optionPrice);
		}else{
			System.out.println("The specified optionSet is not found!");
		}
	}
	
	// Get options
	public ArrayList<OptionSet.Options> getOptions(String optionSetName)
	{
		ArrayList<OptionSet.Options> choices = null;	
		
		int index = findOptionSet(optionSetName);
		if( index != -1)
		{
			choices = options.get(index).getChoices();
		}
		return choices;
	}
	
	// Update optionSet
	public void updateOptionSetName(String oldOptionSetName, String newOptionSetName)
	{
		int index = findOptionSet(oldOptionSetName);
		if( index != -1)
		{
			options.get(index).setName(newOptionSetName);
		}
	}
	
	// Update option
	public void updateOptionPrice(String optionSetName, String optionName, double newPrice)
	{
		int index = findOptionSet(optionSetName);
		int index2;
		if( index != -1)
		{
			index2 = findOption(optionSetName, optionName);
			if(index2!=-1)
			{
				options.get(index).getChoices().get(index2).setPrice(newPrice);
			}
		}
	}
	
	// Delete optionSet
	public void deleteOptionSet(String optionSetName)
	{
		int index = findOptionSet(optionSetName);
		if( index != -1)
		{
			options.remove(index);
		}
	}
	
	// Delete option
	public void deleteOption(String optionSetName, String optionName)
	{
		int index = findOptionSet(optionSetName);
		if( index != -1)
		{
			int index2 = findOption(optionSetName, optionName);
			if(index2 != -1)
			{
				options.get(index).getChoices().remove(index2);
			}
			
		}
	}
	
	// FIND OptionSet - Returns the index of the OptionSet or -1 if not found
	public int findOptionSet(String optionSetName)
	{
		int b = -1; // returns -1 if optionSet not found
		for(int i=0; i < options.size(); i++)
		{
			if( options.get(i).getName().equalsIgnoreCase(optionSetName) )
			{
				b = i;
			}
		}
		return b;
	}
	
	// Find Option. Returns the option index or -1 if option not found
	public int findOption(String optionSetName, String optionName)
	{
		int b = -1; // returns -1 if option not found
		for(int i=0; i < options.size(); i++)
		{
			if( options.get(i).getName().equalsIgnoreCase(optionSetName) )
			{
				for(int j =0; j < options.get(i).getChoices().size(); j++)
				{
					if(options.get(i).getChoices().get(j).getName().equalsIgnoreCase(optionName))
					{
						b = j;
					}
				}
			}
		}
		return b;
	}
	/*****************************************/
	
	// Setters and getters
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	public String getStyle() {
		return style;
	}
	public ArrayList<OptionSet> getOptions() {
		return options;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public void setOptions(ArrayList<OptionSet> options) {
		this.options = options;
	}

	public void setBasePrice(double basePrice)
	{
		this.basePrice = basePrice;
		//Initiate final Price
		this.finalPrice = basePrice;
	}
	
	public double getBasePrice()
	{
		return basePrice;
	}
	
	// Calculate final price
	public void calculateFinalPrice(double optionPrice)
	{
		this.finalPrice = this.finalPrice + optionPrice;
	}
	
	public double getFinalPrice() {
		return finalPrice;
	}
		
	public String getOptionSetName(OptionSet s)
	{
		return s.getName();
	}
	
	public ArrayList<OptionSet.Options> getOptionSetChoices(int optionSetIndex)
	{
		return options.get(optionSetIndex).getChoices();
	}
	/*******************************************/
	
	
	public void print()
	{
		System.out.println("Car Make: "+getMake());
		System.out.println("Car Model: "+getModel());
		System.out.println("Car Style: "+getStyle());
		System.out.println("Base price: $"+getBasePrice());
		System.out.println("Final price: $"+getFinalPrice());
		System.out.println();
		for(int i=0; i < options.size(); i++)
		{
			System.out.println(options.get(i).getName());
			for(int j=0; j<options.get(i).getChoices().size(); j++)
			{
				System.out.print("-"+options.get(i).getChoices().get(j).getName()+":");
				System.out.println(" $"+options.get(i).getChoices().get(j).getPrice());
			}
			System.out.println();
		}
	}
	@Override
	public String toString() 
	{
		return "AutoConfig [make=" + make + ", model=" + model + ", style=" + style + ", basePrice=" + basePrice
				+ ", options=" + options + ", finalPrice=" + finalPrice + "]";
	}
}