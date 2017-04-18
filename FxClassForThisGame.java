package Commands;

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
import javafx.scene.text.FontPosture;
import javafx.geometry.Pos;

public class FxClassForThisGame extends Application {

	

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
			primaryStage.setTitle("Beyond Beyond Kork");
			primaryStage.setScene(scene);//place scene in the stage
			//displays the text on the pane
			primaryStage.show();
			
			}
			
		
				

			//method to  set the txtbox'x for the user input and the console 
			private VBox getLeftVBox()
			{
				VBox bhBox = new VBox(4);
				//create string in the consule with the welcome message
				String welcomeMessage = new String("Welcome to KORK");
				//create the textbox for the consule
				TextField consule = new TextField();
				consule.appendText(welcomeMessage);
				//set the min and max width and height for the consule textbox
				consule.setPrefSize(600,400);
				//the consule will not be editable for the user
				consule.setEditable(false);
				//make the possition to the top left
				consule.setAlignment(Pos.TOP_LEFT);
				
				//create text box for the user inputs
				TextField userInput = new TextField();
				//the userinput will be editable
				userInput.setEditable(true);
				//set the size of the textbox
				userInput.setPrefSize(200,200);
				//let the text be editable
				userInput.setEditable(true);
				//SET THE POSITION to be top left
				userInput.setAlignment(Pos.TOP_LEFT);
				
				//add the text fields to the vbox lvbox
				//tHBox.getChildren().add(consule);
				bhBox.getChildren().add(consule);
				bhBox.getChildren().add(userInput);
				
				//add a set on the action for when the user preses enter in the userInput textField
				userInput.setOnAction(e->
				{
					
					//save the lines that are already in the consule
					String con = consule.getText();
					//saves the userInput gy getting the text
					String input = userInput.getText();
					consule.setText(con + "\r\n" + input);
					
				});
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
				mapPic.setFitWidth(800/2);
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
		
			
		
			
		
		public static void main(String[] args)
		{
			//must have launch when using fx in eclipse
			Application.launch(args);
		}

	}
