/*	Authors:		Peter Bearden, Ruth Bearden
 *  Date:			3/4/17
 *  Project:		Adventure Game Creation Commands
 */

package commands;

import java.util.ArrayList;

public class Map
{	// ----------------------------------------------------- Data Fields
	private String mapName;
	private ArrayList<Room> rooms = new ArrayList<>();
	
	// ----------------------------------------------------- Constructors	
	public Map(String mapName)
	{	this.mapName = mapName;		
	}
	
	// ----------------------------------------------------- Getters
	public String getMapName()
	{	return this.mapName;		
	}
	
	// ----------------------------------------------------- Setters
	public boolean setMapName(String mapName)
	{	this.mapName = mapName;
		return true;  // check for valid map name
	}
	
	// ----------------------------------------------------- Other Methods
	public boolean containsRoom(Room room)
	{	return this.rooms.contains(room);
	} // end containsRoom
	
	public void addRoom(String roomName)
	{	this.rooms.add(new Room(roomName));
	}
} // end Map
