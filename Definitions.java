package commands;

public abstract class Definitions
{	// ------------------------------------------- Constants
	// ========================================================== Reusable Warning Messages for Player
			public static final String DEADEND = "You can't go that way";
			public static final String SARCASTIC_CHALLENGE = "How do you expect to accomplish that?";
			public static final String UNKOWN_PHRASE = "I don't understand...";
			public static final String UNKOWN_PHRASE_WITH_SARCASM = "Care to elaborate?";
			public static final String NOTHING_IN_DIRECTION = "There is nothing in that direction";
			public static final String LOAD_TOO_HEAVY = "Your load is too heavy!";
			public static final String SERIOUSLY = "Are you serious?";
			public static final String NOTHING = "Nothing happens";
			
			public static final String TAKEN = "Taken";
			public static final String DROPPED = "Dropped";
			public static final String ITEM_NOT_FOUND = "You don't see that here";
			public static final String CANNOT_TAKE_ITEM = "You can't take that";
			public static final String CANNOT_MOVE_ITEM = "You can't move that";
			
			public static String UNSATISFIED_ACTION(Action action)
			{	return ("What do you want to " + action.getID() + "?"); }
			public static String MOVED(String itemName, String result)
			{	return ("Moving the " + itemName + " reveals " + result); }
			public static String SWING(String itemName, String result)
			{	return ("You brandish the " + itemName + ". " + result); }
	
} // Properties
