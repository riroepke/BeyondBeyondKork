package commands;

/*  Note: Person class defines all actions that can be done only by number one: the Self person
 * 
 */

public class Person extends Container
{	// --------------------------------------------------- Data Fields
	private int health;    // Range 0 - 100
	
	// ========================================================== Reusable Warning Messages for Player
		private final String DEADEND = "You can't go that way";
		private final String SARCASTIC_CHALLENGE = "How do you expect to accomplish that?";
	
	
	// --------------------------------------------------- Constructor
	public Person(String name, Location location, int maxMass, int mass)
	{	super(name, location, maxMass, mass);
		this.health = 100;
	}	

	// ----------------------------- Directional movement methods
		// Generic movement method
		public String travel(Room destination)
		{	String message = null;
			Location newLocation = new Location(destination);
			
			/* Check all possible reasons that would prevent person from moving to given room */
			// Check that destination is not null (null signifies dead end)
			if(destination != null)
			{	this.location = newLocation;  // Assumes person is in Room (not Container); checked by other methods
				message = newLocation.getInsideDescription();
			}
			else
				message = null; // null = DEADEND
			
			return message;
		}
		
		/*	Each of the subsequent methods will attempt to move a person in a particular direction.
		 *  (Only the first method (north) is documented
		 */
		
		// (Documentation only included in n() method)
		public String n() // --------------- Move person North
		{	String message = null;
		
			// Only attempt movement if location type is Room (not Container)
			if(this.location.isRoom())
			{	// Return description 
				message = travel(this.location.getRoom().getN());
				
				// Specify message for a dead end
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			
			return message;
		}
		
		public String ne()// --------------- Move person Northeast
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getNE());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String e()// --------------- Move person East
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getE());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String se()// --------------- Move person Southeast
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getSE());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String s()// --------------- Move person South
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getS());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String sw()// --------------- Move person Southwest
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getSW());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}

		public String w()// --------------- Move person West
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getW());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}

		public String nw()// --------------- Move person Northwest
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getNW());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String u()// --------------- Move person Up
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getU());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}

		public String d()// --------------- Move person Down
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getD());
				if(message == null)
					message = DEADEND;
			}
			else
				message = SARCASTIC_CHALLENGE;
			return message;
		}
		
	// ------------------------ Implementations of other actions unique to the Self person
		public String lookInDirecton(String direction)
		{	String message = null;
			Room currentRoom, roomInDirection;
		
			if(this.location.isRoom())
			{	currentRoom = this.location.getRoom();
				direction = direction.toLowerCase();
				if(direction.equals("n"))
					roomInDirection = currentRoom.getN();
				else if(direction.equals("ne"))
					roomInDirection = currentRoom.getNE();
				else if(direction.equals("e"))
					roomInDirection = currentRoom.getE();
				else if(direction.equals("se"))
					roomInDirection = currentRoom.getSE();
				else if(direction.equals("s"))
					roomInDirection = currentRoom.getS();
				else if(direction.equals("sw"))
					roomInDirection = currentRoom.getSW();
				else if(direction.equals("w"))
					roomInDirection = currentRoom.getW();
				else if(direction.equals("nw"))
					roomInDirection = currentRoom.getNW();
				else if(direction.equals("u"))
					roomInDirection = currentRoom.getU();
				else if(direction.equals("d"))
					roomInDirection = currentRoom.getD();
				else
					roomInDirection = null;			
				
				if(roomInDirection != null)
					message = "To the " + direction + "...\n" + roomInDirection.getOutsideDescription();
					
			}
			else
				message = "You are in " + this.location.getContainer().getNameWithArticle();
		
			return message;		
		}
		
		public String look()
		{	String message = null;		
			message = this.location.getInsideDescription() + this.location.getItemDescriptions();
					
			return message;		
		}
	
} // end class Person
