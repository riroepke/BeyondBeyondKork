package commands;

public class Action
{	// ------------------------------------------------------ Data Fields Visible to Subclasses
	protected String inputID;
	protected String altInputID;
	
	// ------------------------------------------------------ Private Data Fields
	private boolean object, objectWithPreposition;

	// ------------------------------------------------------ Constructors
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
	
	// ------------------------------------------------------- Get properties
	public boolean takesObject() // Verb takes an object (2 words)
	{	return this.object;		
	}
	
	public boolean takesObjectWithPreposition() // Verb takes an object with
	{	return this.objectWithPreposition;		// prepositional phrase (4 words)
	}
	
	// ------------------------------------------------------- Other methods
	// determine whether a String matches this action's ID
	public boolean matches(String input)
	{	boolean matchesInput = false;
		
		if(input.equalsIgnoreCase(this.inputID) || input.equalsIgnoreCase(this.altInputID))
			matchesInput = true;
	
		return matchesInput;
	}

} // end Action
