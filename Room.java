/*	Authors:		Peter Bearden, Ruth Bearden
 *  Date:			3/4/17
 *  Project:		Adventure Game Creation Commands
 */

package commands;

import java.util.ArrayList;

public class Room
{	// --------------------------------------------------- Data Fields
	private Room N, NE, E, SE, S, SW, W, NW, U, D; // Rooms in every direction
	private String roomName, description;
	private ArrayList<Item> items;

	// --------------------------------------------------- Constructors
	public Room(String roomName)
	{	this.roomName = roomName;
		this.items = new ArrayList<>();
	}
	
	public Room(String roomName, String description)
	{	this(roomName);
		this.description = description;		
	}
	
	// --------------------------------------------------- Getters
	public String getName()
	{	return this.roomName;
	}
	
	public ArrayList<Item> getItemList()
	{	return this.items;		
	}
	
	// --------------------------------------------------- Setters
	
	/*	Make a TWO-WAY connection between two rooms. These methods
	 *  may be used in making a two-way path between two rooms whose
	 *  connecting path is straight (i.e. Move S undoes Move N)	
	 */	
	
	public void setPathN(Room room) throws InvalidRoomSetException
	{	this.N = room;
		room.setS(this);
	}
	
	public void setPathNE(Room room) throws InvalidRoomSetException
	{	this.NE = room;
		room.setSW(this);
	}
	
	public void setPathE(Room room) throws InvalidRoomSetException
	{	this.E = room;
		room.setW(this);
	}
	
	public void setPathSE(Room room) throws InvalidRoomSetException
	{	this.SE = room;
		room.setNW(this);
	}
	
	public void setPathS(Room room) throws InvalidRoomSetException
	{	this.S = room;
		room.setN(this);
	}
	
	public void setPathSW(Room room) throws InvalidRoomSetException
	{	this.SW = room;
		room.setNE(this);
	}
	
	public void setPathW(Room room) throws InvalidRoomSetException
	{	this.W = room;
		room.setE(this);			
	}
	
	public void setPathNW(Room room) throws InvalidRoomSetException
	{	this.NW = room;
		room.setSE(this);
	}
	
	public void setPathU(Room room) throws InvalidRoomSetException
	{	this.U = room;
		room.setD(this);
	}
	
	public void setPathD(Room room) throws InvalidRoomSetException
	{	this.D = room;
		room.setU(this);
	}
	
	
	/*	Make a ONE-WAY connection between two rooms.	 * 	
	 */	
	
	/* Direction setter methods */
	public void setN(Room room)  throws InvalidRoomSetException
	{	this.N = room;}
	public void setNE(Room room) throws InvalidRoomSetException
	{	this.NE = room;}
	public void setE(Room room) throws InvalidRoomSetException
	{	this.E = room;}
	public void setSE(Room room) throws InvalidRoomSetException
	{	this.SE = room;}
	public void setS(Room room) throws InvalidRoomSetException
	{	this.S = room;}
	public void setSW(Room room) throws InvalidRoomSetException
	{	this.SW = room;}
	public void setW(Room room) throws InvalidRoomSetException
	{	this.W = room;}
	public void setNW(Room room) throws InvalidRoomSetException
	{	this.NW = room;}
	public void setU(Room room) throws InvalidRoomSetException
	{	this.U = room;}
	public void setD(Room room) throws InvalidRoomSetException
	{	this.D = room;}
	
	
	/*  Remove straight path between two rooms.	 * 
	 */
	public void removePathN() throws InvalidRoomRemovalException
	{	this.N.S = null;
		this.N = null;
	}
	
	public void removePathNE() throws InvalidRoomRemovalException
	{	this.NE.SW = null;
		this.NE = null;
	}
	
	public void removePathE() throws InvalidRoomRemovalException
	{	this.E.W = null;
		this.E = null;
	}
	
	public void removePathSE() throws InvalidRoomRemovalException
	{	this.SE.NW = null;
		this.SE = null;
	}
	
	public void removePathS() throws InvalidRoomRemovalException
	{	this.S.N = null;
		this.S = null;
	}
	
	public void removePathSW() throws InvalidRoomRemovalException
	{	this.SW.NE = null;
		this.SW = null;
	}
	
	public void removePathW() throws InvalidRoomRemovalException
	{	this.W.E = null;
		this.W = null;
	}
	
	public void removePathNW() throws InvalidRoomRemovalException
	{	this.NW.SE = null;
		this.NW = null;
	}
	
	public void removePathU() throws InvalidRoomRemovalException
	{	this.U.D = null;
		this.U = null;
	}
	
	public void removePathD() throws InvalidRoomRemovalException
	{	this.D.U = null;
		this.D = null;
	}
	
	/*	Remove exit from room. (ONE-DIRECTION removal)
	 */
	public void removeN() throws InvalidRoomRemovalException
	{	this.N = null; }
	public void removeNE() throws InvalidRoomRemovalException
	{	this.NE = null; }
	public void removeE() throws InvalidRoomRemovalException
	{	this.E = null; }
	public void removeSE() throws InvalidRoomRemovalException
	{	this.SE = null; }
	public void removeS() throws InvalidRoomRemovalException
	{	this.S = null; }
	public void removeSW() throws InvalidRoomRemovalException
	{	this.SW = null; }
	public void removeW() throws InvalidRoomRemovalException
	{	this.W = null; }
	public void removeNW() throws InvalidRoomRemovalException
	{	this.NW = null; }
	public void removeU() throws InvalidRoomRemovalException
	{	this.U = null; }
	public void removeD() throws InvalidRoomRemovalException
	{	this.D = null; }
	
	/*  Return the room from the exit in a certain direction
	 */
	public Room getN()
	{	return this.N; }
	public Room getNE()
	{	return this.NE; }
	public Room getE()
	{	return this.E; }
	public Room getSE()
	{	return this.SE; }
	public Room getS()
	{	return this.S; }
	public Room getSW()
	{	return this.SW; }
	public Room getW()
	{	return this.W; }
	public Room getNW()
	{	return this.NW; }
	public Room getU()
	{	return this.U; }
	public Room getD()
	{	return this.D; }
	
	/*	Place an item in the room
	 */
	public boolean putItem(Item item)
	{	boolean taskCompleted = true;    // Need to check this in future
		this.items.add(item);
		return taskCompleted;
	}
	
	/*	Remove item from the room
	 */
	public boolean removeItem(Item item)
	{	boolean taskCompleted = true;    // Need to check this in future
		this.items.remove(item);
		return taskCompleted;
	}
	
} // end Room
