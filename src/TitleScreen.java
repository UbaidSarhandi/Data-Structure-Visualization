
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TitleScreen extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage prime) throws Exception {
		
		VBox pane= new VBox(20);
		
		Label ins= new Label("Select an option below for visualization: ");
		ins.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		Button queue= new Button("Queue");
	
		Button stack= new Button("Stack");
		
		Button quit= new Button("Quit");
		
		Button link= new Button("Linked List");		
		
		queue.getStyleClass().add("bt");
		stack.getStyleClass().add("bt");
		link.getStyleClass().add("bt");
		quit.getStyleClass().add("bt");
		
		quit.setPrefWidth(120);
		queue.setPrefWidth(120);
		stack.setPrefWidth(120);
	
		
		queue.setOnAction(e->{
			class_1 k = new class_1();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		});
		
		stack.setOnAction(e-> {
			class_2 k = new class_2();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
		link.setOnAction(e->{
			class_3 k = new class_3();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		});

		
		quit.setOnAction(e->{
			System.exit(0);
		});
		
		VBox paneH= new VBox(20); 
		paneH.setAlignment(Pos.CENTER);
		Label cred= new Label("Created by Hasnain Ali, Pir UbaidUllah Jan Sarhandi, Areeba Azam.");		
		cred.getStyleClass().add("cred");
		cred.setPadding(new Insets(20));
		pane.getChildren().add(cred);
		paneH.getChildren().addAll(ins,queue,stack,link,quit);
		
		VBox root= new VBox();
		FileInputStream inp2= new FileInputStream("bg.jpg");
		Image backGround = new Image(inp2);
		BackgroundImage bImage= new BackgroundImage(backGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background back= new Background(bImage);
		root.setBackground(back);
		
		
		
		VBox boxS= new VBox();
		boxS.getChildren().addAll(paneH);
		boxS.setVgrow(boxS, Priority.ALWAYS);
		boxS.setAlignment(Pos.CENTER);
		
		root.getStyleClass().add("root");
		root.getStylesheets().add("design.css");
		root.getChildren().addAll(boxS,pane);
		
		
		Scene scene= new Scene(root,500,500);
		prime.setTitle("D S A");
		prime.setScene(scene);
		prime.show();
	}

}