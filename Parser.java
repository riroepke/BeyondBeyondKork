package commands;

import java.util.Scanner;

public class Parser
{	private String[] args;                                    // List of words in input line
	private java.util.Scanner input = new Scanner(System.in); // Scanner object for getting user input

	// -------------------------------------------------------------------------------- Constructors
	public Parser() {}
	
	// ------------------------------------------------------------------------------------- Methods
	// Read in a single line of input
	public String[] getLine() 
	{	this.args = this.input.nextLine().split(" "); // Obtain input as a series of indexed Strings
		
		if(this.args.length > 0)                      // Make sure input is not empty
			for(int i = 0; i < args.length; i++)      
				this.args[i] = this.args[i].trim();   // Trim each word
		
		return this.args;
	}
	
	// Get word by index
	public String getWord(int i)
	{	String s = null;
		
		if(args.length >= i+1)
			s = this.args[i]; // Return word at index i
		
		return s;
	}
} // end Parser
