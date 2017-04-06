package commands;

public class Action
{	// ------------------------------------------------------ Data Fields Visible to Subclasses
	protected String inputID;    // identification string
	protected String altInputID; // alternate identification string
								 // (e.i. inputID = "telephone"; altInputID = "phone")
	
	// ------------------------------------------------------ Private Data Fields
	private boolean object;                // Determines whether or not action requires object
	private boolean objectWithPreposition; // Determines whether or not action requires object
	                                       //     and prepositional phrase

	// ------------------------------------------------------ Constructors
	// Only one identification strings
	public Action(String inputID, boolean object, boolean objectWithPreposition)
	{	this.inputID = inputID;
		
		this.object = object;
		this.objectWithPreposition = objectWithPreposition;
	}
	
	// Two possible identification strings
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
