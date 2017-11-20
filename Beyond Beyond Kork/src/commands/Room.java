/*	Class:       CS 1302/XLS
 * 	Term:        Spring 2017
 *  Instructor:  Monisha Verma
 *  Assignment:  Project 2
 */	

/*	Authors: Rebekah Roepke and Ruth Bearden
 */

package commands;

import java.util.ArrayList;
import javafx.scene.image.Image;
import java.io.File;

public class Room
{	// --------------------------------------------------- Data Fields
	private Room N, NE, E, SE, S, SW, W, NW, U, D; // Rooms in every direction
	private String roomName, insideDescription, outsideDescription;
	private ArrayList<Item> items;
	
	private boolean outside = false;               // marks whether or not the room is outside
	private Image roomImage;

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
	
	public Image getRoomImage()
	{	return this.roomImage;
	}
	
	// --------------------------------------------------- Setters
	
	// Set the position of a room to be outside (lighted automatically) or inside (lighted with lamp)
	public void setOutside(boolean outside)
	{	this.outside = outside;
	}
	
	public boolean setRoomImage(String fileName)
	{	boolean imageExists = false;
		
		File file = new File(fileName);  // check that file exists
		if(file.exists())
			imageExists = true;
		
		this.roomImage = new Image(fileName);
		
		
		return imageExists;
	}
	
	
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
	public boolean addItem(Item newItem)
	{	newItem.location = new Location(this);          // Set location of Item to current Container
		return this.items.add(newItem);                    // Indicate successful add
	}
	
	/*	Remove item from the room */
	public boolean removeItem(Item item)
	{	return this.items.remove(item);
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
	
	// =========================================================== Description Getters
	// Retrieve the Room'ss description as seen from the inside
	public String getInsideDescription()
	{	return this.insideDescription;
	}
	
	// Retrieve the Room's description as seen from the outside
	public String getOutsideDescription()
	{	return this.outsideDescription;
	}
	
	// List of directions that can be traveled
	public String getExitList()
	{	String message = "\nThere are exits ";
		java.util.ArrayList<String> roomNames = new java.util.ArrayList<>();
		
		if(this.N != null)
			roomNames.add("north ");
		if(this.NE != null)
			roomNames.add("northeast ");
		if(this.E != null)
			roomNames.add("northeast ");
		if(this.SE != null)
			roomNames.add("southeast ");
		if(this.S != null)
			roomNames.add("south ");
		if(this.SW != null)
			roomNames.add("southwest ");
		if(this.W != null)
			roomNames.add("west ");
		if(this.NW != null)
			roomNames.add("northwest ");
		if(this.U != null)
			roomNames.add("up ");
		if(this.D != null)
			roomNames.add("down ");
		
		// ------------ Add results to message
			// Case 1: 0 results
			if(roomNames.size() == 0)
				message = "";  // empty message
			else
			{	// Case 2: 1 result
				if(roomNames.size() == 1)
					message = "\nThere is an exit to the ";
				// Case 3: 2 or more results
				else
					message = "\nThere are exits to the ";
				
				for(int i = 0; i < roomNames.size(); i++)
				{	if(i < roomNames.size() - 1 && roomNames.size() != 2)
						message += roomNames.get(i) + ", ";
					else
					{	if(roomNames.size() > 1)
							message += "and ";
						message += roomNames.get(i);
					}
				}
			}
		
		
		return message;
	}
	
	// Get Descriptions of Items as a list
	public String getListedItems()
	{	String listAsString = null;
		String beingVerb = " is";
		
		// Add each item in Room on the list
		for(int i = 0; i < items.size(); i++)
		{	listAsString = "";
			
			// Check whether item is singular or plural
			if(items.get(i).isPlural())
				beingVerb = " are";
			listAsString += items.get(i).getNameWithArticle() + beingVerb + " here\n";
			
			// For every container, list its contents
			if(items.get(i) instanceof Container)
				listAsString += ((Container)(items.get(i))).getListedItems();
		}
		
		return listAsString;
	}
	
	// Get more detailed item descriptions in sentence form
	public String getItemDescriptions()
	{	String message = "";
	
		for(int i = 0; i < items.size(); i++)
			message += " " + items.get(i).getItemDescription();
		return message;		
	}
	
	// Determine whether Room contains an item (directly or indirectly)
	public Item getItemFromRoom(String itemName)
	{	Item item = null;
		
		// make sure itemName is in standard form
		itemName = itemName.trim().toLowerCase();
		
	
		// search items for item with itemName
		for(int i = 0; i < this.items.size(); i++)
		{	item = this.items.get(i);			
		
			// If item is not identified by either regular or alternate name, set it to null
			if(!item.matches(itemName))
			{	// if item is a container that is open, search container for the item
				if(item instanceof Container && ((Container)item).isClosed() == false)
				{	item = ((Container)item).getItemFromContainer(itemName);
				}
				
				if(item != null && !item.matches(itemName))
					item = null;
			}
			
			if(item != null) // Break for loop if item has been found
				break;
		}
	
		return item;
	}
	
	// Determine whether or not there is light in the room
	public boolean hasLight()
	{	return (this.outside == true || this.getItemFromRoom("lantern") != null);
	}
	
} // end Room
