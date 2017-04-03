/*	Authors:		Peter Bearden, Ruth Bearden
 *  Date:			3/4/17
 *  Project:		Adventure Game Creation Commands
 */

package commands;

import java.util.ArrayList;

public class Room
{	// --------------------------------------------------- Data Fields
	private Room N, NE, E, SE, S, SW, W, NW, U, D; // Rooms in every direction
	private String roomName, insideDescription, outsideDescription;
	private ArrayList<Item> items;

	// --------------------------------------------------- Constructors
	public Room(String roomName)
	{	this.roomName = roomName;
		this.items = new ArrayList<>();
	}
	
	public Room(String roomName, String insideDescription, String outsideDescription)
	{	this(roomName);
		this.insideDescription = insideDescription;
		this.outsideDescription = outsideDescription;
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
	
	public void setPathN(Room room)
	{	this.N = room;
		room.setS(this);
	}
	
	public void setPathNE(Room room)
	{	this.NE = room;
		room.setSW(this);
	}
	
	public void setPathE(Room room)
	{	this.E = room;
		room.setW(this);
	}
	
	public void setPathSE(Room room)
	{	this.SE = room;
		room.setNW(this);
	}
	
	public void setPathS(Room room)
	{	this.S = room;
		room.setN(this);
	}
	
	public void setPathSW(Room room)
	{	this.SW = room;
		room.setNE(this);
	}
	
	public void setPathW(Room room)
	{	this.W = room;
		room.setE(this);			
	}
	
	public void setPathNW(Room room)
	{	this.NW = room;
		room.setSE(this);
	}
	
	public void setPathU(Room room)
	{	this.U = room;
		room.setD(this);
	}
	
	public void setPathD(Room room)
	{	this.D = room;
		room.setU(this);
	}
	
	
	/*	Make a ONE-WAY connection between two rooms.	 * 	
	 */	
	
	/* Direction setter methods */
	public void setN(Room room)
	{	this.N = room;}
	public void setNE(Room room)
	{	this.NE = room;}
	public void setE(Room room)
	{	this.E = room;}
	public void setSE(Room room)
	{	this.SE = room;}
	public void setS(Room room)
	{	this.S = room;}
	public void setSW(Room room)
	{	this.SW = room;}
	public void setW(Room room)
	{	this.W = room;}
	public void setNW(Room room)
	{	this.NW = room;}
	public void setU(Room room)
	{	this.U = room;}
	public void setD(Room room)
	{	this.D = room;}
	
	
	/*  Remove straight path between two rooms.	 * 
	 */
	public void removePathN()
	{	this.N.S = null;
		this.N = null;
	}
	
	public void removePathNE()
	{	this.NE.SW = null;
		this.NE = null;
	}
	
	public void removePathE()
	{	this.E.W = null;
		this.E = null;
	}
	
	public void removePathSE()
	{	this.SE.NW = null;
		this.SE = null;
	}
	
	public void removePathS()
	{	this.S.N = null;
		this.S = null;
	}
	
	public void removePathSW()
	{	this.SW.NE = null;
		this.SW = null;
	}
	
	public void removePathW()
	{	this.W.E = null;
		this.W = null;
	}
	
	public void removePathNW()
	{	this.NW.SE = null;
		this.NW = null;
	}
	
	public void removePathU()
	{	this.U.D = null;
		this.U = null;
	}
	
	public void removePathD()
	{	this.D.U = null;
		this.D = null;
	}
	
	/*	Remove exit from room. (ONE-DIRECTION removal)
	 */
	public void removeN()
	{	this.N = null; }
	public void removeNE()
	{	this.NE = null; }
	public void removeE()
	{	this.E = null; }
	public void removeSE()
	{	this.SE = null; }
	public void removeS()
	{	this.S = null; }
	public void removeSW()
	{	this.SW = null; }
	public void removeW()
	{	this.W = null; }
	public void removeNW()
	{	this.NW = null; }
	public void removeU()
	{	this.U = null; }
	public void removeD()
	{	this.D = null; }
	
	/*  Return the room from the exit in a certain direction */
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
	
	/*	Place an item in the room */
	public boolean addItem(Item item)
	{	boolean taskCompleted = true;    // Need to check this in future
		this.items.add(item);
		return taskCompleted;
	}
	
	/*	Remove item from the room */
	public boolean removeItem(Item item)
	{	boolean taskCompleted = true;    // Need to check this in future
		this.items.remove(item);
		return taskCompleted;
	}
	
	// ========================================= Description Setters
	// Set description of Room from the inside
	public void setInsideDescription(String insideDescription)
	{	this.insideDescription = insideDescription;		
	}
	
	// Set description of Room from the outside
	public void setOutsideDescription(String outsideDescription)
	{	this.outsideDescription = outsideDescription;		
	}
	
	// ========================================= Description Getters
	// Retrieve the Room'ss description as seen from the inside
	public String getInsideDescription()
	{	return this.insideDescription;
	}
	
	// Retrieve the Room's description as seen from the outside
	public String getOutsideDescription()
	{	return this.outsideDescription;
	}
	
	// Get Descriptions of Items as a list
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
	
} // end Room
