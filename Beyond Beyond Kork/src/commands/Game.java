/*	Class:       CS 1302/XLS
 * 	Term:        Spring 2017
 *  Instructor:  Monisha Verma
 *  Assignment:  Project 2
 */	

/*	Authors: Rebekah Roepke and Ruth Bearden
 */

package commands;

import javafx.scene.image.Image;

public class Game
{	private Room ValleyBottom, InsideCave, DogRoom,                // declare rooms as global variables
				 TreasureRoom, CaveEntrance;
	private Person self;                                           // declare player as a person (self)
	private Parser input;                                          // parser to get input from user
	private String actionInput;                                    // string for action the player to take (1st word on input line)
	private String message = null;                                 // message the run() method returns in response to players input
	
	private int gameStatus = Definitions.GAME_IN_PROGRESS;         // flag for the game's status (GAME_IN_PROGRESS, GAME_WON, PLAYER_DIED)
	
	private String welcomeMessage = "Welcome to KORK, brave adventurer!\n"
								+ "\nTo win this game and come out alive will require"
								+ "\nwit and mild cunning, so get ready!\n"
								+ "\n(To take a look around, type \"look\" in the box below)";
	
	
	
	// =========================================================== Define 1 room in which to "store" unused items
	private static Location REPOSITORY = new Location(new Room(""));

	// =========================================================== Action Definitions
	// Defines the name and alternative name of all actions
	
	// Directions - Travel in any of the compass direction + up and down
	private static Action N = new Action("north", "n"),
					 	  NE = new Action("northeast", "ne"),
					 	  E = new Action("east", "e"),
					 	  SE = new Action("southeast", "se"),
					 	  S = new Action("south", "s"),
					 	  SW = new Action("southwest", "sw"),
					 	  W = new Action("west", "w"),
					 	  NW = new Action("northwest", "nw"),
					 	  U = new Action("up", "u"),
					 	  D = new Action("down", "d");
	
	// Other actions                                                      //	Example inputs:
	private static Action LOOK_IN_DIRECTION = new Action("look", "l"),    //	look north
						  LOOK_IN = new Action("look in"),                //	look in mirror
						  LOOK = new Action("look", "l"),                 //	look             <- for just looking at surroundings
						  TAKE = new Action("take"),                      //	take sword
						  DROP = new Action("drop"),                      //	drop sword
						  PUT = new Action("put"),                        //	put treasure in chest
						  MOVE = new Action("move"),                      //	move rock
						  SWING = new Action("swing"),					  //	swing sword (or swing sword at mirror)
						  JUMP = new Action("jump"),					  //	jump
						  LIGHT = new Action("light"),					  //	light lamp
						  READ = new Action("read"),                      //	read sign
						  EXAMINE = new Action("examine"), 				  //	examine sign
						  DRINK = new Action("drink"),                    //	drink water
						  EAT = new Action("eat"),						  //	eat biscuit
						  FEED = new Action("feed"),					  //	feed dog biscuit   (or feed biscuit to dog)
						  HIT = new Action("hit"),						  //	hit mirror with sword
						  OPEN = new Action("open"),                      //	open chest
						  CLOSE = new Action("close"),					  //	close chest
						  INVENTORY = new Action("inventory", "i");		  //	inventory

	// ========================================================== Object Definitions
	// Item constructor format: Item item = new Item([name], [alternate name], initial location, mass);
	private static Item PICKETSIGN = new Item("sign","picket",REPOSITORY,0),
				   	    ROCK = new Item("rock", "boulder",REPOSITORY,2000),
				   	    LANTERN = new Item("lantern","lamp",REPOSITORY,10),
				   	    DOGTREAT = new Item("treat", "biscuit" ,REPOSITORY,1),
				   	    SWORD = new Item("sword",REPOSITORY,10),
				   	    DIAMOND = new Item("diamond", "jewel", REPOSITORY, 10),
				   	    PELICAN_STATUE = new Item("statue", "pelican", REPOSITORY, 100),
				   	    SILVER_CROWN = new Item("crown", "silver", REPOSITORY, 30),
				   	    PLAYER_IMAGE = new Item("familiar image", REPOSITORY, 0);
	
	private static Person DOG = new Person("dog", REPOSITORY, 150, 0);
	
	// Container constructor format: Container container = new Container([name], [alternate name], initial location, mass, max capacity, [inside description]);
	private static Container
				   	    MIRROR = new Container("mirror",REPOSITORY,10, 0, ""),                       // Mirror is really a container "holding" an image
				   	    CHEST = new Container("chest", REPOSITORY, 50, 140, "The chest is closed");  // Chest is a container that holds up to 50 units of mass

	public Game()
	{	// ================================================================ Create Map by creating Rooms and adding items to the rooms
		// Constructor format: Room room = new Room([name], [description from inside the room], [description from outside the room]);
	
		ValleyBottom = new Room("Valley Bottom", "You are at the bottom of a steep valley.", "the cave's entrance");
			ValleyBottom.addItem(PICKETSIGN);
				PICKETSIGN.setItemDescription("There is a picket sign heres with some writing on it.");
				PICKETSIGN.setDetails("The picket sign contains writing. problably English. You might be able to read it.");
				PICKETSIGN.addActions(READ);
			ValleyBottom.addItem(ROCK);
				ROCK.setItemDescription("There appears to be a large rock blocking the entrance to a cave.");
				ROCK.setDetails("The rock is round and about 3 feet tall.");
				ROCK.addActions(MOVE, TAKE);
			ValleyBottom.addItem(CHEST);
				CHEST.setItemDescription("There is a wooden chest here.");
				CHEST.setDetails(Definitions.CONTAINER_CLOSED(CHEST.getName()));
				CHEST.addActions(TAKE, SWING);
				CHEST.setClosable(true);
				CHEST.setOpenable(true);
				
			ValleyBottom.setRoomImage("file:images/valleyBottom.png");
				
			ValleyBottom.setOutside(true);
		
		CaveEntrance = new Room("Cave Entrance", "You are just inside a cave. Sunshine comes from the entrance, but the lighting is dim.", "the cave's entrance");
			CaveEntrance.setOutside(true);
			
			CaveEntrance.setRoomImage("file:images/caveEntrance.png");
			
				
		InsideCave = new Room("Cave","You are inside the cave.", "a dark, dank, cave room");
			InsideCave.addItem(LANTERN);
				LANTERN.setItemDescription("Light eminates from a portable lantern.");
				LANTERN.setDetails("The lantern seems to run on some form of electricity.");
				LANTERN.addActions(TAKE, LIGHT, SWING, MOVE);
			InsideCave.addItem(DOGTREAT);
				DOGTREAT.setItemDescription("There is something that looks like a hard, stale biscuit here.");
				DOGTREAT.setDetails("The biscuit is hard as a rock.");
				DOGTREAT.addActions(TAKE, EAT);
		
			InsideCave.setRoomImage("file:images/insideCave.png");
		
		DogRoom = new Room("Dog Room","You just entered a room with stone walls and floor.", " a dark room with a dog leaning against the wall.");
			DogRoom.addItem(DOG);
				DOG.setItemDescription("A dog sits against the wall.");
				DOG.setDetails("The dog seems to be a Rottweiller");
				DOG.addActions(FEED, HIT);
				
			DogRoom.addItem(SWORD);
				SWORD.setItemDescription("There is a sword here.");
				SWORD.setDetails("The sword has good balance.");
				SWORD.addActions(TAKE, SWING, MOVE);
			
				// Mirror does not yet exist in any location
				MIRROR.setItemDescription("There is a mirror here.");
				MIRROR.setDetails("A rather dirty individual stares back at you.");
				MIRROR.addActions(HIT, LOOK_IN); // Not fully implemented
				MIRROR.addItem(PLAYER_IMAGE);
				MIRROR.setClosable(false);
				MIRROR.open();
				MIRROR.setOpenable(false);

			DogRoom.setRoomImage("file:images/dogRoom.png");
		
		TreasureRoom = new Room("Treasure Room","This is the treasure room. What are you waiting for? Take what you came for."," gold sparkles in the dim lighting");
		
			TreasureRoom.addItem(DIAMOND);
				DIAMOND.setItemDescription("There is a very large diamond here.");
				DIAMOND.setDetails("The diamond is of inestimable worth!");
				DIAMOND.addActions(TAKE, SWING, EXAMINE, MOVE);
			
			TreasureRoom.addItem(PELICAN_STATUE);
				PELICAN_STATUE.setItemDescription("There is a golden statue of a pelican here.");
				PELICAN_STATUE.setDetails("The pelican is about 3.14159 feet high.");
				PELICAN_STATUE.addActions(TAKE, SWING, EXAMINE, MOVE);

			TreasureRoom.addItem(SILVER_CROWN);
				SILVER_CROWN.setItemDescription("There is an ornate silver crown here");
				SILVER_CROWN.setDetails("The crown has been recently polished.");
				SILVER_CROWN.addActions(TAKE, SWING, EXAMINE, MOVE);
			
			TreasureRoom.setRoomImage("file:images/treasureRoom.png");

		
		// Player
		self = new Person("Yourself", new Location(ValleyBottom), 100, 330);
		
		// Preset paths
		CaveEntrance.setPathN(InsideCave);
		InsideCave.setN(DogRoom);
		DogRoom.setN(InsideCave);
			
			
	} // end Constructor
	
	public String run(String inputFromGUI)
	{	
		
		input = new Parser(inputFromGUI);
		
		// Get input from user
		input.getLine();
		actionInput = input.getWord(0);
	
		// Make sure there is light in the room
		if(self.getLocation().hasLight() == false && self.getItemFromContainer("lantern") == null)
		{	message = Definitions.TOO_DARK;	// If the room is not lighted with sunlight or a lantern, bad things can happen		
		
			// The player will die about every other time they try to do something in a dark room other than move
			if((int)(Math.random()*100 % 2) == 0)
				gameStatus = Definitions.PLAYER_DIED;
		}
		
		
		// Note: if the room is dark, the player will move anyway unless eaten first
		// Check for direction input
		// ----------------------------------------------------------------------------------------- Travel in one of 10 directions
		if(N.matches(actionInput)) {message = self.n();}
		
		else if(NE.matches(actionInput)) {message = self.ne();}
		
		else if(E.matches(actionInput)) {message = self.e();}
		
		else if(SE.matches(actionInput)) {message = self.se();}
		
		else if(S.matches(actionInput)) {message = self.s();}
		
		else if(SW.matches(actionInput)) {message = self.sw();}
		
		else if(W.matches(actionInput)) {message = self.w();}
		
		else if(NW.matches(actionInput)) {message = self.nw();}
		
		else if(U.matches(actionInput)) {message = self.u();}
		
		else if(D.matches(actionInput)) {message = self.d();}
		
		// ----------------------------------------------------------------------------------------- Make sure the room is lighted before proceeding
		else if(gameStatus == Definitions.PLAYER_DIED
				|| self.getLocation().hasLight() == false && self.getItemFromContainer("lantern") == null)
		{	// Do nothing else besides move when it is dark
		}
		
		// ----------------------------------------------------------------------------------------- Get a description of surroundings
		else if(input.numberOfWords() == 1 && LOOK.matches(actionInput))                          // look
			message = self.look();
		// ----------------------------------------------------------------------------------------- Get an abbreviated description of adjacent room		
		else if(input.numberOfWords() == 2 && LOOK_IN_DIRECTION.matches(actionInput))             // look [direction]
			message = self.lookInDirecton(input.getWord(1));
		// ----------------------------------------------------------------------------------------- Get description of container contents
		else if(input.numberOfWords() == 3 && LOOK_IN.matches(actionInput + " in"))               // look in [container]
		    message = self.lookIn(input.getWord(2));
		
		// ----------------------------------------------------------------------------------------- Take an item from a container or room
		else if(TAKE.matches(actionInput))
		{	if(input.numberOfWords() == 2)                                                        // take [item]
				message = self.take(input.getWord(1));
			else																				  // take (needs an object)
				message = Definitions.UNSATISFIED_ACTION(TAKE);
		}
		
		// ----------------------------------------------------------------------------------------- Drop an item from possession
		else if(DROP.matches(actionInput))
		{	if(input.numberOfWords() == 2)
				message = self.drop(input.getWord(1));			
			else
				message = Definitions.UNSATISFIED_ACTION(DROP);
		}
		
		// ----------------------------------------------------------------------------------------- Put an item somewhere
		else if(input.numberOfWords() == 4 && PUT.matches(actionInput) && input.getWord(2).equals("in"))
		{	Item itemToPut = self.getItemFromContainer(input.getWord(1));
			Item container = self.getItemFromContainer(input.getWord(3));
			
			if(itemToPut == null)								  // Try to retrieve itemToPut from location
			{	itemToPut = self.getLocation().findItem(input.getWord(1));
				if(itemToPut != null)
				{	if(self.addItem(itemToPut))
						self.getLocation().removeItem(itemToPut);
				}
			}
			
			if(container == null)								  // Try to retrieve container from location
			{	container = self.getLocation().findItem(input.getWord(3));
			}
			
			if(itemToPut == null)                                 // Item not in possession
				message = Definitions.ITEM_NOT_IN_POSSESSION;
			else if(container == null)                            // Container not in location
				message = Definitions.ITEM_NOT_FOUND;
			else if(container instanceof Container == false)      // Potential container is not a container
				message = Definitions.SARCASTIC_CHALLENGE;
			else if(((Container)container).isClosed())
				message = Definitions.CONTAINER_CLOSED(container.getName());
			else                                                  // Add item to container (will give error message if container is full)
				message = self.put(itemToPut, (Container)container);
			
		}
		
		// ----------------------------------------------------------------------------------------- Move an item (reveals something or nothing happens)
		else if(MOVE.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{
				Item item = self.getLocation().findItem(input.getWord(1));
				
				if(item == null)                  // Item not found in Room/Container
					message = Definitions.ITEM_NOT_FOUND;
				else if(item.hasAction(MOVE))
					if(item == ROCK)
					{	// Move item and print result: a cave entrance is revealed
						message = item.move("a cave entrance to the north");
						ROCK.setItemDescription("There is a large rock here.");
						ValleyBottom.setPathN(CaveEntrance);	             // < ============================================================================ Event: Move rock
						self.setPoints(self.getPoints() + 10);           //  Add 10 points to player score
					}
					else
						message = item.move("nothing"); // Moving the item reveals nothing
				else
					message = Definitions.CANNOT_MOVE_ITEM;
			}
		}
		
		// ----------------------------------------------------------------------------------------- Swing an item or hit item with something
		else if(SWING.matches(actionInput) || HIT.matches(actionInput))
		{	if(SWING.matches(actionInput) && input.numberOfWords() == 2)                   // --------------- Case 1 (1 argument) Just brandish an item
			{	Item item = self.getItemFromContainer(input.getWord(1));  // check to see that sword is in possession
					
				if(item == null)                                          // Item not found in Room/Container
					message = Definitions.ITEM_NOT_IN_POSSESSION;
				else
					message = item.swing("");                             // Any item in possession can be swung with no result
			}
			else if(HIT.matches(actionInput) && input.numberOfWords() == 2)
			{	Item item = self.getLocation().findItem(input.getWord(1));
				if(item == null)
					message = Definitions.ITEM_NOT_FOUND;
				else
					message = Definitions.HIT_WITH_WHAT;
			}
		
			else if((SWING.matches(actionInput) || HIT.matches(actionInput)) && input.numberOfWords() == 4 )  // ----- Case 2 (2 arguments) Swing item at something (or hit item with something)
			{	Item itemSwung = null;
				Item itemHit = null;
				
				if((HIT.matches(actionInput) && input.getWord(2).equals("with") == false)
						|| (SWING.matches(actionInput) && input.getWord(2).equals("at") == false))
					message = Definitions.UNKOWN_PHRASE;
				
				// --------------------------- Now that the statement has been confirmed as valid, assign the correct items to itemSwung and itemHit
				else
				{	int indexItemSwung = 1, indexItemHit = 1;	  // set both indices to second word in input
					if(HIT.matches(actionInput))                  // example: hit mirror with sword
						indexItemSwung = 3;                       //                           	^ itemSwung (index = 3)
					else  // itemSwung is sword                   // example: swing sword at mirror
						indexItemHit = 3;                         //                           ^ itemHit (index = 3)
					
					itemSwung = self.getItemFromContainer(input.getWord(indexItemSwung));   // check to see that sword is in possession
					itemHit = self.getLocation().findItem(input.getWord(indexItemHit));     // check to see that target item is present
					
					if(itemSwung == null)                                // item to swing is not in player's possession
						message = Definitions.ITEM_NOT_IN_POSSESSION;    
					else if(itemHit == null)                             // item to hit cannot be found
						message = Definitions.ITEM_NOT_FOUND;
					else if(itemHit.hasAction(HIT) == false)             // it is not reasonable to hit this item
						message = Definitions.SERIOUSLY;
					// ------------------------------------------------------------- Hit the mirror with an item
					else if(itemHit == MIRROR && itemSwung == SWORD)         // < ======================================================================= Event: Break mirror
					{	// Change mirror description and properties
						MIRROR.setItemDescription("There is a shattered mirror here.");
						MIRROR.setDetails("The mirror has been shattered.");
						MIRROR.removeActions(LOOK_IN);
						message = "The mirror breaks revealing a dimly list passage heading south.";
						
						// Add passage to Treasure room
						DogRoom.setS(TreasureRoom);
						TreasureRoom.setN(DogRoom);
						
						// Add 20 points to player
						self.setPoints(self.getPoints() + 20);                // add 20 points to player score
					}
					else if(itemHit == DOG && itemSwung == SWORD)            // < ======================================================================= Event: Kill dog
					{	// kills dog immediately
						DOG.setItemDescription("There is a dead dog here.");
						DOG.setDetails("The dog is definitely dead.");
						DOG.removeActions(FEED, HIT);
						message = "The dog dies.";
					}
					else
						message = Definitions.NOTHING;
				
				} // end else
						
			}
			else                            // numberOfWords() is not 2 or 4, so the phrase is invalid
				message = Definitions.UNKOWN_PHRASE;
				
		}
		
		// ----------------------------------------------------------------------------------------- Feed an item to an entity
		else if(FEED.matches(actionInput))
		{	if(input.numberOfWords() == 3 || (input.numberOfWords() == 4 && input.getWord(2).equals("to")))
			{	int indexItemToGetFed = 1, indexItemToFeed = 1;	
			
				if(input.numberOfWords() == 3)
					indexItemToFeed = 2;      // Example: feed dog biscuit
				else
					indexItemToGetFed = 3;    // Example: feed biscuit to dog
					
			
				Item itemToGetFed = self.getLocation().findItem(input.getWord(indexItemToGetFed)); // Get item from location
				Item itemToFeed = self.getItemFromContainer(input.getWord(indexItemToFeed));       // Get item form possession
				
				if(itemToGetFed == null)             // Check for itemToGetFed in personal possession if not found in location
					itemToGetFed = self.getItemFromContainer(input.getWord(indexItemToFeed));
			
				if(itemToGetFed == null)           // The item player wants to feed is not present
					message = Definitions.ITEM_NOT_FOUND;
				else if(itemToFeed == null)        // The item player wants to use as food is not in possession 
					message = Definitions.ITEM_NOT_IN_POSSESSION;
				else if((itemToGetFed instanceof Person) == false)   // Cannot feed an item to a non-person entity
					message = Definitions.NO_CAN_DO("feed");
				else if(itemToGetFed == DOG)                                    // < ============================================================== Event: Feed dog
				{	if(itemToFeed == DOGTREAT)
					{	// Dog moves
						DOG.setItemDescription("There is a dog in the corner scratching its ear.");
						DOG.setDetails("The dog looks sleepy.");
						message = "The dogs wolfes down the treat and moves to the corner, revealing a mirror.";
					
						// Mirror is revealed
						DogRoom.addItem(MIRROR);	
						self.removeItem(DOGTREAT); // Item is removed from possession
					}
					else
					{	message = "The dog wolfes down the treat.";
						self.removeItem(itemToFeed);
					}
				}		
			}
			else
				message = Definitions.UNSATISFIED_ACTION(EAT);
		}
		
		// ----------------------------------------------------------------------------------------- Eat something
		else if(EAT.matches(actionInput))
		{	if(input.numberOfWords() == 2)
				message = self.eat(input.getWord(1));
			else
				message = Definitions.UNSATISFIED_ACTION(EAT);
		}
		
		// ----------------------------------------------------------------------------------------- Drink something
		else if(DRINK.matches(actionInput))
		{	if(input.numberOfWords() == 2)
				message = self.drink(input.getWord(1));
			else
				message = Definitions.UNSATISFIED_ACTION(DRINK);
			
		}
		
		// ----------------------------------------------------------------------------------------- Examine an item
		else if(EXAMINE.matches(actionInput))
		{	if(input.numberOfWords() == 2)
				message = self.examine(input.getWord(1));
			else
				message = Definitions.UNSATISFIED_ACTION(EXAMINE);
		}
		
		// ----------------------------------------------------------------------------------------- Read something
		else if(READ.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{	Item itemToBeRead = self.getLocation().findItem(input.getWord(1));
			
				if(itemToBeRead == null)                              // Check for item in player possession
					itemToBeRead = self.getItemFromContainer(input.getWord(1));
				if(itemToBeRead == null)						      // The item was not found
					message = Definitions.ITEM_NOT_FOUND;
				else if(itemToBeRead.hasAction(READ) == false)        // The item can't be read
					message = Definitions.NO_CAN_DO("read");
				else if(itemToBeRead == PICKETSIGN)
					message = "The sign reads: Welcome to KORK, brave adventurer, and see whether you can find a treasure!";
			}
			else
				message = Definitions.UNKOWN_PHRASE;
		}
		
		// ----------------------------------------------------------------------------------------- Open a container
		else if(OPEN.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{	Item container = self.getLocation().findItem(input.getWord(1));
				
				if(container == null)                              // Check for item in player possession
					container = self.getItemFromContainer(input.getWord(1));
				
				if(container == null)						       // The item was not found
					message = Definitions.ITEM_NOT_FOUND;
				else if(container instanceof Container == false)   // Item was not a container
					message = Definitions.NO_CAN_DO("open");
				else if(((Container)container).isClosed() == false)// Container is already open
					message = Definitions.ALREADY(container.getName(), "open");
				else if(((Container)container).canOpen() == false) // Container cannot be opened
					message = Definitions.NO_CAN_DO("open");
				else if(((Container)container).isLocked())         // Container is locked
					message = Definitions.CONTAINER_LOCKED(container.getName());
				else
				{	message = ((Container)container).open();       // Open container
					((Container)container).setDetails(Definitions.CONTAINER_OPEN(((Container)container).getName()));
				}
			}
			else
				message = Definitions.UNSATISFIED_ACTION(OPEN);
		}
		
		// ----------------------------------------------------------------------------------------- Close a container
		else if(CLOSE.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{	Item container = self.getLocation().findItem(input.getWord(1)); // Get item from location
			
				if(container == null)                              // Check for item in player possession
					container = self.getItemFromContainer(input.getWord(1));
				
				if(container == null)						       // The item was not found
					message = Definitions.ITEM_NOT_FOUND;
				else if(container instanceof Container == false)   // Item was not a container
					message = Definitions.NO_CAN_DO("close");
				else if(((Container)container).isClosed() == true) // Container is already closed
					message = Definitions.ALREADY(container.getName(), "closed");
				else if(((Container)container).canOpen() == false) // Container cannot be opened
					message = Definitions.NO_CAN_DO("close");
				else
				{	message = ((Container)container).close();      // close container
					((Container)container).setDetails(Definitions.CONTAINER_CLOSED(((Container)container).getName()));
				}	
			}
			else
				message = Definitions.UNSATISFIED_ACTION(OPEN);
		}
		
		// ----------------------------------------------------------------------------------------- Jump in the air
		else if(input.numberOfWords() == 1 && JUMP.matches(actionInput))
		{	message = Definitions.WHEE;			
		}
		
		// ----------------------------------------------------------------------------------------- Take inventory of items in possession
		else if(INVENTORY.matches(actionInput))
		{	message = self.inventory();
		}
		
		// ----------------------------------------------------------------------------------------- Phrase is invalid
		else
			message = Definitions.UNKOWN_PHRASE_WITH_SARCASM;
		
		// ==================================== Change message if player has died
		if(gameStatus == Definitions.PLAYER_DIED
				|| self.getLocation().hasLight() == false && self.getItemFromContainer("lantern") == null)
		{	if(gameStatus == Definitions.PLAYER_DIED)
				message = Definitions.TOO_DARK + "\nA famished dark-loving monster mistakes you for its lunch.";
			else
				message = Definitions.TOO_DARK + "\nYou hear something snuffling around in the dark";
		}
		
		
		// =============== Game-Winning Condition: The Chest contains the diamond, pelican statue, and silver crown and has been closed
		if(CHEST.getItems().contains(DIAMOND) && CHEST.getItems().contains(PELICAN_STATUE) && CHEST.getItems().contains(SILVER_CROWN)
				&& CHEST.isClosed())
			this.gameStatus = Definitions.GAME_WON;
		
		
		
		return message;
	} // run()
	
	// Return the game statue (in progress, lost, won)
	public int getGameStatus()
	{	return this.gameStatus;	
	}
	
	// Return welcome message for game
	public String getWelcomeMessage()
	{	return this.welcomeMessage;		
	}
	
	// Return an image overlay for marking the current room
	public Image getRoomMarker()
	{	Image overlay = null;
		Room currentRoom = null;
	
		if(self.getLocation().isRoom())
			currentRoom = self.getLocation().getRoom();
		else
			currentRoom = self.getLocation().getContainer().getLocation().getRoom();
		
		overlay = currentRoom.getRoomImage();
	
		return overlay;
	}
	
} // end class Game