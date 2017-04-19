package commands;

/*  Note: Person class defines all actions that can be done only by number one: the Self person
 * 
 */

public class Person extends Container
{	// --------------------------------------------------- Data Fields
	private int health;    // Range 0 - 100
	private int points = 0;
	
	
	
	// --------------------------------------------------- Constructor
	public Person(String name, Location location, int mass, int maxCapacity)
	{	super(name, location, mass, maxCapacity);
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
			message = look(newLocation);
		}
		else
			message = null; // null indicates dead end
		
		return message;
	}
		
	// ------------------------- Get & Set Health and Points
	public void setHealth(int health)
	{	if(health >= 0)
			this.health = health;		
	}
	
	public int getHealth()
	{	return this.health;
	}
	
	public void setPoints(int points)
	{	if(points >= 0)
			this.points = points;
	}
	
	public int getPoints()
	{	return this.points;
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
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			
			return message;
		}
		
		public String ne()// --------------- Move person Northeast
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getNE());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String e()// --------------- Move person East
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getE());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String se()// --------------- Move person Southeast
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getSE());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String s()// --------------- Move person South
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getS());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String sw()// --------------- Move person Southwest
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getSW());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}

		public String w()// --------------- Move person West
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getW());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}

		public String nw()// --------------- Move person Northwest
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getNW());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}
		
		public String u()// --------------- Move person Up
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getU());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}

		public String d()// --------------- Move person Down
		{	String message = null;
			if(this.location.isRoom())
			{	message = travel(this.location.getRoom().getD());
				if(message == null)
					message = Definitions.DEADEND;
			}
			else
				message = Definitions.SARCASTIC_CHALLENGE;
			return message;
		}
		
	// ------------------------ Implementations of other actions unique to the Self person
		public String lookInDirecton(String direction)
		{	String message = null;

		    // Make sure that location is of type Room
			if(this.getLocation().isRoom())
			{	Room currentRoom = this.getLocation().getRoom();
				
				try    // Try to print the room description for room in given direction
				{	if(direction.equals("n"))
						message = currentRoom.getN().getOutsideDescription();
					else if(direction.equals("ne"))
						message = currentRoom.getNE().getOutsideDescription();
					else if(direction.equals("e"))
						message = currentRoom.getE().getOutsideDescription();
					else if(direction.equals("se"))
						message = currentRoom.getSE().getOutsideDescription();
					else if(direction.equals("s"))
						message = currentRoom.getS().getOutsideDescription();
					else if(direction.equals("SW"))
						message = currentRoom.getSW().getOutsideDescription();
					else if(direction.equals("W"))
						message = currentRoom.getW().getOutsideDescription();
					else if(direction.equals("nw"))
						message = currentRoom.getNW().getOutsideDescription();
					else if(direction.equals("U"))
						message = currentRoom.getU().getOutsideDescription();
					else if(direction.equals("D"))
						message = currentRoom.getD().getOutsideDescription();
					else  // error: The "direction" specified is not a direction
						message = Definitions.UNKOWN_PHRASE;
				} catch(NullPointerException e)  // Room in direction is a dead end. Nothing there.
				{	message = Definitions.NOTHING_IN_DIRECTION;					
				}
			}
			else // If location is a container, self can see nothing outside the container
				message = "You are in " + this.getLocation().getContainer().getNameWithArticle();
						
			return message;		
		} // end lookInDirection()
		
		// =================================== Look in current room or in room specified
		public String look()
		{	return look(this.location);	
		}
		
		public String look(Location location)
		{	return "\n" + location.getName() + "\n"
						+ location.getInsideDescription()
	                    + location.getItemDescriptions()	
						+ location.getBearings();
		}
		
		// =============================================================================================== Take an object
		public String take(String itemName)
		{	String message = null;
			Item item = this.location.findItem(itemName); // null if item not found
			Location prevItemLocation;
			
			if(item != null && item.hasAction("take"))   // make sure that room (or open container in room) contains item
			{	prevItemLocation = item.getLocation();   // story previous item location
				
				if(this.addItem(item))                   // add item to person's items list (false if item exceeds remaining weight limit)
				{	prevItemLocation.removeItem(item);   // remove item from previous location
					message = Definitions.TAKEN;         // notify the player that item has been taken
				}
				else
					message = Definitions.LOAD_TOO_HEAVY;// notify player that item causes weight limit on person to be exceeded
				
			}
			else if(item != null && !item.hasAction("take"))// --------------------- case 1: item found but not take-able
				message = Definitions.CANNOT_TAKE_ITEM; // warn player that the item couldn't be taken
			else // ---------------------------------------------------------------- case 2: item can't be found
				message = Definitions.ITEM_NOT_FOUND;
				
			return message;
		} // end take()
		
		// =============================================================================================== Drop an object
		public String drop(String itemName)
		{	String message = null;
			Item item = this.getItemFromContainer(itemName);
			
			if(item != null && item.hasAction("take")) // if an item can be taken, it can be dropped
			{	this.getLocation().addItem(item);
				this.removeItem(item);
				message = Definitions.DROPPED;
			}
			else
				message = Definitions.ITEM_NOT_FOUND;
		
			return message;			
		} // end drop()
		
		// Take inventory: list the items the person is carrying
		public String inventory()
		{	String message = null;
		
			if(this.items.size() > 0)
			{	message = "You are carrying:";
				for(int i = 0; i < this.items.size(); i++)
					message += "\n   " + this.items.get(i).getNameWithArticle();
			}
			else
				message = "You are not carrying anything";
			
			return message;
		}
		
		
	
} // end class Person
