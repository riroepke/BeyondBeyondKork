package commands;

public class Game
{	public static void main(String[] args)
	{	Parser input = new Parser();
		String action;
		
		boolean keepPlaying = true;
		
		while(keepPlaying)
		{	// Get input from user
			input.getLine();
			action = input.getWord(0);
			
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
