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
	
	public String getOutsideDescription()
	{	String message = null;
		
		if(this.isRoom())
			message = this.getRoom().getOutsideDescription();
		else if(this.isContainer())
			message = this.getContainer().getOutsideDescription();
		
		return message;
	}
	
	public String getItemDescriptions()
	{	String itemDescriptions = null;
		if(this.isRoom())
			itemDescriptions = this.getRoom().getItemDescriptions();
		else
			itemDescriptions = this.getContainer().getItemDescriptions();
		
		return itemDescriptions;
	}
	
} // end Location

