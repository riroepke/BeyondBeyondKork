package Commands;

import java.util.Scanner;

public class Rules 
{	// ---------------------------------------------------- Data Fields
	// =========================================================== Define 1 room in which to "store" unused items
		static Location REPOSITORY = new Location(new Room(""));
	
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

		 protected static Item PICKETSIGN = new Item("Picket Sign","Sign",REPOSITORY,0,"Welcome to the mysterious caverns of Kork."
	+"Beyond this heavy rock is a maze filled with unnimaginable treasures and formidible fows.");
		//add actions(can be read, cant be taken,can look)
		
		protected static Item ROCK = new Item("Rock", "Big rock",REPOSITORY,20,"the rock looks pretty heavy, but you think you can move it");
		//add actions(can be moved,cant be taken, can look)
		
		protected static Item LANTERN = new Item("Lantern","Lamp",REPOSITORY,5,"battery powered, portable lantern. Can be used to ligth dark rooms");
		//add actions(can light, can be taken, can look)
		
		protected static Item CANTEEN = new Item("Canteen","Bottle",REPOSITORY,2,"canteen that is half filled with water.Could be usefull later.");
		//add actions(can drink,can be taken, can look)
		
		protected static Item DOGTREAT = new Item("Dog treat","treat",REPOSITORY,1,"small bag of dog treats");
		//add actions(can be taken, can eat, can look)
		
		protected static Item DOG = new Item("Dog","puppy",REPOSITORY,30,"hungry looking dog. It seems like it is gaurding something");
		//add actions(can be fed, cant be taken, can look)
		
		protected static Item SWORD = new Item("Sword","magic sword",REPOSITORY,10,"an ancient looking sword. Looks like you could do a bunch of damage with this item.Possibly break a couple things as well.");
		//add actions(can swing, can look)
		
		protected static Item MIRROR = new Item("Mirror","2-way mirror",REPOSITORY,10,"something abouot this mirror is a little off. It seems like someone can see  through the other side."
				+"You also feel a slight draft coming from the wall its hanging on");
		//add actions(can break, can look
		
	// ========================================================== Reuasable Warning Messages for Player
		private final String DEADEND = "You can't go that way";
		private final String SARCASTIC_CHALLENGE = "How do you expect to accomplish that?";
		
	// ---------------------------------------------------- Constructor
	public Rules()
	{	// Initialize actions for Item variables
		LANTERN.addActions(TAKE, LIGHT, TURN_ON, SWING, MOVE);
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
