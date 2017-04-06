package Commands;
//class that will have all the items in the game with their properties
//location will be decided in the game class

public class ItemList {
	

	 static Item picketSign = new Item("Picket Sign","Sign",null,0,"Welcome to the mysterious caverns of Kork."
+"Beyond this heavy rock is a maze filled with unnimaginable treasures and formidible fows.");
	//add actions(can be read, cant be taken,can look)
	
	static Item rock = new Item("Rock", "Big rock",null,20,"the rock looks pretty heavy, but you think you can move it");
	//add actions(can be moved,cant be taken, can look)
	
	static Item lantern = new Item("Lantern","Lamp",null,5,"battery powered, portable lantern. Can be used to ligth dark rooms");
	//add actions(can light, can be taken, can look)
	
	static Item canteen = new Item("Canteen","Bottle",null,2,"canteen that is half filled with water.Could be usefull later.");
	//add actions(can drink,can be taken, can look)
	
	static Item dogTreat = new Item("Dog treat","treat",null,1,"small bag of dog treats");
	//add actions(can be taken, can eat, can look)
	
	static Item dog = new Item("Dog","puppy",null,30,"hungry looking dog. It seems like it is gaurding something");
	//add actions(can be fed, cant be taken, can look)
	
	static Item sword = new Item("Sword","magic sword",null,10,"an ancient looking sword. Looks like you could do a bunch of damage with this item.Possibly break a couple things as well.");
	//add actions(can swing, can look)
	
	static Item mirror = new Item("Mirror","2-way mirror",null,10,"something abouot this mirror is a little off. It seems like someone can see  through the other side."
			+"You also feel a slight draft coming from the wall its hanging on");
	//add actions(can break, can look

}
