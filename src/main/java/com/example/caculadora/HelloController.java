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

    // Elementos para navegación principal
    @FXML private Button btnSumar;
    @FXML private Button btnRestar;
    @FXML private Button btnDividir;
    @FXML private Button btnMultiplicar;

    // Elementos para operaciones matemáticas
    @FXML private TextField txt1;
    @FXML private TextField txt2;
    @FXML private Label lblResultado;

    // Navegar a pantalla de suma
    @FXML
    private void irASumar(ActionEvent event) throws IOException {
        cambiarVentana("sumar.fxml", event);
    }

    // Navegar a pantalla de resta
    @FXML
    private void irARestar(ActionEvent event) throws IOException {
        cambiarVentana("restar.fxml", event);
    }

    // Navegar a pantalla de división
    @FXML
    private void irADividir(ActionEvent event) throws IOException {
        cambiarVentana("dividir.fxml", event);
    }

    // Navegar a pantalla de multiplicación
    @FXML
    private void irAMultiplicar(ActionEvent event) throws IOException {
        cambiarVentana("multiplicar.fxml", event);
    }

    // Método llamado desde botones de operación (en FXML) para calcular y mostrar el resultado
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

    // Función reutilizable para cambiar de escena
    private void cambiarVentana(String nombreFXML, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreFXML));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Calculadora - " + nombreFXML.replace(".fxml", ""));
        stage.show();
    }
}
