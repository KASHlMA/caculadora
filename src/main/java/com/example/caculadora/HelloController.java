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

    @FXML private Button btnSumar;
    @FXML private Button btnRestar;
    @FXML private Button btnDividir;
    @FXML private Button btnMultiplicar;

    @FXML private TextField txt1;
    @FXML private TextField txt2;
    @FXML private Label lblResultado;

    @FXML
    private void irASumar(ActionEvent event) throws IOException {
        cambiarVentana("sumar.fxml", event);
    }

    @FXML
    private void irARestar(ActionEvent event) throws IOException {
        cambiarVentana("restar.fxml", event);
    }

    @FXML
    private void irADividir(ActionEvent event) throws IOException {
        cambiarVentana("dividir.fxml", event);
    }

    @FXML
    private void irAMultiplicar(ActionEvent event) throws IOException {
        cambiarVentana("multiplicar.fxml", event);
    }

    @FXML
    private void realizarOperacion(ActionEvent event) {
        try {
            double num1 = Double.parseDouble(txt1.getText());
            double num2 = Double.parseDouble(txt2.getText());

            String operacion = ((Button) event.getSource()).getText().toLowerCase();
            double resultado = 0;

            switch (operacion) {
                case "sumar":
                    resultado = num1 + num2;
                    break;
                case "restar":
                    resultado = num1 - num2;
                    break;
                case "multiplicar":
                    resultado = num1 * num2;
                    break;
                case "dividir":
                    if (num2 == 0) {
                        lblResultado.setText("Error: División por cero");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    lblResultado.setText("Operación desconocida");
                    return;
            }

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            lblResultado.setText("Ingresa números válidos");
        }
    }

    private void cambiarVentana(String nombreFXML, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Calculadora - " + nombreFXML.replace(".fxml", ""));
        stage.show();
    }
}
