package commands;

import java.util.Scanner;

public class Rules implements Definitions
{	// ---------------------------------------------------- Data Fields
	// =========================================================== Define 1 room in which to "store" unused items
		Location REPOSITORY = new Location(new Room(""));
	
	// =========================================================== Action Definitions
		// Format:  Action ACT = new Action(inputID, takesObject, takesObjectWithPreposition) 
		
		// Directions
		Action N = new Action("north", "n", false, false);
		Action NE = new Action("northeast", "ne", false, false);
		Action E = new Action("east", "e", false, false);
		Action SE = new Action("southeast", "se", false, false);
		Action S = new Action("south", "s", false, false);
		Action SW = new Action("southwest", "sw", false, false);
		Action W = new Action("west", "w", false, false);
		Action NW = new Action("northwest", "nw", false, false);
		Action U = new Action("up", "u", false, false);
		Action D = new Action("down", "d", false, false);
		
		// Other actions
		Action LOOK_IN_DIRECTION = new Action("look", "l", true, false);
		Action LOOK = new Action("look", "l", false, false);	
		Action TAKE = new Action("take", true, false);
		Action MOVE = new Action("move", true, false);
		Action SWING = new Action("swing", true, true);
		Action JUMP = new Action("jump", false, false);
		Action LIGHT = new Action("light", true, true);
		
	// ========================================================== Object Definitions
		Item LAMP = new Item("lamp", "lantern", REPOSITORY, 10, "A brass lantern");
		Item SWORD = new Item("sword", REPOSITORY, 10, "An elvish sword");
		
	// ========================================================== Reuasable Warning Messages for Player
		private final String DEADEND = "You can't go that way";
		private final String SARCASTIC_CHALLENGE = "How do you expect to accomplish that?";
		
	// ---------------------------------------------------- Constructor
	public Rules()
	{	
	}
	
	// ----------------------------- Directional movement methods
	// Generic movement method
	public boolean travel(Person p, Room destination)
	{	boolean canTravel = true;
		
		/*  null signifies dead end. If indicated destination is not a dead end,
		 *   set person's location to the new location
		 */
		if(destination != null)
		{	// Convert Room to more general location (either a Room or a Container)
			Location toLocation = new Location(destination);
			
			// Set person's location to the new location
			p.setLocation(toLocation);
		}
		else // The indicated destination is a dead end
			canTravel = false;
	
		return canTravel;
	}
	
	/*	Each of the subsequent methods will attempt to move a person in a particular direction.
	 * 	Each will
	 * 	(1) Check person's current location
	 * 		case 1: Person is in a Room; Move to (2)
	 * 		case 2: Person is in a Container; Send warning message
	 * 	(2) Check whether intended direction is a valid path
	 * 		case 1: yes; return room description + items in room as a String
	 * 		case 2: no; send a warning message
	 */
	
	// (Documentation only included in n() method)
	public String n(Person p) // --------------- Move person North
	{	String message = null;
		Room room;
		
		/****************** (1) Check person's current location *********************/
		/* case 1: Person is in a Room*/
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom(); // Convert person's location to a Room
		
			/****************(2) Cehck whether intended direction is a valid path ***/
			/* case 1: yes */
			if(travel(p, room.getN()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			/* case 2: no */
			else
				message = DEADEND;
		}
		
		/* case 2: Person is in a Container*/
		else
			message = SARCASTIC_CHALLENGE;
		
		return message;
	}
	public String ne(Person p)// --------------- Move person Northeast
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getNE()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;
	}
	public String e(Person p)// --------------- Move person East
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getE()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		
		return message;
	}
	public String se(Person p)// --------------- Move person Southeast
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getSE()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;	
	}
	public String s(Person p)// --------------- Move person South
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getS()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;
	}
	public String sw(Person p)// --------------- Move person Southwest
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getSW()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;
	}
	public String w(Person p)// --------------- Move person West
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getW()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;		
	}
	public String nw(Person p)// --------------- Move person Northwest
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getNW()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;		
	}
	public String u(Person p)// --------------- Move person Up
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getU()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;		
	}
	public String d(Person p)// --------------- Move person Down
	{	String message = null;
		Room room;
		if(p.getLocation().isRoom())
		{	room = p.getLocation().getRoom();
			if(travel(p, room.getD()) == true)
			{	message = room.getDescription();
				message += room.getItemDescriptions();
			}
			else
				message = DEADEND;
		}
		else
			message = SARCASTIC_CHALLENGE;
		return message;		
	}
	
	// ---------------------------- Implementations of actions
	public String lookInDirecton(String direction)
	{	String message = null;
	
		return message;		
	}
	public String look()
	{	String message = null;
	
		return message;		
	}
	public String take(Item item)
	{	String message = null;
	
		return message;		
	}
	public String move(Item item)
	{	String message = null;
	
		return message;		
	}
	public String swing(Item item)
	{	String message = null;
	
		return message;		
	}
	public String swing(Item item, Item atItem)
	{	String message = null;
	
		return message;		
	}
	public String jump()
	{	String message = null;
	
		return message;		
	}
	public String light(Item item)
	{	String message = null;
	
		return message;		
	}
	public String light(Item item, Item withItem)
	{	String message = null;
	
		return message;		
	}

}  // end Rules
