package commands;

import javafx.scene.control.TextField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.text.FontPosture;

// ----------------- Event Handling Classes
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class FxClassForThisGame extends Application {

	private Game game = new Game();

		//override the start method
		@Override
		public void start(Stage primaryStage) {
			
			
			//set finals of the height and width of the pane
			final int HEIGHT = 800;
			final int WIDTH = 800;
			
			//creates new border pane which will be used to add the textFields and others in the pane
			BorderPane pane = new BorderPane();
			
			//place the vbox in the borderpane from the private v boxes
			pane.setRight(getRightVBox());
			//set the left side of the BorderPane to text fields in the getLeftVBox()
			pane.setLeft(getLeftVBox());
			
			//create the vbox for the left side of the pane
			GridPane gpTop = new GridPane();
			
			//sets size of the scene(the pane you are describing,width, height
			Scene scene = new Scene(pane,WIDTH,HEIGHT);
			//sets the title of the stage(file)
			primaryStage.setTitle("Kork");
			primaryStage.setScene(scene);//place scene in the stage
			//displays the text on the pane
			primaryStage.show();
			
		} // end start()
			
		
				

			//method to  set the txtbox'x for the user input and the console 
			private VBox getLeftVBox()
			{
				VBox bhBox = new VBox(4);
				//create string in the consule with the welcome message
				String welcomeMessage = new String("Welcome to KORK");
				//create the textbox for the consule
				TextArea console = new TextArea();
				console.appendText(welcomeMessage);
				//set the min and max width and height for the consule textbox
				console.setPrefSize(600,500);
				//the consule will not be editable for the user
				console.setEditable(false);
				console.setWrapText(true);
				
				// ======================== Space for User Input
				//create text box for the user inputs
				TextArea userInput = new TextArea();
				//the userinput will be editable
				userInput.setEditable(true);
				//set the size of the text box
				userInput.setPrefSize(600,200);
				//let the text be editable
				userInput.setEditable(true);
				
				// Key Event handler for user input
				//userInput.setOnKeyPressed(
						
				//		(KeyEvent event)
				//{			
				//});
				
				userInput.setOnKeyPressed(e->
				{	if(e.getCode() == KeyCode.ENTER)
					{	String oldText = userInput.getText();   // Store most recent command
						String newText = getOutput(oldText);  // Get game's response to command
						
						console.appendText("\n\n" + oldText + "\n" + newText);
						userInput.clear();
					}
					
				});
				
				
				//add the text fields to the vbox lvbox
				//tHBox.getChildren().add(consule);
				bhBox.getChildren().add(console);
				bhBox.getChildren().add(userInput);

				//tHBox.getChildren().add(userInput);
				return bhBox;
			}
				
	
			private VBox getRightVBox()
			{
				VBox rvBox = new VBox(4);
				//set the padding 
				rvBox.setPadding(new Insets(4,2,2,2));
				//make a label to go over the map
				Label mapHeader = new Label("Map :");
				mapHeader.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				rvBox.getChildren().add(mapHeader);
				//assign the map onto the ImageView mapPic
				ImageView mapPic = new ImageView(new Image("file:Images/Mappic.png"));
				//change the dimensions of the image
				mapPic.setFitHeight(800/2);
				mapPic.setFitWidth(800/4);
				rvBox.getChildren().add(mapPic);
				//make a label to go over the items
				Label itemHeader = new Label("Item List :");
				itemHeader.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				rvBox.getChildren().add(itemHeader);
				//create a 
				Label [] itemList = {new Label ("Lantern"), new Label("Canteen"), new Label("Dog Treats"),
						new Label("Sword"), new Label ("Treasure")};

				//use for each loop to add all the items to rvbox
				for(Label itemlists : itemList )
				{
				rvBox.getChildren().add(itemlists);
				}
				return rvBox;
			}
		
			
		public String getOutput(String input)
		{	return game.run(input);
		}
			
		
			
		
		public static void main(String[] args)
		{
			//must have launch when using fx in eclipse
			Application.launch(args);
		}

}
