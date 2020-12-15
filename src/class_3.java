import java.io.FileInputStream;
import java.util.LinkedList;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class class_3 extends Application{

	int n= 850, qu = 0;
	@Override
	public void start(Stage prime) throws Exception {
	
		Pane p = new Pane();
		LinkedList<String> link = new LinkedList();
	
		
		TextField valueField = new TextField();
		
		Button addHead = new Button("Add head");
		addHead.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (!valueField.getText().isEmpty()) {
				int j = 850;
				for (int i = 1 ; i < qu+1; i++) {
					j=j-100;
					TranslateTransition tt = new TranslateTransition();
					tt.setDuration(Duration.seconds(3));
					tt.setNode(p.getChildren().get(i));
					tt.setToX(j);
					tt.setToY(0);
					tt.play();
				}
				
				

				Text dummy = new Text();
				p.getChildren().add(dummy);
				Text dummy2 = new Text();
				for (int i = qu; i > 0; i--) {
							Node n = p.getChildren().get(i);
							p.getChildren().set(i,dummy2);
							p.getChildren().set(i+1, n);
							p.getChildren().set(i,dummy);
				}
				
				qu++;
				Rectangle rect = new Rectangle();
				rect.setHeight(50);
				rect.setWidth(70);
				rect.setFill(Color.web("#355C7D"));
				rect.getStyleClass().add("circle");
			
				Text t = new Text();
				t.setText(valueField.getText());
				t.setFill(Color.BEIGE);
				
				StackPane sp = new StackPane();
				sp.getChildren().addAll(rect,t);
				Rectangle rect2 = new Rectangle();
				rect2.setHeight(50);
				rect2.setWidth(25);
				rect2.setFill(Color.web("#2F4F4F"));
				
				
				HBox hb = new HBox();
				hb.getChildren().addAll(rect2,sp);
				hb.setLayoutX(50);
				hb.setLayoutY(250);
				
				TranslateTransition tt = new TranslateTransition();
				tt.setDuration(Duration.seconds(3));
				tt.setNode(hb);
				tt.setToX(850);
				tt.setToY(0);
				tt.play();
				p.getChildren().set(1, hb);
				n = n-100;
				link.addFirst(valueField.getText());
				}
			
			}});
		
		
		Button addNode = new Button("Add Tail");
		addNode.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (!valueField.getText().isEmpty()) {
				Rectangle rect = new Rectangle();
				rect.setHeight(50);
				rect.setWidth(70);
				rect.setFill(Color.web("#355C7D"));
				rect.getStyleClass().add("circle");
				
				
				Text t = new Text();
				t.setText(valueField.getText());
				t.setFill(Color.BEIGE);
				
				StackPane sp = new StackPane();
				sp.getChildren().addAll(rect,t);
				Rectangle rect2 = new Rectangle();
				rect2.setHeight(50);
				rect2.setWidth(25);
				rect2.setFill(Color.web("#2F4F4F"));
				
				HBox hb = new HBox();
				hb.getChildren().addAll(rect2,sp);
				hb.setLayoutX(50);
				hb.setLayoutY(250);
				
				TranslateTransition tt = new TranslateTransition();
				tt.setDuration(Duration.seconds(3));
				tt.setNode(hb);
				tt.setToX(n);
				tt.setToY(0);
				tt.play();
				p.getChildren().add(hb);
				n = n-100;
				qu++;
				link.addLast(valueField.getText());
				valueField.clear();
			
				
				}
			}
		});
	
		Button addAt = new Button("Add at Index");
		TextField indexField = new TextField();
		
		addAt.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (!valueField.getText().isEmpty() && !indexField.getText().isEmpty()) {
				int index = Integer.valueOf(indexField.getText());
				int j = 850-(100*(index-1));
				int k = j;
				for (int i = index ; i < qu+1; i++) {
					k=k-100;
					TranslateTransition tt = new TranslateTransition();
					tt.setDuration(Duration.seconds(3));
					tt.setNode(p.getChildren().get(i));
					tt.setToX(k);
					tt.setToY(0);
					tt.play();
				}
				
			

				Text dummy = new Text();
				p.getChildren().add(dummy);
				Text dummy2 = new Text();
				for (int i = qu; i > index-1; i--) {
							Node n = p.getChildren().get(i);
							p.getChildren().set(i,dummy2);
							p.getChildren().set(i+1, n);
							p.getChildren().set(i,dummy);
				}
				
				
				qu++;
				Rectangle rect = new Rectangle();
				rect.setHeight(50);
				rect.setWidth(70);
				rect.setFill(Color.web("#355C7D"));
				rect.getStyleClass().add("circle");
			
				Text t = new Text();
				t.setText(valueField.getText());
				t.setFill(Color.BEIGE);
				
				StackPane sp = new StackPane();
				sp.getChildren().addAll(rect,t);
				Rectangle rect2 = new Rectangle();
				rect2.setHeight(50);
				rect2.setWidth(25);
				rect2.setFill(Color.web("#2F4F4F"));
				
				HBox hb = new HBox();
				hb.getChildren().addAll(rect2,sp);
				hb.setLayoutX(50);
				hb.setLayoutY(250);
				
				TranslateTransition tt = new TranslateTransition();
				tt.setDuration(Duration.seconds(3));
				tt.setNode(hb);
				tt.setToX(j);
				tt.setToY(0);
				tt.play();
				p.getChildren().set(index, hb);
				n = n-100;
				link.add(index-1, valueField.getText());
				}
			
			}});
		Label lb2= new Label();
		Button removehead = new Button("Remove Head");
		Label removeHeadLb = new Label();
		removehead.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (qu >0) {
					qu--;
					p.getChildren().remove(1);
					n = n +100;
					removeHeadLb.setText(link.remove());
					lb2.setText("Removed: ");
					lb2.setFont(Font.font("Arial", FontWeight.BOLD, 18));
					removeHeadLb.setFont(Font.font("Arial", FontWeight.BOLD, 18));
					}
						int j = n;
						for (int i = qu ; i > 0; i--) {
							j=j+100;
							TranslateTransition tt = new TranslateTransition();
							tt.setDuration(Duration.seconds(3));
							tt.setNode(p.getChildren().get(i));
							tt.setToX(j);
							tt.setToY(0);
							tt.play();
							
						}
					}
			
		});
		
		
		Button removeAll = new Button("Remove All");
		removeAll.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (qu>0) {
					
					Node z = p.getChildren().get(0);
					p.getChildren().clear();
					p.getChildren().add(z);
					qu=0;
					n = 850;
					link.clear();
					}
						
					}
			
		});
		Button removeSelect= new Button("Remove Selected");
		//TextField rstf = new TextField();
		
		removeSelect.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				
				if (!indexField.getText().isEmpty()) {
				int index = Integer.valueOf(indexField.getText());
				if (index <= qu && index > 0) {
				if (qu >0) {
					qu--;
					p.getChildren().remove(index);
					n = n +100;
					removeHeadLb.setText(link.remove(index-1).toString());
					lb2.setText("Removed: ");
					lb2.setFont(Font.font("Arial", FontWeight.BOLD, 18));
					removeHeadLb.setFont(Font.font("Arial", FontWeight.BOLD, 18));
					}
						int j = n;
						for (int i = qu ; i > index-1; i--) {
							j=j+100;
							TranslateTransition tt = new TranslateTransition();
							tt.setDuration(Duration.seconds(3));
							tt.setNode(p.getChildren().get(i));
							tt.setToX(j);
							tt.setToY(0);
							tt.play();
						}
				}}}
		});
		
		
		
		Button back = new Button("Back");
		back.setOnAction(e-> {
			TitleScreen k = new TitleScreen();
			try {
				k.start(prime);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		//button linking to CSS "bt"
		addNode.getStyleClass().add("bt");
		removehead.getStyleClass().add("bt");
		removeAll.getStyleClass().add("bt");
		removeSelect.getStyleClass().add("bt");
		addHead.getStyleClass().add("bt");
		addAt.getStyleClass().add("bt");
		back.getStyleClass().add("bt");
		removeHeadLb.getStyleClass().add("bt");
		
		//Background and main pane link to design.CSS
		FileInputStream inp2= new FileInputStream("bg.jpg");
		Image backGround = new Image(inp2);
		BackgroundImage bImage= new BackgroundImage(backGround, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background backG= new Background(bImage);
		p.setBackground(backG);
		p.getStyleClass().add("root");
		p.getStylesheets().add("design.css");
		
		Label valueLb= new Label("Enter value for node: ");
		valueLb.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		valueLb.setTextFill(Color.BEIGE);
		Label indexLb= new Label("Enter index for node: ");
		indexLb.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
		indexLb.setTextFill(Color.BEIGE);
		
		//Positioning
		GridPane gp = new GridPane();
		gp.setMargin(addHead, new Insets(10,10,10,10));
		gp.setMargin(addAt, new Insets(10));
		gp.setMargin(addNode, new Insets(10));
		gp.setMargin(removeAll, new Insets(10));
		gp.setMargin(removeSelect, new Insets(10));
		gp.setMargin(removehead, new Insets(10));
		gp.add(valueLb, 0,0);
		gp.add(valueField, 1, 0);
		gp.add(indexLb, 0, 1);
		gp.add(indexField, 1, 1);
		gp.add(addHead, 2, 0);
		gp.add(addAt, 3, 0);
		gp.add(addNode, 4, 0);
		gp.add(removeAll, 2, 1);
		gp.add(removehead, 3, 1);
		gp.add(removeSelect, 4, 1);
		gp.add(back, 0, 3);
		gp.add(lb2, 0, 4);
		gp.add(removeHeadLb, 1, 4);
		
		//gp.add(removeSelect, 2, 1);
		
		//hb.getChildren().addAll(value,valueField,button,removeHeadLb,removehead,removeAll,removeSelect,addHead,indexField,addAt,back);
		
		p.getChildren().add(gp);
		Scene s = new Scene(p, 1000,600);
		prime.setTitle("Linked List");
		prime.setScene(s);
		prime.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
