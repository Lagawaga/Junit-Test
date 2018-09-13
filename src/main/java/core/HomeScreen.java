package core;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
  

public class HomeScreen extends Application{
	
	private Button solnBtn;
	private TextField leftOperandTxtBox;
	private TextField rightOperandTxtBox;
	private TextField answerTxtBox;
	private ComboBox<String> operatorDropdown;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}

	private void initUI(Stage primaryStage) {
		Pane canvas = new Pane();		
		//canvas.setStyle("-fx-background-color: black");
		
		addControls(canvas);
		
		Scene scene = new Scene(canvas, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator App");
		primaryStage.show();
		
	}

	private void addControls(Pane canvas) {
		
		int row = 20;
		int row2 = 60;
		
		Label label = new Label("Simple Calculator App");
		label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
		label.relocate(20, 20);
		
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.relocate(20,row2);
		leftOperandTxtBox.setMaxWidth(50);
		
		operatorDropdown = new ComboBox<>();
		operatorDropdown.getItems().addAll("+", "-", "x", "/", "%");
		operatorDropdown.relocate(80,row2);
		operatorDropdown.setValue("+");
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.relocate(150,row2);
		rightOperandTxtBox.setMaxWidth(50);
		
		solnBtn = new Button("=");
		solnBtn.setMaxWidth(50);
		solnBtn.relocate(210, row2);

		
		answerTxtBox = new TextField();
		answerTxtBox.setMaxWidth(50);
		answerTxtBox.relocate(250, row2);
		
		SetSolnBtnClickHandler();
		
		
		canvas.getChildren().addAll(label, leftOperandTxtBox, rightOperandTxtBox, operatorDropdown, solnBtn, answerTxtBox);
		
	}

	private void SetSolnBtnClickHandler() {
		solnBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				String operator = operatorDropdown.getValue();
				
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator,leftOperand, rightOperand));
				
				answerTxtBox.setText(answer);
			}
			
		});
		
	}
	
	
	
	

}
