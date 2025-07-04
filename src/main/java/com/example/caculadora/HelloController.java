package com.example.caculadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController{
    @FXML
    private Button btnSumar;
    @FXML
    private Button btnRestar;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnMultiplicar;

    @FXML private Label lblResultado;
    @FXML private Button btnDividir;
    @FXML private TextField txt1;
    @FXML private TextField txt2;

    @FXML
    protected void sumar(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("sumar.fxml"));
        Parent root= loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Cambioventada");
        stage.show();

    }

    @FXML
    protected void restar(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("restar.fxml"));
        Parent root= loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Cambioventada");
        stage.show();

    }

    @FXML
    protected void dividir(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("dividir.fxml"));
        Parent root= loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Cambioventada");
        stage.show();

    }

    @FXML
    protected void multiplicar(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("multiplicar.fxml"));
        Parent root= loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Cambioventada");
        stage.show();

    }
}




protected void division() {
    btnDividir.setOnAction(e -> {
        double num1 = Double.parseDouble(txt1.getText());
        double num2 = Double.parseDouble(txt2.getText());
        if (num1 == 0) {
            lblResultado.setText("No puedes dividir cero");
        }else if (num2 == 0) {
            lblResultado.setText("No puedes dividir cero");
        }else {
            double resultado = num1 / num2;
            lblResultado.setText("El resultado es: " + resultado);
        }
    });
}
