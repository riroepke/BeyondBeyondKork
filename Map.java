/*	Class:       CS 1302/XLS
 * 	Term:        Spring 2017
 *  Instructor:  Monisha Verma
 *  Assignment:  Project 2
 */	

/*	Authors: Rebekah Roepke and Ruth Bearden
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
	
	public void addRoom(Room room)
	{	this.rooms.add(room);
	}
} // end Map
