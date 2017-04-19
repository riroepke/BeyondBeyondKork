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
	
	// ------------------------------------------------------- Constructors
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
	
	// ------------------------------------------------------- Getters & Setters
	// 
	public boolean addItem(Item newItem)
	{	boolean itemAdded = false;
		int currentMassHeld = 0;
		
		// ------- Calculate Current mass held in the Container
		for(int i = 0; i < this.items.size(); i++)
			currentMassHeld += this.items.get(i).getMass();
		
		// ------- Add item to container
		if(currentMassHeld + newItem.getMass() <= this.maxCapacity) // Ensure that Container can hold item
		{	this.massContained += newItem.getMass();                // Add mass of added Item to Container
			this.items.add(newItem);                           		// Add new Item to Container
			newItem.location = new Location(this);             		// Set location of Item to current Container
			itemAdded = true;                                  		// Indicate successful add
		}
		
		return itemAdded;
	}
	
	public boolean removeItem(Item item)
	{	boolean itemRemoved = false;
	
		if(this.items.contains(item))             // Make sure that the Container is holding the item
		{	this.massContained -= item.getMass(); // Remove mass of Item to be Removed from Container
			this.items.remove(item);             // Remove item from list of container's items
			itemRemoved = true;                   // Indicate Item's successful removal
		}
		return itemRemoved;
	}
	
	// Get the maximum mass the container can hold
	public int getMaxMass()
	{	return this.maxCapacity;
	}
	
	// Set the maximum mass the container can hold
	public void setMaxMass(int mass) throws NegativeMassException
	{	if(mass >= 0) // Ensure maxCapacity is not negative
			this.maxCapacity = mass;
	else
		throw new NegativeMassException();		
	}
	
	// Get the current mass the container is holding
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
	public String getListedItems()
	{	String listAsString = "";
		
		if(items.size() > 0)
			listAsString = "The " + this.itemName + " contains:\n";
		
		for(int i = 0; i < items.size(); i++)
		{		// Add item with article and verb to list of items
			listAsString += "   " + items.get(i).getNameWithArticle() + "\n";
		}
		
		return listAsString;
	}
	
	// Get more detailed item descriptions in sentence form
		public String getItemDescriptions()
		{	String message = null;
		
			if(this.items.size() > 0)
			{	for(int i = 0; i < items.size(); i++)
					message += " " + items.get(i).getItemDescription();
			}
			else
				message = "";
		
			return message;		
		}
	
	// ========================================================================== Look for items in Container
	public Item getItemFromContainer(String itemName)
	{	Item item = null;
		
		// make sure itemName is in standard form
		itemName = itemName.trim().toLowerCase();
	
		// search items for item with itemName
		for(int i = 0; i < this.items.size(); i++)
		{	item = this.items.get(i);
			if(!(item.getName()).matches(itemName)) // or alternate name, set it to null
				item = null;
		}
	
		return item;
		
	}
	
	// ---------------------------------------- Open or Close the Container
	// Lock the container with a key and list of actions that must be performed with that key
	public void lock(Item key, Action... actionList)
	{	if(this.canOpen == true)  // Box cannot be opened until actions are completed with key
			this.canOpen = false;
	
		for(Action action: actionList) // Add times in actionList to keyActions
			if(this.keyActions.contains(action) == false) // Make sure keyActions does not already contain action
				this.keyActions.add(action);
	}
	
	// Unlock the container
	public void unlock()     // Conditions for unlocking handled in Game class
	{	this.canOpen = true;		
	}
	
	// Allow the player to close the container
	public boolean canClose()
	{	return this.canClose;		
	}
	
	// Allow the player to open the container (no key needed)
	public boolean canOpen()
	{	return this.canOpen;		
	}
	
	// Check whether the container is closed
	public boolean isClosed()
	{	return this.closed;		
	}
	
	// Close the container
	public String close()
	{	String message = null;
		if(this.canClose()) // ----------------- Make sure closing is permitted
		{	if(this.isClosed() == false) // ------------- Make sure the container is not already closed
			{	this.closed = true;
			
				// Ensure proper grammar ("The box has been closed" verses "The boxes have been closed")
				String verb = " has";
				if(this.isPlural())   // Check for plural item (i.e. "boxes")
					verb = " have";
				message = "The " + this.itemName + verb + " been closed\n";
			}
			else // ------------------------------------- The box is already closed. Tell player this
			{	// Ensure proper grammar
				String verb = " is";
				if(this.isPlural())
					verb = " are";
				message = "The " + this.itemName + verb + " already closed\n";
			}
		}
		else // -------------------------------- Notify player that closing the container is not permitted
			message = "You cannot close that!";
		return message;
	}
	
	public String open()
	{	String message = null;
		message = "The " + this.itemName + " is now open";
		this.closed = false;
		return message;		
	}
	
	
} // end Container
