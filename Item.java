package commands;

import java.util.ArrayList;

public class Item
{	// --------------------------------------------- Data Fields
	protected String itemName;
	protected String altItemName;
	protected String description;
	protected Location location;
	
	// Item actionList
	protected ArrayList<Action> actionList = new ArrayList<>();
	protected int mass;
	
	// -------------------------------------------- Constructors
	public Item(String itemName, Location location, int mass)
	{	this.itemName = itemName;
		this.mass = mass;
	}
	
	public Item(String itemName, Location location, int mass, String description)
	{	this(itemName, location, mass);
		this.description = description;
	}
	
	public Item(String itemName, String altItemName, Location location, int mass)
	{	this(itemName, location, mass);
		this.altItemName  = altItemName;
	}
	
	public Item(String itemName, String altItemName, Location location, int mass, String description)
	{	this(itemName, location, mass, description);
		this.altItemName = altItemName;
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
	
	public String getAltName()
	{	return this.altItemName;		
	}
	
	public void setDescription(String description)
	{	this.description = description;		
	}
	
	public String getDescription()
	{	return this.description;		
	}
	
	public void setMass(int mass)
	{	this.mass = mass;
	}
	
	public int getMass()
	{	return this.mass;
	}
	
	// ----------------------------------------------------------------------- Other Methods
	// Add a property to an item
	public void addAction(Action c)
	{	if(this.hasAction(c) == false)
			actionList.add(c);		
	}
	
	// Remove an existing property
	public void removeAction(Action c)
	{	if(this.hasAction(c) == true)
			actionList.remove(c);		
	}
	
	// Determine whether item has a property
	public boolean hasAction(Action c)
	{	boolean itemhasAction = false;
		if(actionList.contains(c))
			itemhasAction = true;
		return itemhasAction;
	}
	
	// =============================THIS METHOD MAY NOT BE NEEDED==========================
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
	
} // end Item
