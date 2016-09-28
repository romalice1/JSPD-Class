/**
 * @author Romalice Ishimwe
 */
package Model;

import java.io.Serializable;
import java.util.*;


public class OptionSet implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name; // Name of the option set
	private ArrayList<Options> choices;
	
	// Constructor for OptionSet
	protected OptionSet(String name)
	{
		this.name = name;
		this.choices = new ArrayList<Options>();
	}
	
	// addOption
	protected void addOption(String name, double price)
	{
		choices.add(new Options(name, price));
	}
	
	//Getters and Setters
	protected String getName() {
		return name;
	}

	protected ArrayList<Options> getChoices() {
		return choices;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setChoices(ArrayList<Options> choices) {
		this.choices = choices;
	}

	/***************************************/
	
	//Print string
	
	@Override
	public String toString() {
		return "OptionSet [name=" + name + ", choices=" + choices + "]";
	}

	/*****************************************/

	// Options class
	class Options implements Serializable{
		private static final long serialVersionUID = -8275621815973930700L;
		protected String name; // Holds the value of optionSet
		protected double price;
		
		// Constructors
		protected Options(String name, double price) 
		{
			this.name = name;
			this.price = price;
		}
		
		// Getters
		protected String getName()
		{
			return name;
		}
		protected double getPrice()
		{
			return price;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		//to String
		protected void print() {
			System.out.println("Options [name=" + name + ", \nprice=" + price + "]");
		}

		@Override
		public String toString() {
			return "Options [name=" + name + ", price=" + price + "]";
		}
		

	} // END OF Option CLASS
} //END OF OptionSet CLASS