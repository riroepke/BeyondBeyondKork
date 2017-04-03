package commands;

import java.util.ArrayList;

public class Container extends Item
{	// ----------------------------------- Data Fields
	protected ArrayList<Item> items = new ArrayList<>();    // list of items in a container
	protected int maxCapacity;     // maximum mass capacity
	protected String insideDescription;
	
	// ----------------------------------- Constructors
	public Container(String itemName, Location location, int mass, int maxCapacity)
	{	super(itemName, location, mass);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, Location location, int mass, int maxCapacity, String outsideDescription, String insideDescription)
	{	super(itemName, location, mass, outsideDescription);
		this.maxCapacity = maxCapacity;
		this.insideDescription = insideDescription;
	}
	
	public Container(String itemName, String altItemName, Location location, int mass, int maxCapacity)
	{	super(itemName, altItemName, location, mass);
		this.maxCapacity = maxCapacity;
	}
	
	public Container(String itemName, String altItemName, Location location, int mass, int maxCapacity, String outsideDescription, String insideDescription)
	{	super(itemName, altItemName, location, mass, outsideDescription);
		this.maxCapacity = maxCapacity;
		this.insideDescription = insideDescription;
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
	
	public String getInsideDescription()
	{	return this.insideDescription;
	}
	
	public String getItemDescriptions()
	{	String listAsString = null;
		String beingVerb = " is";
		
		for(int i = 0; i < items.size(); i++)
		{	// Check whether item is singular or plural
			if(items.get(i).isPlural())
				beingVerb = " are";
			listAsString += items.get(i).getNameWithArticle() + beingVerb + " here\n";
		}
		
		return listAsString;
	}
} // end Container
