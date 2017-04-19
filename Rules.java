package commands;

import java.util.Scanner;

public class Rules 
{	// ---------------------------------------------------- Data Fields
	
	// =========================================================== Define 1 room in which to "store" unused items
		protected static Location REPOSITORY = new Location(new Room(""));
	
	// =========================================================== Action Definitions
		// Format:  Action ACT = new Action(inputID, takesObject, takesObjectWithPreposition) 
		
		// Directions
		protected static Action N = new Action("north", "n", false, false);
		protected static Action NE = new Action("northeast", "ne", false, false);
		protected static Action E = new Action("east", "e", false, false);
		protected static Action SE = new Action("southeast", "se", false, false);
		protected static Action S = new Action("south", "s", false, false);
		protected static Action SW = new Action("southwest", "sw", false, false);
		protected static Action W = new Action("west", "w", false, false);
		protected static Action NW = new Action("northwest", "nw", false, false);
		protected static Action U = new Action("up", "u", false, false);
		protected static Action D = new Action("down", "d", false, false);
		
		// Other actions
		protected static Action LOOK_IN_DIRECTION = new Action("look", "l", true, false);
		protected static Action LOOK_IN = new Action("look in", true, false);
		protected static Action LOOK = new Action("look", "l", false, false);	
		protected static Action TAKE = new Action("take", true, false);
		protected static Action DROP = new Action("drop", true, false);
		protected static Action MOVE = new Action("move", true, false);
		protected static Action SWING = new Action("swing", true, true);
		protected static Action JUMP = new Action("jump", false, false);
		protected static Action LIGHT = new Action("light", true, true);
		protected static Action READ = new Action("read", true, false);
		protected static Action EXAMINE = new Action("examine", true, false);
		protected static Action DRINK = new Action("drink", true, false);
		protected static Action EAT = new Action("eat", true, false);
		protected static Action FEED = new Action("feed", true, true);
		protected static Action BREAK = new Action("break", true, true);
		protected static Action TURN_ON = new Action("turn on", true, false);  // SPECIAL CASE
		protected static Action INVENTORY = new Action("inventory", "i", false, false);
		
	// ========================================================== Object Definitions

		protected static Item PICKETSIGN = new Item("sign","picket",REPOSITORY,0,"Welcome to the mysterious caverns of Kork."
				+"Beyond this heavy rock is a maze filled with unnimaginable treasures and formidible fows.");
		protected static Item ROCK = new Item("rock", "boulder",REPOSITORY,2000,"the rock looks pretty heavy, but you think you can move it");
		protected static Item LANTERN = new Item("lantern","lamp",REPOSITORY,5,"battery powered, portable lantern. Can be used to ligth dark rooms");
		protected static Item CANTEEN = new Item("canteen","bottle",REPOSITORY,2,"canteen that is half filled with water.Could be usefull later.");
		protected static Item DOGTREAT = new Item("treat", "lump" ,REPOSITORY,1,"small bag of dog treats");
		protected static Item DOG = new Item("dog","puppy",REPOSITORY,30,"hungry looking dog. It seems like it is gaurding something");
		protected static Item SWORD = new Item("sword",REPOSITORY,10,"an ancient looking sword. Looks like you could do a bunch of damage with this item.Possibly break a couple things as well.");
		protected static Item MIRROR = new Item("mirror",REPOSITORY,10,"something abouot this mirror is a little off. It seems like someone can see  through the other side."
				+"You also feel a slight draft coming from the wall its hanging on");
		
	// ========================================================== Reusable Warning Messages for Player
		private final String DEADEND = "You can't go that way";
		private final String SARCASTIC_CHALLENGE = "How do you expect to accomplish that?";
		
	// ---------------------------------------------------- Constructor
	public Rules()
	{	// Initialize actions for Item variables
		PICKETSIGN.addActions(READ, EXAMINE);
		ROCK.addActions(MOVE, EXAMINE, TAKE);
		LANTERN.addActions(TAKE, LIGHT, TURN_ON, SWING, MOVE);
		CANTEEN.addActions(DRINK, LOOK_IN, EXAMINE);
		DOGTREAT.addActions(TAKE, EAT, EXAMINE);
		DOG.addActions(FEED);
		SWORD.addActions(TAKE, SWING, MOVE, EXAMINE);
		MIRROR.addActions(BREAK, LOOK_IN);
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

} // end Rules
