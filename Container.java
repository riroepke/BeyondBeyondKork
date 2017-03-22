package commands;

import java.util.ArrayList;

public class Container extends Item
{	// ----------------------------------- Data Fields
	private ArrayList<Item> items = new ArrayList<>();    // list of items in a container
	private int maxMass;     // maximum mass capacity
	
	// ----------------------------------- Constructors
	public Container(String itemName, Location location, int maxMass, int mass)
	{	super(itemName, location, mass);
		this.maxMass = maxMass;
	}
	
	public Container(String itemName, Location location, int maxMass, int mass, String description)
	{	super(itemName, location, mass, description);
		this.maxMass = maxMass;
	}
	
	// ----------------------------------- Getters & Setters
	public boolean addItem(Item newItem)
	{	boolean itemAdded = false;
	
		if(super.mass + newItem.getMass() <= this.maxMass)
		{	super.mass += newItem.getMass();
			this.items.add(newItem);
			itemAdded = true;
		}
		
		return itemAdded;
	}
	
	public boolean removeItem(Item item)
	{	boolean itemRemoved = false;
	
		if(this.items.contains(item))
		{	super.mass -= item.getMass();
			this.items.remove(item);
			itemRemoved = true;
		}
		return itemRemoved;
	}
	
	public int getMaxMass()
	{	return this.maxMass;
	}
	
	public void setMaxMass(int mass) throws NegativeMassException
	{	if(mass >= 0)
			this.maxMass = mass;
	else
		throw new NegativeMassException();		
	}
	
	public ArrayList<Item> getItems()
	{	return this.items;		
	}
	
	// Override current location getter method
	@Override
	public Location getLocation()
	{	return this.location;
	}
}
