package commands;

import java.util.Scanner;

public class Parser extends Rules
{	private String[] args;                                    // List of words in input line
	private String inputString;                                      // Scanner object for getting user input

	// -------------------------------------------------------------------------------- Constructors
	public Parser(String inputString)
	{	this.inputString = inputString;		
	}
	
	// ------------------------------------------------------------------------------------- Methods
	// Read in a single line of input
	public String[] getLine() 
	{	this.args = this.inputString.split(" "); // Obtain input as a series of indexed Strings
		
		if(this.args.length > 0)                      // Make sure input is not empty
			for(int i = 0; i < args.length; i++)      // Make sure each word is stored in standard form
				this.args[i] = this.args[i].trim().toLowerCase();   
			
		return this.args;
	}
	
	// Get word by index
	public String getWord(int i)
	{	String s = null;
		
		if(args.length >= i+1)
			s = this.args[i]; // Return word at index i
		
		return s;
	}
	
	// Get the number of words in args
	public int numberOfWords()
	{	return this.args.length;		
	}
	
} // end Parser
