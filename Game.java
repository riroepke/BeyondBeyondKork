package commands;

public class Game extends Rules
{	public Map map;
	public Room ValleyBottom, InsideCave, MirrorRoom, TreasureRoom;
	public Person self;
	public Parser input;
	public String actionInput;
	public String message = null;

	public Game()
	{	map = new Map("World");
		
		
		//creation of the map
		ValleyBottom = new Room("Valley Bottom", "You are at the bottom of a steep valley.", "the cave's entrance");
			//set items in room(picket sign, rock)
			ValleyBottom.addItem(PICKETSIGN);
				PICKETSIGN.setItemDescription("There is a picket sign heres with some writing on it.");
				PICKETSIGN.setDetails("The picket sign contains writing. problably English. You might be able to read it.");
			ValleyBottom.addItem(ROCK);
				ROCK.setItemDescription("There appears to be a large rock blocking the entrance to a cave.");
				ROCK.setDetails("The rock is round and about 3 feet tall.");
		
				map.addRoom(ValleyBottom.getName());//add to map
		
		InsideCave = new Room("Cave","You're now inside the cave.", "a dark, dank, cave room");
		//set items in room(lamp, dog treats, canteen)
			InsideCave.addItem(LANTERN);
				LANTERN.setItemDescription("Light eminates from a portable lantern.");
				LANTERN.setDetails("The lantern seems to run on some form of electricity.");
			InsideCave.addItem(DOGTREAT);
				DOGTREAT.setItemDescription("There is something that looks like a hard, stale biscuit here.");
				DOGTREAT.setDetails("The biscuit is hard as a rock.");
			InsideCave.addItem(CANTEEN);
				CANTEEN.setItemDescription("There is a canteen here.");
				CANTEEN.setDetails("The canteen is closed.");
		
				map.addRoom(InsideCave.getName());//add to map
		
		MirrorRoom = new Room("Mirror Room","You just entered the Mirror Room. It looks like someone made this part of the cave into a living room."
				+"You see a hungry dog in the corner and a mirror hanging on the wall.You get this ominous feeling that someone is watching you through the mirror.",
				"looks like a room with a mirror in it");//make room and add descriptions
			//set the items in the room(dog, sword and mirror)
			MirrorRoom.addItem(DOG);//once fed the treats it will reveal the sword that will be used to break the mirror
			MirrorRoom.addItem(SWORD);//will be used to break mirror
			MirrorRoom.addItem(MIRROR);//the item will be set as breakable an once broken the condition is met so the hidden path to the treasure room is open
			
			map.addRoom(MirrorRoom.getName());//adds room to map
		
		TreasureRoom = new Room("Treasure Room","You've made it to the treassure room! Congradulations! Grab all the treasure you can carry","Looks like a room filled with many treassures");
		
		
		// Set all pre-game paths
		self = new Person("Yourself", new Location(ValleyBottom), 100, 100);
			
			
	} // end Constructor
	
	public String run(String inputFromGUI)
	{	
		
		input = new Parser(inputFromGUI);
		
		boolean keepPlaying = true;
		// Get input from user
		input.getLine();
		actionInput = input.getWord(0);
		
		// Check for direction input
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
		
		else if(LOOK_IN_DIRECTION.matches(actionInput) && input.numberOfWords() == 2)
		{	String direction = input.getWord(1);
		    message = self.lookInDirecton(direction);
		}
		else if(LOOK.matches(actionInput))
		{	message = self.look();
			
		}
		else if(TAKE.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{	String itemToTake = input.getWord(1);
				message = self.take(itemToTake);			
			}
			else
				message = Definitions.UNSATISFIED_ACTION(TAKE);
		}
		else if(DROP.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{	String itemToDrop = input.getWord(1);
				message = self.drop(itemToDrop);			
			}
			else
				message = Definitions.UNSATISFIED_ACTION(DROP);
		}
		else if(MOVE.matches(actionInput))
		{	if(input.numberOfWords() == 2)
			{	String itemToMove = input.getWord(1);
				Item item = self.getLocation().findItem(itemToMove);
				
				if(item != null)
				{	if(item == ROCK)
					{	// Move item and print result: a cave entrance is revealed
						message = item.move("a cave entrance to the north");
						ValleyBottom.setPathN(InsideCave);	             // <------------------ Event #1: Move rock
						self.setPoints(self.getPoints() + 10);                    //  Add 10 points to player score
					}
					else
						message = item.move("nothing"); // Moving the item reveals nothing
				}
					
				else
					message = Definitions.ITEM_NOT_FOUND;
			}
			
		}
		else if(SWING.matches(actionInput))
		{	if(input.numberOfWords() == 2)                   // --------------- Case 1 (1 argument) Just swing a sword
			{	String itemToSwing = input.getWord(1);
				Item item = self.getLocation().findItem(itemToSwing);
				
				if(item != null)
				{	// Notify the player that the sword has been brandished
					message = item.swing("");
					
				}
				else
					message = Definitions.ITEM_NOT_FOUND;
			}
			else if(input.numberOfWords() == 4)              // --------------- Case 2 (2 arguments) Swing sword at something 
			{	if(input.getWord(2) == "at")
				{	String itemToSwing = input.getWord(1);
					String itemToHit = input.getWord(3);
					Item itemSwung = self.getLocation().findItem(itemToSwing);
					Item itemHit = self.getLocation().findItem(itemToHit);
					
					if(itemSwung != null && itemHit != null) // Make sure item swung and item hit are both present
					{	if(itemSwung.hasAction("swing"))         // check that itemSwung can be swung
						{	if(itemHit.hasAction("hit"))         // check that itemHit can be hit
							{	if(itemHit == MIRROR)       // <------------------------------- Important Event: Break mirror
								{	// Change mirror description
									// Add passage to Treasure room
								}
								else if(itemHit == DOG)
								{	// 
									
								}
								else
									message = Definitions.NOTHING;
								
							}
							else
								message = Definitions.SERIOUSLY;
							
						}
						else
							message = itemSwung.swing("");
						
					}
					else
						message = Definitions.ITEM_NOT_FOUND;
				}
				else
					message = Definitions.UNKOWN_PHRASE;
				
			}
			else
				message = Definitions.UNKOWN_PHRASE;
		}
		
		else if(INVENTORY.matches(actionInput))
		{	message = self.inventory();
		}
		else
			message = Definitions.UNKOWN_PHRASE_WITH_SARCASM;
		
		return message;
	}
	
	/*public static void main(String[] args)
	{	Game game = new Game();
		java.util.Scanner scan = new java.util.Scanner(System.in);
		while(true)
		{	String input = scan.nextLine();
			System.out.println(game.run(input));
		}
	}*/

	// ----------------------- Define movement
	
} // end class Game
