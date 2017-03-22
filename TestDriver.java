package commands;

public class TestDriver
{	public static void main(String[] args)
	{	Map map = new Map("MAP");
		Container c = new Container("Box", 15, 0);
		Item bike = new Item("bike", 50);
		Item car = new Item("car", 5000);
		Room r = new Room("Garlic Room");
		
		Location l1 = new Location(map, c);
		Location l2 = new Location(map, r);
		
		try
		{	Person Self = new Person("self", 90, 0);
			System.out.println("bike added: " + Self.addItem(bike));
			System.out.println("car removed: " + Self.removeItem(car));
			System.out.println("bike removed: " + Self.removeItem(bike));
		} catch (Exception e)
		{	System.out.println(e);
			System.out.println("ow");
		}

		
	}

}