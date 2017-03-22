package commands;

import java.util.Scanner;

public class Parser
{	// --------- Data Fields
	private String[] args;
	private java.util.Scanner input = new Scanner(System.in); 

	// --------- Constructors
	public Parser() {}
	
	// --------- Methods
	public String[] getLine()
	{	this.args = this.input.nextLine().split(" ");
		
		if(this.args.length > 0)
			for(int i = 0; i < args.length; i++)
				this.args[i] = this.args[i].trim();
		
		return this.args;
	}
	
	public String[] getPreviousLine()
	{	return this.args;
	}
	
	public String getWord(int i)
	{	String s = null;
		
		if(args.length >= i+1)
			s = this.args[i];
		
		return s;
	}
}
