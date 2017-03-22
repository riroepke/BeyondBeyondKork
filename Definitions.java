package commands;

public interface Definitions
{	// ------------------------------------------- Constants
	// Need one of these for each action command
	
	
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
		
	abstract String n(Person p);
	abstract String ne(Person p);
	abstract String e(Person p);
	abstract String se(Person p);
	abstract String s(Person p);
	abstract String sw(Person p);
	abstract String w(Person p);
	abstract String nw(Person p);
	abstract String u(Person p);	
	abstract String d(Person p);
	
	
	Action LOOK_IN_DIRECTION = new Action("look", "l", true, false);
	Action LOOK = new Action("look", "l", false, false);	
	Action TAKE = new Action("take", true, false);
	Action MOVE = new Action("move", true, false);
	Action SWING = new Action("swing", true, true);
	Action JUMP = new Action("jump", false, false);
	Action LIGHT = new Action("light", true, true);
		
	abstract String lookInDirecton(String direction);
	abstract String look();
	abstract String take(Item item);
	abstract String move(Item item);
	abstract String swing(Item item);
	abstract String swing(Item item, Item atItem);
	abstract String jump();
	abstract String light(Item item);
	abstract String light(Item item, Item withItem);
	
	
	// =========================================================== Object List
	// Form Item _______ = new _______ (String itemName, int mass, String description) // mass in kg
	Item SWORD = new Item("sword", 10, "This is a sword");
	Item LAMP = new Item("lamp", "lantern", 5, "This is a lmap");
	
} // Properties
