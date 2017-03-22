Programming interface

The programming interface provides a flexible framework for programming a custom adventure game. It defines a map as an indexed list of rooms. It allows items to be defined as an item, container, or person (a special type of container). Rooms and containers contain a list of items they hold. The Definitions interface defines actions and items associated with the game and defines abstract methods for each action, forcing game programmers to implement these methods in each set of game rules.

Implementation 

The game implementation implements the abstract methods in the Definitions interface for a custom set of game rules. Each game simply extends a set of rules and provides a main method driver and uses the Parser class to interpret user input.
