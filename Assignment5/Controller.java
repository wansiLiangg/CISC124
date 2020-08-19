package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ChoiceBox<String> sizeChoice = new ChoiceBox<>();

    @FXML
    private Label labelSize;

    @FXML
    private Label labelCheese;

    @FXML
    private Label labelGreenPepper;

    @FXML
    private Label labelPineapple;

    @FXML
    private Label labelHam;

    @FXML
    private ChoiceBox<String> pineappleChoice = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> cheeseChoice = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> greenPepperChoice = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> hamChoice = new ChoiceBox<>();

    @FXML
    private Label labelQuantity;

    @FXML
    private TextField textQuantity = new TextField();

    @FXML
    private Label labelCostPerItem;

    @FXML
    private Label labelCostTotal;

    @FXML
    private Button buttonOrder = new Button();

    @FXML
    private TextField textCostPerItem = new TextField();

    @FXML
    private TextField textCostTotal = new TextField();

    @FXML
    private TextArea textResult;

    //Options in choice boxes
    private ObservableList<String> sizeChoiceList = FXCollections.observableArrayList("small", "medium", "large"); 
    private ObservableList<String> cheeseChoiceList = FXCollections.observableArrayList("single", "double", "triple"); 
    private ObservableList<String> pineappleChoiceList = FXCollections.observableArrayList("none", "single"); 
    private ObservableList<String> greenPepperChoiceList = FXCollections.observableArrayList("none", "single"); 
    private ObservableList<String> hamChoiceList = FXCollections.observableArrayList("none", "single"); 

    @FXML
    void initialize() {
        sizeChoice.setItems(sizeChoiceList);
        sizeChoice.setValue("small");
        cheeseChoice.setItems(cheeseChoiceList);
        cheeseChoice.setValue("single");
        pineappleChoice.setItems(pineappleChoiceList);
        pineappleChoice.setValue("none");
        greenPepperChoice.setItems(greenPepperChoiceList);
        greenPepperChoice.setValue("none");
        hamChoice.setItems(hamChoiceList);
        hamChoice.setValue("single");
        
        //Counting the price for per item when changing each option
        sizeChoice.valueProperty().addListener((observableValue, oldInput, newInput) -> cost());
        cheeseChoice.valueProperty().addListener((observableValue, oldInput, newInput) -> cost());
        pineappleChoice.valueProperty().addListener((observableValue, oldInput, newInput) -> cost());
        greenPepperChoice.valueProperty().addListener((observableValue, oldInput, newInput) -> cost());
        
        //Checking if pineapple and greenPepper are "none" when ham is "none"
        hamChoice.valueProperty().addListener((observableValue, oldInput, newInput) -> {
        	String pineapple = pineappleChoice.getValue(); 
        	String greenPepper = greenPepperChoice.getValue(); 
        	if (newInput.equals("none") && (!pineapple.equals("none") || !greenPepper.equals("none"))) {
        		pineappleChoice.setValue("none");
        		greenPepperChoice.setValue("none");
        	}
        	cost(); 
        });
        
        //Checking if the input of quantity is valid
        textQuantity.textProperty().addListener((observableValue, oldInput, newInput) -> {
        	if (newInput.equals("")) {
        		textCostTotal.setText("");
        		return; 
        	}
        	int orderNum = 1; 
        	try {
        		orderNum = Integer.parseInt(newInput); 
        	}
        	catch (NumberFormatException numForatException) {
        		textQuantity.setText(oldInput);
        		return; 
        	}
        	if (orderNum<1 || orderNum>100) {
        		Alert errorInput = new Alert(AlertType.ERROR); 
        		errorInput.setContentText("You have to enter a number between 1 to 100.");
        		errorInput.show();
        		textQuantity.setText(oldInput);
        		return; 
        	}
        	quantity = orderNum; 
        	cost(); 
        }); 
        
        //Output after clicking on the order button
        buttonOrder.setOnAction(event -> {
        	if (textCostTotal.getText().equals(""))
        		return; 
        	float totalCost = 0; 
        	String output = ""; 
        	orders.add(lineItem); 
        	orders.sort(null); 
        	for (LineItem order : orders) {
        		totalCost = totalCost + order.getCost(); 
        		output = output + order + "\n"; 
        	}
        	output = output + "Total cost: " + String.format("$%.2f", totalCost);
        	textResult.setText(output); 
        });
        cost(); 
    }
    
    private Pizza currentPizza; 
    private LineItem lineItem;
    private int quantity = 1; 
    private ArrayList<LineItem> orders = new ArrayList<>(); 
    
    //Counting the price of each item and the price of the order
    private void cost() {
    	String size = sizeChoice.getValue(); 
    	String cheese = cheeseChoice.getValue(); 
    	String pineapple = pineappleChoice.getValue(); 
    	String greenPepper = greenPepperChoice.getValue(); 
    	String ham = hamChoice.getValue(); 
    	try {
    		currentPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
    	}
    	catch (IllegalPizza illegalPizza) {
    		System.err.println("Illegal Pizza!");
    		return; 
    	}
    	textCostPerItem.setText(String.format("$%.2f", currentPizza.getCost()));
    	try {
    		lineItem = new LineItem(quantity, currentPizza); 
    	}
    	catch (IllegalPizza illegalPizza) {
    		System.err.println("Illegal Pizza!");
    		return; 
    	}
    	textCostTotal.setText(String.format("$%.2f", lineItem.getCost()));
    }
}

