package commands;

import javafx.scene.control.TextField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextArea;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.io.File;

// ----------------- Background and Styling Classes
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;


// ----------------- Event Handling Classes
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import java.awt.Desktop;


public class GUI extends Application {

	//set finals of the height and width of the pane
	private final int HEIGHT = 600;
	private final int WIDTH = 800;
	
	private Game game = new Game();
	
	private Stage primaryStage = null;  // used to make primaryStage a global variable
	                                    // so that it can be opened/closed from anywhere
	
	private Background background = new Background(new BackgroundFill(Color.rgb(100, 50, 20), CornerRadii.EMPTY, Insets.EMPTY));
	
	private TextArea console = null;    // console is a global variable and can be added to by any method in this class	
	private VBox leftVBox = null, rightVBox = null;
	private ImageView mapPic;
	
		//override the start method
		@Override
		public void start(Stage primaryStage) {
			this.primaryStage = primaryStage; // gives primaryStage a global scope
			
			HBox container = new HBox();
			
			leftVBox = getLeftVBox();
			rightVBox = getRightVBox();
			container.getChildren().addAll(leftVBox, rightVBox);
			
			//sets size of the scene(the pane you are describing,width, height
			Scene scene = new Scene(container,WIDTH,HEIGHT);
			//sets the title of the stage(file)
			primaryStage.setTitle("KORK");
			primaryStage.setScene(scene);//place scene in the stage
			//displays the text on the pane
			primaryStage.show();
			
		} // end start()
			
		
				

			//method to  set the txtbox'x for the user input and the console 
			private VBox getLeftVBox()
			{	VBox bhBox = new VBox(4);
				
				//create the textbox for the consule
				console = new TextArea();
				console.appendText(game.getWelcomeMessage());
				
				//set the min and max width and height for the console textbox
				console.setPrefSize(WIDTH*3/4,HEIGHT*5/7);
				
				//the console will not be editable for the user
				console.setEditable(false);
				console.setWrapText(true);
				
				// ======================== Space for User Input
				
				// VBox to container userInput TextArea and Commands label
				VBox userInputField = new VBox();
				
				//create text box for the user inputs
				TextArea userInput = new TextArea();				
				//the user input will be editable
				userInput.setEditable(true);
				//set the size of the text box
				userInput.setPrefSize(WIDTH/4,HEIGHT/5);
				//let the text be editable
				userInput.setEditable(true);
				
				// Label for the user input field
				Label userInputHeader = new Label("Commands");
				userInputHeader.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				userInputHeader.setTextFill(Color.rgb(0,  0,  0));
				
				userInput.setOnKeyPressed(e->
				{	if(e.getCode() == KeyCode.ENTER)
					{	String oldText = userInput.getText();   // Store most recent command
						String newText = getOutput(oldText);  // Get game's response to command
						
						console.appendText("\n\n" + oldText + "\n" + newText);
						
						// ---------------------------------------------------------- Change map image
						try
						{	this.mapPic = new ImageView(game.getRoomMarker());
							mapPic.setFitHeight(HEIGHT*.83);
							mapPic.setFitWidth(WIDTH/2);
							this.rightVBox.getChildren().set(1, this.mapPic);
						} catch (Exception ex)
						{	System.out.println("Image not found");
							
						}
						
						userInput.clear();
						
						if(game.getGameStatus() == Definitions.GAME_WON)
							playAgain(Definitions.VICTORY_MESSAGE).show();
						else if(game.getGameStatus() == Definitions.PLAYER_DIED)
							playAgain(Definitions.DEATH_MESSAGE).show();
					}
					
				});
				
				// construct userInputField from the text entry box and its label
				userInputField.getChildren().addAll(userInputHeader, userInput);
				
				//add the text fields to the vbox lvbox
				bhBox.getChildren().addAll(console, userInputField);
				bhBox.setBackground(this.background);
				bhBox.setPadding(new Insets(5, 5, 5, 5));
				bhBox.setSpacing(20);
				
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
				mapHeader.setTextFill(Color.rgb(0,  0,  0));
				rvBox.getChildren().add(mapHeader);
				
				// Help button
				GridPane buttonPane = new GridPane();
				Button helpButton = new Button("Help");
				
				helpButton.setOnAction(e->
				{	File helpPDF = new File(System.getProperty("user.dir") + "/help/overview.pdf");				
					try
					{	Desktop.getDesktop().open(helpPDF);
						
					} catch (Exception ex)
					{	System.out.println("couldn't open file");
						
					}
				});
				
				
				buttonPane.setAlignment(Pos.BOTTOM_RIGHT);
				buttonPane.setPadding(new Insets(10, 10, 10, 10));
				
				helpButton.setPrefWidth(80);
				
				// add help button to a border pane
				buttonPane.add(helpButton, 3, 3);
				buttonPane.setPrefHeight(HEIGHT/2);
				
				//assign the map onto the ImageView mapPic
				Image map = game.getRoomMarker();
				ImageView mapPic = new ImageView();
				
				try   // Catch image opening errors and proceed regardless of result
				{ 	mapPic.setImage(map);
					//change the dimensions of the image
					mapPic.setFitHeight(HEIGHT*.83);
					mapPic.setFitWidth(WIDTH/2);
				
				} catch (NullPointerException e)
				{	System.out.println("Failed to open image file");
				} catch (Exception e)
				{	
				}
				
				rvBox.getChildren().addAll(mapPic, buttonPane);
				
				rvBox.setBackground(this.background);
				
				return rvBox;
			}
		
		// ============================================= Message box asking player whether or not to play again
		public Stage playAgain(String statusMessage)
		{	// ----------------------------- Declare parts of the message box
			Stage messageBox = new Stage();
			VBox container = new VBox();
			HBox buttons = new HBox();
			Label message = new Label(statusMessage);
			Label prompt = new Label("Do you want to play again?");
			Button yes = new Button("Yes"), no = new Button("No");
			
			// ----------------------------- Set button actions
			// Yes button
				yes.setOnAction(e->
				{	game = new Game();  // start a new game		
					messageBox.close();
					console.appendText("\n\n-------------------------------\n"
					                  + game.run("look"));   // get initial message
				});
			// No button
				no.setOnAction(e->
				{	this.primaryStage.close();
					messageBox.close();
				});
				
			// --------------------------- Set Alignments
			container.setPadding(new Insets(10, 10, 10, 10));
			container.setSpacing(20);
			yes.setPrefWidth(80);
			no.setPrefWidth(80);
			buttons.setSpacing(90);
				
				
			// ---------------------------- Add parts to the message box and show message box
			buttons.getChildren().addAll(yes, no);
			container.getChildren().addAll(message, prompt, buttons);
			messageBox.setScene(new Scene(container, 250, 120));
			messageBox.show();
			
		
			return messageBox;
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