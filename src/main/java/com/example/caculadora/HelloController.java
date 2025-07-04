
package com.example.caculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnSumar;
    @FXML
    private Button btnRestar;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnMultiplicar;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private Label lblResultado;

    @FXML
    protected void sumar(ActionEvent event) throws IOException {
        loadFXML("sumar.fxml", event);
    }

    @FXML
    protected void restar(ActionmdEvent event) throws IOException {
        loadFXML("restar.fxml", event);
    }

    @FXML
    protected void dividir(ActionEvent event) throws IOException {
        loadFXML("dividir.fxml", event);
    }

    @FXML
    protected void multiplicar(ActionEvent event) throws IOException {
        loadFXML("multiplicar.fxml", event);
    }

    @FXML
    protected void onHelloButtonClick() {
        double num1 = Double.parseDouble(txt1.getText());
        double num2 = Double.parseDouble(txt2.getText());
        if (num1 == 0 || num2 == 0) {
            lblResultado.setText("No se aceptan ceros");
        } else {
            double resultado = num1 + num2;
            lblResultado.setText("El resultado es: " + resultado);
        }
    }

    private void loadFXML(String fxml, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Ventana de operación");
        stage.show();
    }
}
