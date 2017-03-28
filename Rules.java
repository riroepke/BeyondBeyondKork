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
		
	// ---------------------------------------------------- Constructor
	public Rules(Map map)
	{	
	}
	
	// ----------------------------- Directional movement methods
	// Generic movement method
	public boolean travel(Person p, Room toRoom)
	{	boolean canTravel = true;
		
		if(toRoom != null)
		{	Location toLocation = new Location(toRoom);
			p.setLocation(toLocation);
		}
		else
			canTravel = false;
	
		return canTravel;
	}
	
	public String n(Person p)
	{	String message = null;
		if(travel(p, p.getLocation().getRoom().getN()) == true)
		{	message = p.getLocation().getRoom().getDescription();
			
		}
		
		
		return message;
	}
	public String ne(Person p)
	{	String message = null;
		
		return message;
	}
	public String e(Person p)
	{	String message = null;
			
		return message;
	}
	public String se(Person p)
	{	String message = null;
		
		return message;	
	}
	public String s(Person p)
	{	String message = null;
		
		return message;
	}
	public String sw(Person p)
	{	String message = null;
		
		return message;
	}
	public String w(Person p)
	{	String message = null;
		
		return message;		
	}
	public String nw(Person p)
	{	String message = null;
		
		return message;		
	}
	public String u(Person p)
	{	String message = null;
		
		return message;		
	}
	public String d(Person p)
	{	String message = null;
		
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
