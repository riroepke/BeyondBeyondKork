/*	Authors:		Peter Bearden, Ruth Bearden
 *  Date:			3/4/17
 *  Project:		Adventure Game Creation Commands
 */

package commands;

public class Location
{	// ----------------------------------- Data Fields
	Object location;
	
	public Location(Map map, Room room)
	{	this.location = room;
	}
	
	public Location(Map map, Container container)
	{	this.location = container;
	}
	
	public Object getLocation()
	{	return this.location;		
	}
} // end Location

