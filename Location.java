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
	
} // end Location

