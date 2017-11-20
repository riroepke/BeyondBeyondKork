package commands;

import java.util.ArrayList;

public class Item
{	// --------------------------------------------- Data Fields
	protected String itemName, altItemName;
	protected String itemDescription;
	protected String details;
	protected Location location;
	
	// Item properties
	protected ArrayList<Action> actionList = new ArrayList<>(); // actions that can be performed on item
	protected int mass;                                         // mass of item
	protected boolean plural = false;                           // item is singular or plural (default singular)
	protected boolean startsWithVowel;                          // item starts with vowel
	
	// -------------------------------------------- Constructors
	public Item(String itemName, Location location, int mass)
	{	this.itemName = itemName;
		this.location = location;
		this.mass = mass;
	}
	
	public Item(String itemName, String altItemName, Location location, int mass)
	{	this(itemName, location, mass);
		this.altItemName  = altItemName;
	}
	
	// -------------------------------------------- Getter & Setters
	public void setName(String itemName)
	{	this.itemName = itemName;		
	}
	
	public void setName(String itemName, String altItemName)
	{	setName(itemName);
		this.altItemName = altItemName;
	}
	
	public String getName()
	{	return this.itemName;
	}
	
	public String getNameWithArticle()
	{	String nameWithArticle = "a";  // both "a" and "an" begin with 'a'
		char firstLetter = this.itemName.charAt(0); // get first letter in name
	
		// add 'n' if firstLetter is a vowel
		if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i'
				|| firstLetter == 'o' || firstLetter == 'u')
			nameWithArticle += "n";
		
		// add the item name to return String
		nameWithArticle += " " + this.itemName;
	
		return nameWithArticle;
	}
	
	public String getAltName()
	{	return this.altItemName;		
	}
	
	// Determine whether name of item matches name given by player
	public boolean matches(String inputID)
	{	inputID = inputID.trim().toLowerCase();
		return (inputID.equals(this.getName()) || inputID.equals(this.getAltName()));		
	}
	
	// ============================================================ Description Getters & Setters
	
	// --------------------- Item Description (used when listing items in a room)
	public void setItemDescription(String itemDescription)
	{	this.itemDescription = itemDescription;		
	}
	
	public String getItemDescription()
	{	return this.itemDescription;
	}
	
	// --------------------- Details (used when "examining" items)
	public void setDetails(String details)
	{	this.details = details;		
	}
	
	public String getDetails()
	{	return this.details;
	}
	
	
	// ============================================== Mass Getters & Setters
	public void setMass(int mass)
	{	this.mass = mass;
	}
	
	public int getMass()
	{	return this.mass;
	}
	
    // ============================================== Change item to a plural item
	public void setPlural(boolean plural)
	{	this.plural = plural;		
	}
	
	// Determine whether the item is plural
	public boolean isPlural()
	{	return this.plural;		
	}
	
	
	// ----------------------------------------------------------------------- Other Methods
	// Add a property to an item
	public void addActions(Action... c)
	{	for(Action action: c)
			if(this.hasAction(action) == false)
				actionList.add(action);		
	}
	
	// Remove an existing property
	public void removeActions(Action... c)
	{	for(Action action: c)
			if(this.hasAction(action) == true)
				actionList.remove(action);		
	}
	
	// Determine whether an action can be performed on an item
	public boolean hasAction(Action c)
	{	boolean itemHasAction = false;
		if(actionList.contains(c))
			itemHasAction = true;
		return itemHasAction;
	}
	
	// Determine whether an action can be performed on an item given the action's name
	public boolean hasAction(String actionID)
	{	boolean itemHasAction = false;
		
		for(int i = 0; !itemHasAction && i < this.actionList.size(); i++)
			if(this.actionList.get(i).matches(actionID))
				itemHasAction = true;
	
		return itemHasAction;
	}
	
	// Retrieve the item's current location
	public Location getLocation()
	{	return this.location;
	}
	
	// Change the item's current location
	public void setLocation(Location newLocation)
	{	Room room;
		Container container;
	
		if(this.location.isRoom())
		{	room = this.location.getRoom();
			room.removeItem(this);
		}
		else if(this.location.isContainer())
		{	container = this.location.getContainer();
			container.removeItem(this);			
		}
		
		if(newLocation.isRoom())
		{	room = newLocation.getRoom();
			room.addItem(this);
		}
		else if(newLocation.isContainer())
		{	container = newLocation.getContainer();
			container.addItem(this);
		}
	}
	
	// ===================================================== Actions performed on Items
	// Move an item
	public String move(String result)
	{	String message = null;
		
		if(this.hasAction("move")) // Make sure the item can be moved
			message = Definitions.MOVED(this.itemName, result);
		else
			message = Definitions.CANNOT_MOVE_ITEM;
		
		return message;		
	}
	
	public String swing(String result)
	{	String message = null;
	
		if(this.hasAction("swing")) // Make sure the item can be swung
			message = Definitions.SWING(this.itemName, result);
		else
			message = Definitions.SARCASTIC_CHALLENGE;
		
		return message;
		
	}
} // end Item
