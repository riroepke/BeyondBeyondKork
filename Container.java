package commands;

import java.util.ArrayList;

public class Container extends Item
{	// ----------------------------------- Data Fields
	private ArrayList<Item> items = new ArrayList<>();    // list of items in a container
	private int maxCapacity;     // maximum mass capacity
	
	// ----------------------------------- Constructors
	public Container(String itemName, Location location, int mass, int maxCapacity)
	{	super(itemName, location, mass);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, Location location, int mass, int maxCapacity, String description)
	{	super(itemName, location, mass, description);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, String altItemName, Location location, int mass, int maxCapacity)
	{	super(itemName, altItemName, location, mass);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, String altItemName, Location location, int mass, int maxCapacity, String description)
	{	super(itemName, altItemName, location, mass, description);
		this.maxCapacity = maxCapacity;
	}
	
	// ----------------------------------- Getters & Setters
	public boolean addItem(Item newItem)
	{	boolean itemAdded = false;
	
		if(super.mass + newItem.getMass() <= this.maxCapacity)
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
	{	return this.maxCapacity;
	}
	
	public void setMaxMass(int mass) throws NegativeMassException
	{	if(mass >= 0)
			this.maxCapacity = mass;
	else
		throw new NegativeMassException();		
	}
	
	public ArrayList<Item> getItems()
	{	return this.items;		
	}	
} // end Container
