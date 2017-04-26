/*	Class:       CS 1302/XLS
 * 	Term:        Spring 2017
 *  Instructor:  Monisha Verma
 *  Assignment:  Project 2
 */	

/*	Authors: Rebekah Roepke and Ruth Bearden
 */

package commands;

import java.util.ArrayList;

public class Action
{	// ------------------------------------------------------ Data Fields Visible to Subclasses
	protected String inputID;    // identification string
	protected String altInputID; // alternate identification string
								 // (e.i. inputID = "telephone"; altInputID = "phone")
	protected static ArrayList<Action> comprehensiveActionList = new ArrayList<>();

	// ------------------------------------------------------ Constructors
	// Only one identification strings
	public Action(String inputID)
	{	this.inputID = inputID;
		comprehensiveActionList.add(this);
	}
	
	// Two possible identification strings
	public Action(String inputID, String altInputID)
	{	this(inputID);
		this.altInputID = altInputID;
	}
	
	// ------------------------------------------------------- Get ID and alt ID
	public String getID()
	{	return this.inputID;			
	}
	
	public String getAltID()
	{	return this.altInputID;		
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
