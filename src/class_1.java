import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

import javafx.animation.*;


public class class_1 extends Application{
	int n = 875;
	int qu=0;
	
	Queue<String> queue = new LinkedList();
	public void start(Stage prime) throws Exception {
		
		
		Pane p = new Pane();
	
		Button back = new Button("Back");
		back.setOnAction(e-> {
			TitleScreen k = new TitleScreen();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		Button enQ = new Button("Enqueue");
		TextField tBox = new TextField(); 
		enQ.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				if (!tBox.getText().isEmpty()) {
					
				
				Circle cirtwo = new Circle();
				cirtwo.setRadius(30);
				
				cirtwo.setFill(Color.web("#355C7D"));
				cirtwo.getStyleClass().add("circle");
				
				Text txt = new Text();
				txt.setText(tBox.getText());
				txt.setFill(Color.ALICEBLUE);
				StackPane sp = new StackPane();
				sp.getChildren().addAll(cirtwo,txt);
				sp.setLayoutX(50);
				sp.setLayoutY(250);
				TranslateTransition tt = new TranslateTransition();
				tt.setDuration(Duration.seconds(3));
				tt.setNode(sp);
				tt.setToX(n);
				tt.setToY(0);
				tt.play();
				qu++;
				p.getChildren().add(sp);
				n = n-75;
				queue.add(tBox.getText());
				tBox.clear();
				
				}
			}
		});
		
		Button remove = new Button("Dequeue");
		Label delb = new Label();
		Label left= new Label();
		remove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (qu >0) {
			qu--;
			p.getChildren().remove(1);
			n = n +75;
			left.setText("Dequeued: ");
			left.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			//left.setTextFill(Color.AZURE);
			delb.setText(queue.remove());
			
			}
				int j = n;
				for (int i = qu ; i > 0; i--) {
					j=j+75;
					TranslateTransition tt = new TranslateTransition();
					tt.setDuration(Duration.seconds(3));
					tt.setNode(p.getChildren().get(i));
					tt.setToX(j);
					tt.setToY(0);
					tt.play();
				
				}
			}
			
		
		});
		
		
		enQ.setPadding(new Insets(10,10,10,10));
		remove.setPadding(new Insets(10,10,10,10));
		back.setPadding(new Insets(10,10,10,10));
		delb.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		HBox hb = new HBox(20);
		
		hb.getChildren().addAll(tBox,enQ,remove,back,left,delb);
		hb.setPadding(new Insets(20));
		enQ.getStyleClass().add("enQ");
		remove.getStyleClass().add("enQ");
		back.getStyleClass().add("enQ");
				
		FileInputStream inp2= new FileInputStream("bg.jpg");
		Image backGround = new Image(inp2);
		BackgroundImage bImage= new BackgroundImage(backGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background backG= new Background(bImage);
		p.setBackground(backG);
		
		p.getStyleClass().add("root");
		p.getStylesheets().add("design.css");
		
		p.getChildren().add(hb);
		Scene s = new Scene(p, 1000,600);
		prime.setTitle("Queue");
		prime.setScene(s);
		prime.show();

	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
