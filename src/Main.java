/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Tan Shan Ke B210157B
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

public class Main extends Application{
    public void start(Stage primaryStage){
    Label lbAge = new Label("Age: ");
    Label lbMaritalStatus = new Label("Marital Status: ");
    Label lbDependentStatus = new Label("Dependent Status(0-2): ");
    Label lbCarOwnershipStatus = new Label("Car Ownership Status: ");
    Label lbMonthlyIncome = new Label("Monthly Income: ");
    
    TextField tfAge = new TextField();
    TextField tfDependentStatus = new TextField();
    TextField tfMonthlyIncome = new TextField();
    
    HBox hb1 = new HBox(10);
    RadioButton rdSingle = new RadioButton("Single");
    RadioButton rdMarried = new RadioButton("Married");
    rdSingle.setSelected(true);
    hb1.getChildren().addAll(rdSingle,rdMarried);
    hb1.setAlignment(Pos.CENTER);
    
    HBox hb2 = new HBox(10);
    RadioButton rdCarOwner = new RadioButton("Car Owner");
    RadioButton rdPublicTransportUser = new RadioButton("Public Transport User");
    rdCarOwner.setSelected(true);
    hb2.getChildren().addAll(rdCarOwner,rdPublicTransportUser);
    hb2.setAlignment(Pos.CENTER);
    
    ToggleGroup group1 = new ToggleGroup();
    rdSingle.setToggleGroup(group1);        
    rdMarried.setToggleGroup(group1);
    
    ToggleGroup group2 = new ToggleGroup();
    rdCarOwner.setToggleGroup(group2);        
    rdPublicTransportUser.setToggleGroup(group2);
    
    Button btCalculate = new Button("Calculate");
    Button btReset = new Button("Reset");
    Button btExit = new Button("Exit");
    
    HBox hb3 = new HBox(10);
    hb3.getChildren().addAll(btCalculate,btReset,btExit);
    hb3.setAlignment(Pos.CENTER);
    
    GridPane gp = new GridPane();
    gp.setAlignment(Pos.CENTER);
    gp.setHgap(5);
    gp.setVgap(5);
    
    gp.add(lbAge, 0, 0);
    gp.add(tfAge,1,0);
    gp.add(lbMaritalStatus,0,1);
    gp.add(hb1,1,1);
    gp.add(lbDependentStatus,0,2);
    gp.add(tfDependentStatus,1,2);
    gp.add(lbCarOwnershipStatus, 0, 3);
    gp.add(hb2, 1, 3);
    gp.add(lbMonthlyIncome, 0, 4);
    gp.add(tfMonthlyIncome, 1, 4);
    
    BorderPane p = new BorderPane();
    p.setTop(gp);
    p.setBottom(hb3);
    
    //Button Action
    btExit.setOnAction(e->{System.exit(0);});
    btReset.setOnAction(e->{
        tfAge.setText(null);
        rdSingle.setSelected(true);
        tfDependentStatus.setText(null);
        rdCarOwner.setSelected(true);
        tfMonthlyIncome.setText(null);
    });
    
    btCalculate.setOnAction(e->{
        if(tfAge.getText().equals("")){
            showError("Error","Please enter your age");
        }else if(tfDependentStatus.getText().equals("")){
            showError("Error","Please enter your dependent status");
        }else if(tfMonthlyIncome.getText().equals("")){
            showError("Error","Please enter your montly income");
        }
        
        int maritalStatus = 0;
        if(rdSingle.isSelected()){maritalStatus=1;}
        else if(rdMarried.isSelected()){maritalStatus=2;}
        int carOwnershipStatus = 0;
        if(rdCarOwner.isSelected()){carOwnershipStatus=1;}
        else if(rdPublicTransportUser.isSelected()){maritalStatus=2;}
        
        int age = Integer.parseInt(tfAge.getText());
        int dependentStatus = Integer.parseInt(tfDependentStatus.getText());
        double income = Double.parseDouble(tfMonthlyIncome.getText()); 
        
        

        if(age>= 100 || age <16){
        showError("Error","Please enter a valid age");
        }else if (dependentStatus >3 || dependentStatus <0){
            showError("Error","Please enter dependent between 0 to 2");
        }else if (income <= 0){
            showError("Error","Please enter a valid income");
        }else{
        User user = new User(age,maritalStatus,dependentStatus,carOwnershipStatus,income);


        double suggestedExpenses = user.getSuggestedExpenses();
        String str = "Suggested Expenses: " + Double.toString(suggestedExpenses);
        String output =  str + user.budgetAllocation() + "\n\n--Comparison of suggested budget allocation and suggested expenses--" + user.compare();
        JOptionPane.showMessageDialog(null,output,"Calculation result",JOptionPane.INFORMATION_MESSAGE);
        }
        
    });
    
    //---------KeyBoard Event----------//
    tfMonthlyIncome.setOnKeyPressed(e->{
            if((!(e.getCode().isDigitKey()) && !((e.getCode()== KeyCode.LEFT)) &&
                    !((e.getCode() == KeyCode.RIGHT)) && !((e.getCode() == KeyCode.BACK_SPACE))
                    && !((e.getCode() == KeyCode.ENTER)))){
                showError("Input Error", "Please enter a number!");
                tfMonthlyIncome.setText(null);
        }
    });
    tfAge.setOnKeyPressed(e->{
            if((!(e.getCode().isDigitKey()) && !((e.getCode()== KeyCode.LEFT)) &&
                    !((e.getCode() == KeyCode.RIGHT)) && !((e.getCode() == KeyCode.BACK_SPACE))
                    && !((e.getCode() == KeyCode.ENTER)))){
                showError("Input Error", "Please enter a number!");
                tfMonthlyIncome.setText(null);
        }
    });
    tfDependentStatus.setOnKeyPressed(e->{
            if((!(e.getCode().isDigitKey()) && !((e.getCode()== KeyCode.LEFT)) &&
                    !((e.getCode() == KeyCode.RIGHT)) && !((e.getCode() == KeyCode.BACK_SPACE))
                    && !((e.getCode() == KeyCode.ENTER)))){
                showError("Input Error", "Please enter a number!");
                tfMonthlyIncome.setText(null);
        }
    });
    
    Scene scene = new Scene(p,450,180); //width,height
    primaryStage.setTitle("Budget Calculator");
    primaryStage.setScene(scene); 
    primaryStage.show();
    
    }
    
    public void showError(String title, String msg){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(msg);
    alert.show();
    } 
        
    public static void main(String[] args){
        launch(args);
    }
    
    
}
