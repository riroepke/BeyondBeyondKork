package commands;

import java.util.ArrayList;

public class Container extends Item
{	// ----------------------------------- Data Fields
	protected ArrayList<Item> items = new ArrayList<>();  // list of items in a container
	protected int maxCapacity;                            // maximum mass capacity
	protected int massContained = 0;                      // current mass the Container is holding
	protected String insideDescription;                   // description of Container's interior
	
	private boolean closed = true;                        // item is open or closed (default closed)
	private boolean canClose = true;                      // item can or cannot be closed (default can)
	private boolean canOpen = true;                       // item can or cannot be opened (default can)
	private Item key;                                         // key item
	private ArrayList<Action> keyActions = new ArrayList<>(); // list of actions done to unlock a box
	
	// ----------------------------------- Constructors
	public Container(String itemName, Location location, int mass, int maxCapacity)
	{	super(itemName, location, mass);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, Location location, int mass, int maxCapacity, String outsideDescription, String insideDescription)
	{	super(itemName, location, mass, outsideDescription);
		this.maxCapacity = maxCapacity;
		this.insideDescription = insideDescription;
	}
	
	public Container(String itemName, String altItemName, Location location, int mass, int maxCapacity)
	{	super(itemName, altItemName, location, mass);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, String altItemName, Location location, int mass, int maxCapacity, String outsideDescription, String insideDescription)
	{	super(itemName, altItemName, location, mass, outsideDescription);
		this.maxCapacity = maxCapacity;
		this.insideDescription = insideDescription;
	}
	
	// ----------------------------------- Getters & Setters
	public boolean addItem(Item newItem)
	{	boolean itemAdded = false;
	
		if(super.mass + newItem.getMass() <= this.maxCapacity) // Ensure that Container can hold item
		{	this.massContained += newItem.getMass();
			this.items.add(newItem);
			itemAdded = true;
		}
		
		return itemAdded;
	}
	
	public boolean removeItem(Item item)
	{	boolean itemRemoved = false;
	
		if(this.items.contains(item)) // Make sure that the Container is holding the item
		{	this.massContained -= item.getMass();
			this.items.remove(item);
			itemRemoved = true;
		}
		return itemRemoved;
	}
	
	public int getMaxMass()
	{	return this.maxCapacity;
	}
	
	public void setMaxMass(int mass) throws NegativeMassException
	{	if(mass >= 0)
			this.maxCapacity = mass;
	else
		throw new NegativeMassException();		
	}
	
	public int getMassContained()
	{	return this.massContained;
		
	}
	
	
	// Get reference to item list
	public ArrayList<Item> getItems()
	{	return this.items;		
	}
	
	// Description of Container from the Inside
	public String getInsideDescription()
	{	return this.insideDescription;
	}
	
	// Description of items in list form (one per line) with articles included
	public String getItemDescriptions()
	{	String listAsString = null;
		String beingVerb = " is";
		
		for(int i = 0; i < items.size(); i++)
		{	// Check whether item is singular or plural
			if(items.get(i).isPlural())
				beingVerb = " are";
			listAsString += items.get(i).getNameWithArticle() + beingVerb + " here\n";
		}
		
		return listAsString;
	}
	
	// ---------------------------------------- Open or Close the Container
	public void lock(Item key, Action... actionList)
	{	if(this.canOpen == true)  // Box cannot be opened until actions are completed with key
			this.canOpen = false;
	
		for(Action action: actionList)
			if(this.keyActions.contains(action) == false)
				this.keyActions.add(action);
	}
	
	public void unlock()     // Conditions for unlocking handled in Game class
	{	this.canOpen = true;		
	}
	
	public boolean canClose()
	{	return this.canClose;		
	}
	
	public boolean canOpen()
	{	return this.canOpen;		
	}
	
	public boolean isClosed()
	{	return this.closed;		
	}
	
	public String close()
	{	String message = null;
		if(this.canClose())
		{	if(this.isClosed() == false)
			{	this.closed = true;
			
				// Ensure proper grammar
				String verb = " has";
				if(this.isPlural())
					verb = " have";
				message = "The " + this.itemName + verb + " been closed\n";
			}
			else
			{	// Ensure proper grammar
				String verb = " is";
				if(this.isPlural())
					verb = " are";
				message = "The " + this.itemName + verb + " already closed\n";
			}
		}
		else
			message = "You cannot close that!";
		return message;
	}
	
	public String open()
	{	String message = null;
		
		return message;		
	}
} // end Container
