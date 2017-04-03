package commands;

import java.util.Scanner;

public class Rules implements Constants
{	// ---------------------------------------------------- Data Fields
	// =========================================================== Define 1 room in which to "store" unused items
		Location REPOSITORY = new Location(new Room(""));
	
	// =========================================================== Action Definitions
		// Format:  Action ACT = new Action(inputID, takesObject, takesObjectWithPreposition) 
		
		// Directions
		protected Action N = new Action("north", "n", false, false);
		protected Action NE = new Action("northeast", "ne", false, false);
		protected Action E = new Action("east", "e", false, false);
		protected Action SE = new Action("southeast", "se", false, false);
		protected Action S = new Action("south", "s", false, false);
		protected Action SW = new Action("southwest", "sw", false, false);
		protected Action W = new Action("west", "w", false, false);
		protected Action NW = new Action("northwest", "nw", false, false);
		protected Action U = new Action("up", "u", false, false);
		protected Action D = new Action("down", "d", false, false);
		
		// Other actions
		protected Action LOOK_IN_DIRECTION = new Action("look", "l", true, false);
		protected Action LOOK = new Action("look", "l", false, false);	
		protected Action TAKE = new Action("take", true, false);
		protected Action MOVE = new Action("move", true, false);
		protected Action SWING = new Action("swing", true, true);
		protected Action JUMP = new Action("jump", false, false);
		protected Action LIGHT = new Action("light", true, true);
		protected Action TURN_ON = new Action("turn on", true, false);  // SPECIAL CASE
		
	// ========================================================== Object Definitions
		protected Item LAMP = new Item("lamp", "lantern", REPOSITORY, 10, "A brass lantern");
		protected Item SWORD = new Item("sword", REPOSITORY, 10, "An elvish sword");
		
	// ========================================================== Reuasable Warning Messages for Player
		private final String DEADEND = "You can't go that way";
		private final String SARCASTIC_CHALLENGE = "How do you expect to accomplish that?";
		
	// ---------------------------------------------------- Constructor
	public Rules()
	{	// Initialize actions for Item variables
		LAMP.addActions(TAKE, LIGHT, TURN_ON, SWING, MOVE);
		SWORD.addActions(TAKE, SWING, MOVE);
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
