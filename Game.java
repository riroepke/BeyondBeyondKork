package Commands;

public class Game extends Rules
{	public static void main(String[] args)
	{	
	Map map = new Map("BeyondKork");
	//creation of the map
	Room CaveEntrance = new Room("Cave Entrance","It appears to be a large rock blocking the entrance to a cave. "
			+ "Right next to the entrance there is a picket sign with some writing on it", "the Cave's entrance");//the sign will have the welcome message and basic rules
	//set items in room(picket sign)
	CaveEntrance.addItem(PICKETSIGN);
	CaveEntrance.addItem(ROCK);//will be able to move but not taken, event handler once its moved, you can enter cavern
	
	map.addRoom(CaveEntrance.getName());//add to map
	
	Room InsideCave = new Room("Inside Cave","You're now inside the cave. It's quite dark but you can make"
	+"out a faint light coming from a portable lantern, a bag of dog treats and a half empty canteen","a dark, dank, cave room");
	//set items in room(lamp, dog treats, canteen)
	InsideCave.addItem(LANTERN);
	InsideCave.addItem(DOGTREAT);
	InsideCave.addItem(CANTEEN);
	
	map.addRoom(InsideCave.getName());//add to map
	
	Room MirrorRoom = new Room("Mirror Room","You just entered the Mirror Room. It looks like someone made this part of the cave into a living room."
			+"You see a hungry dog in the corner and a mirror hanging on the wall.You get this ominous feeling that someone is watching you through the mirror.",
			"looks like a room with a mirror in it");//make room and add descriptions
	//set the items in the room(dog, sword and mirror)
	MirrorRoom.addItem(DOG);//once fed the treats it will reveal the sword thta will be used to break the mirror
	MirrorRoom.addItem(SWORD);//will be used to break mirror
	MirrorRoom.addItem(MIRROR);//the item will be set as breakable an once broken the condition is met so the hidden path to the treasure room is open
	
	map.addRoom(MirrorRoom.getName());//adds room to map
	
	Room TreasureRoom = new Room("Treasure Room","You've made it to the treassure room! Congradulations! Grab all the treasure you can carry","Looks like a room filled with many treassures");
	
	
	
		Parser input = new Parser();
		String actionInput;
		
		boolean keepPlaying = true;
		
		while(keepPlaying)
		{	// Get input from user
			input.getLine();
			actionInput = input.getWord(0);
			
			// Check for direction input
			
		}
		
		
	} // end main()

	// ----------------------- Define movement
	public static String moveDir(Object item, String direction)
	{	String message = null;
		direction = direction.toLowerCase().trim();
		
		
		
		return message;		
	}
}
