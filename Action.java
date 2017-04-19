package commands;

import java.util.ArrayList;

public class Action
{	// ------------------------------------------------------ Data Fields Visible to Subclasses
	protected String inputID;    // identification string
	protected String altInputID; // alternate identification string
								 // (e.i. inputID = "telephone"; altInputID = "phone")
	
	protected static ArrayList<Action> comprehensiveActionList = new ArrayList<>();
	
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

		comprehensiveActionList.add(this);
	}
	
	// Two possible identification strings
	public Action(String inputID, String altInputID, boolean object, boolean objectWithPreposition)
	{	this(inputID, object, objectWithPreposition);
		this.altInputID = altInputID;
	}
	
	// ------------------------------------------------------- Get ID and alt ID
	public String getID()
	{	return this.inputID;			
	}
	
	public String getAltID()
	{	return this.altInputID;		
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
	
	// Get comprehensive list of all actions
	public static ArrayList<Action> getComprehensiveActionList()
	{	return comprehensiveActionList;		
	}
	
	// Determine number of occurrences of actions with common inputID
	public int numberOfActions(String inputID)
	{	int occurrences = 0;
		for(int i = 0; i < comprehensiveActionList.size(); i++)
		{	if(comprehensiveActionList.get(i).matches(inputID))
				occurrences++;
		}
		return occurrences;
	}

} // end Action
