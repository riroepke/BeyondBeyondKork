/*	Authors:		Peter Bearden, Ruth Bearden
 *  Date:			3/4/17
 *  Project:		Adventure Game Creation Commands
 */

package commands;

import java.lang.Exception;

public class MazeGameException extends Exception
{	public MazeGameException(String message)
	{	super(message);
	}
} // end MazeGameExceptions

class InvalidLocationException extends Exception
{	public InvalidLocationException()
	{	super("Failed Location Initialization: Map does not contain Location");
	}
}

class ObjectDoesNotMatchProperty extends Exception
{	public ObjectDoesNotMatchProperty(Object o)
	{}
}

class InvalidRoomSetException extends Exception
{	public InvalidRoomSetException()
	{	super("Invalid Room Set");
		System.out.println(this);
	}
}

class InvalidRoomRemovalException extends Exception
{	public InvalidRoomRemovalException()
	{	super("Invalid Room Removal");
		System.out.println(this);
	}	
}

class InvalidDirectionException extends Exception
{	public InvalidDirectionException()
	{	super("Invalid Direction");
		System.out.println(this);
	
	}
	
}

class InvalidSetValueException extends Exception
{	public InvalidSetValueException()
	{	super("Cannot set this value");
	}	
}

class NegativeMassException extends Exception
{	public NegativeMassException()
	{
	}
}

class TooMuchMassException extends Exception
{	public TooMuchMassException()
	{
	}	
}