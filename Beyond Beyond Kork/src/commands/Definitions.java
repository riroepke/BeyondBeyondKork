/*	Class:       CS 1302/XLS
 * 	Term:        Spring 2017
 *  Instructor:  Monisha Verma
 *  Assignment:  Project 2
 */	

/*	Authors: Rebekah Roepke and Ruth Bearden
 */

package commands;

public abstract class Definitions
{	// ------------------------------------------- Constants
	// ========================================================== Reusable Warning Messages for Player
			public static final String DEADEND = "You can't go that way";
			public static final String SARCASTIC_CHALLENGE = "How do you expect to do that?";
			public static final String UNKOWN_PHRASE = "I don't understand...";
			public static final String UNKOWN_PHRASE_WITH_SARCASM = "I beg your pardon...";
			public static final String NOTHING_IN_DIRECTION = "There is nothing in that direction";
			public static final String LOAD_TOO_HEAVY = "Your load is too heavy!";
			public static final String SERIOUSLY = "You can't be serious!";
			public static final String NOTHING = "Nothing happens";
			public static final String THAT_WAS_GOOD = "Thank you. That hit this spot!";
			public static final String DONE = "Done";
			
			public static final String TAKEN = "Taken";
			public static final String DROPPED = "Dropped";
			public static final String EATEN = "Eaten";
			public static final String ITEM_NOT_IN_POSSESSION = "You don't have that";
			public static final String ITEM_NOT_FOUND = "You don't see that here";
			public static final String CANNOT_TAKE_ITEM = "You can't take that";
			public static final String CANNOT_MOVE_ITEM = "You can't move that";
			public static final String CANNOT_EAT_ITEM = "You can't eat that!";
			public static final String HIT_WITH_WHAT = "What would you like to hit that with?";
			public static final String TOO_FULL = "There is not enough room";
			public static final String ALREADY_TAKEN = "You already have that";
			
			public static final String WHEE = "Wheeeee!";
			
			public static final String TOO_DARK = "It is too dark to see";
			
			public static String UNSATISFIED_ACTION(Action action)
			{	return ("What do you want to " + action.getID() + "?");
			}
			public static String MOVED(String itemName, String result)
			{	return ("Moving the " + itemName + " reveals " + result);
			}
			public static String SWING(String itemName, String result)
			{	return ("You brandish the " + itemName + ". " + result);
			}
			public static String NO_CAN_DO(String action)
			{	return ("You can't " + action + " that");				
			}
			
			public static String CONTAINER_CLOSED(String containerName)
			{	return ("The " + containerName + " is closed");
			}
			public static String CONTAINER_OPEN(String containerName)
			{	return ("The " + containerName + " is open");
			}
			public static String CONTAINER_EMPTY(String containerName)
			{	return ("The " + containerName + " is empty");
			}
			public static String CONTAINER_LOCKED(String containerName)
			{	return ("The " + containerName + " is locked");
			}
			
			public static String ALREADY(String itemName, String status)
			{	return ("The " + itemName + " is already " + status);
			}
			
			// ------------------------------------------------------------ Player Status Constants
			public static int GAME_WON = 1;
			public static int PLAYER_DIED = -1;
			public static int GAME_IN_PROGRESS = 0;
			
			public static String VICTORY_MESSAGE = "Congratulations!"
					                           + "\nYou have won the KORK game!";
			public static String DEATH_MESSAGE = "Unfortunately, you have died...";
	
} // Properties
