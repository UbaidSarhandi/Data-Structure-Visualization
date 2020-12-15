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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.Stack;

import javafx.animation.*;


public class class_2 extends Application{
	int n = 875;
	int height = 0;
	@Override
	public void start(Stage prime) throws Exception {
		
		TextField addtf = new TextField();
		Stack<String> stack = new Stack<String>();
		Pane p = new Pane();
		
		Button back = new Button("Back");
		back.getStyleClass().add("bt");
		back.setOnAction(e-> {
			TitleScreen k = new TitleScreen();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		Button add = new Button("Add Stack");
		add.getStyleClass().add("st");
		add.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				if (!addtf.getText().isEmpty()) {
					
				
				Rectangle rect = new Rectangle();
				rect.setHeight(50);
				rect.setWidth(100);
				rect.setFill(Color.web("#355C7D"));
				rect.getStyleClass().add("circle");
				
				Text text = new Text(addtf.getText());
				text.setFill(Color.BEIGE);
				stack.add(addtf.getText());
				addtf.clear();
				StackPane sp = new StackPane(rect,text);
				sp.setLayoutX(250);
				sp.setLayoutY(50);
				TranslateTransition tt = new TranslateTransition();
				tt.setDuration(Duration.seconds(3));
				tt.setNode(sp);
				tt.setToX(0);
				tt.setToY(n);
				tt.play();
				p.getChildren().add(sp);
				height++;
				n = n-60;
			}}
		});
		
		Label peeklb = new Label();
		Label lb= new Label();
		Button Peek = new Button("Peek");
		
		Peek.getStyleClass().add("bt");
		Peek.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				peeklb.setText(stack.peek());
				lb.setText("Peeked Value: ");
				lb.setFont(Font.font("Arial", FontWeight.BOLD, 18));
				peeklb.setFont(Font.font("Arial", FontWeight.BOLD, 18));
				
				
			}
		});
		
		
		Label poplb = new Label();
		Label lb2= new Label();
		Button pop = new Button("Pop");
		pop.getStyleClass().add("bt");
		pop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
			if (height > 0) {
				p.getChildren().remove(height);
				poplb.setText(stack.pop());
				height--;	
				lb2.setText("Popped: ");
				lb2.setFont(Font.font("Arial", FontWeight.BOLD, 18));
				poplb.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			}
			
			if(n < 875) {
			n = n+60;	}
			}
		});
		VBox hb = new VBox(20);
		
		
		add.setPadding(new Insets(10,10,10,10));
		pop.setPadding(new Insets(10,10,10,10));
		Peek.setPadding(new Insets(10,10,10,10));
		
		hb.getChildren().addAll(addtf,add,Peek,pop,back,lb,peeklb,lb2,poplb);
		hb.setPadding(new Insets(20));
		FileInputStream inp2= new FileInputStream("bg.jpg");
		Image backGround = new Image(inp2);
		BackgroundImage bImage= new BackgroundImage(backGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background backG= new Background(bImage);
		p.setBackground(backG);
		
		p.getStyleClass().add("root");
		p.getStylesheets().add("design.css");
		
		p.getChildren().add(hb);
		Scene s = new Scene(p, 600,1000);
		prime.setTitle("Stack");
		prime.setScene(s);
		prime.show();
		

		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
