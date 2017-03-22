package commands;

public class Action
{	// ------------------------------------------------------ Data Fields Visible to Subclasses
	protected String inputID;
	protected String altInputID;
	
	// ------------------------------------------------------ Private Data Fields
	private boolean object, objectWithPreposition;

	public Action(String inputID, boolean object, boolean objectWithPreposition)
	{	this.inputID = inputID;
		
		this.object = object;
		this.objectWithPreposition = objectWithPreposition;
	}
	
	public Action(String inputID, String altInputID, boolean object, boolean objectWithPreposition)
	{	this.inputID = inputID;
		this.altInputID = altInputID;
		
		this.object = object;
		this.objectWithPreposition = objectWithPreposition;
	}
	
	public boolean takesObject()
	{	return this.object;		
	}
	
	public boolean takesObjectWithPreposition()
	{	return this.objectWithPreposition;		
	}
	
	public boolean matches(String input)
	{	boolean matchesInput = false;
		
		if(input.equalsIgnoreCase(this.inputID) || input.equalsIgnoreCase(this.altInputID))
			matchesInput = true;
	
		return matchesInput;
	}
	
	public int numberOfArgs()
	{	int n = 1;
	
		if(this.object)
			n = 2;
		else if(this.objectWithPreposition)
			n = 4;
		
		return n;
	}
	

}
