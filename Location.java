/*	Authors:		Peter Bearden, Ruth Bearden
 *  Date:			3/4/17
 *  Project:		Adventure Game Creation Commands
 */

package commands;

public class Location
{	// ----------------------------------- Data Fields
	private Object location; //can either be a Room or a Container
	private boolean room, container;
	
	// ----------------------------------------------------- Constructor
	public Location(Room location)
	{	this.location = location;
		room = true;
		container = false;
	}
	
	public Location(Container location)
	{	this.location = location;
		room = false;
		container = true;
	}
	
	// Check whether location is of type Room
	public boolean isRoom()
	{	return this.room;
	}
	
	public Room getRoom()
	{	return (Room)location;
	}
	
	public String getName()
	{	if(isRoom())
			return getRoom().getName();
		else
			return getContainer().getName();		
	}
	
	// Check whether location is of type Container
	public boolean isContainer()
	{	return this.container;
	}
	
	public Container getContainer()
	{	return (Container)location;		
	}
	
	// ========================================== Get description for either Room or Container
	public String getInsideDescription()
	{	String message = null;
		
		if(this.isRoom())
			message = this.getRoom().getInsideDescription();
		else if(this.isContainer())
			message = this.getContainer().getInsideDescription();
		
		return message;
	}

	
	public String getBearings()
	{	String message = null;
		if(this.isRoom())
			message = this.getRoom().getExitList();
		else
			message = this.getContainer().getInsideDescription();
		return message;
	}
	
	public String getListedItems()
	{	String itemDescriptions = null;
		if(this.isRoom())
			itemDescriptions = this.getRoom().getListedItems();
		else
			itemDescriptions = this.getContainer().getListedItems();
		
		return itemDescriptions;
	}
	
	public String getItemDescriptions()
	{	String itemDescriptions = null;
		if(this.isRoom())
			itemDescriptions = this.getRoom().getItemDescriptions();
		else
			itemDescriptions = this.getContainer().getItemDescriptions();

		return itemDescriptions;
	}
	
	
	// Generic method for finding item in a location (null if it doesn't exist)
	public Item findItem(String itemName)
	{	Item item = null;
	
		// make sure itemName is in standard form
		itemName = itemName.trim().toLowerCase();
		
		if(this.isRoom())
			item = getRoom().getItemFromRoom(itemName);
		else
			item = getContainer().getItemFromContainer(itemName);
		
		return item;
	}
	
	// ============================== Determine whether the Room or Container is lit
	public boolean hasLight()
	{	if(this.isRoom())
			return this.getRoom().hasLight();
		else
			return this.getContainer().hasLight();		
	}
	
	// ============================== Generic methods for adding and removing items
	public boolean addItem(Item newItem)
	{	boolean itemAdded = false;
	
		if(this.isRoom())
			itemAdded = getRoom().addItem(newItem);
		else
			itemAdded = getContainer().addItem(newItem);
		
		return itemAdded;
	}
	
	public boolean removeItem(Item item)
	{	boolean itemRemoved = false;
	
		if(this.isRoom())
			itemRemoved = getRoom().removeItem(item);
		else
			itemRemoved = getContainer().removeItem(item);
		
		return itemRemoved;
	}
	
} // end Location

