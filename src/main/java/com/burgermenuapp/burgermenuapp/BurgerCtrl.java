package com.burgermenuapp.burgermenuapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BurgerCtrl implements Initializable {
    //Esqueleto basico de la aplicación
    @FXML
    private ToggleGroup BurgerGroup;

    @FXML
    private ToggleGroup DrinkGroup;

    @FXML
    private ToggleGroup PanGroup;

    @FXML
    private ToggleGroup PatataGroup;

    @FXML
    private ToggleGroup RepartoGroup;

    @FXML
    private Button btCalcular;

    @FXML
    private CheckBox chbDoble;

    @FXML
    private CheckBox chbPatatas;

    @FXML
    private CheckBox chbQueso;

    @FXML
    private ChoiceBox<String> chxBarbacoa;
    //Para generar los datos a introducir en el ChoiceBox, generamos un array
    private String[] cantidad = {"0","1","2","3"};

    @FXML
    private ChoiceBox<String> chxKetchup;

    @FXML
    private ChoiceBox<String> chxMostaza;

    @FXML
    private RadioButton rnbAgua;

    @FXML
    private RadioButton rnbCaseras;

    @FXML
    private RadioButton rnbCenteno;

    @FXML
    private RadioButton rnbCerdo;

    @FXML
    private RadioButton rnbCerveza;

    @FXML
    private RadioButton rnbCola;

    @FXML
    private RadioButton rnbDomicilio;

    @FXML
    private RadioButton rnbFritas;

    @FXML
    private RadioButton rnbGajo;

    @FXML
    private RadioButton rnbIntegral;

    @FXML
    private RadioButton rnbLimon;

    @FXML
    private RadioButton rnbLocal;

    @FXML
    private RadioButton rnbNaranja;

    @FXML
    private RadioButton rnbNormal;

    @FXML
    private RadioButton rnbPollo;

    @FXML
    private RadioButton rnbTernera;

    @FXML
    private RadioButton rnbVegana;

    @FXML
    private TextField txtIVA;

    @FXML
    private TextField txtPVP;

    @FXML
    private TextField txtPrecio;
    //Aqui empiezan los metodos especificos
    @FXML
    void OnClickCalcular(ActionEvent event) {
        double precio = 8;
        double precioIVA = 0;
        double precioPVP = 0;
        //Pop up de información
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tus elecciones");
        alert.setContentText("Hamburguesa: " + ((RadioButton)BurgerGroup.getSelectedToggle()).getText()
        + "\nPan: " + ((RadioButton)PanGroup.getSelectedToggle()).getText()
        + "\nPatatas: " + ((RadioButton)PatataGroup.getSelectedToggle()).getText()
        + "\nBebida: " + ((RadioButton)DrinkGroup.getSelectedToggle()).getText()
        + "\nSalsas: " + chxKetchup.getValue());
        alert.showAndWait();

        //Calculo de precio de hamburguesa
        if(rnbPollo.isSelected()){
            precio = precio;
        } else if (rnbCerdo.isSelected()) {
            precio = precio;
        } else if (rnbTernera.isSelected()) {
            precio += 1;
        } else if (rnbVegana.isSelected()) {
            precio += 1;
        }

        //Calculo de precio de patatas
        if (rnbFritas.isSelected()){
            precio = precio;
        } else if (rnbGajo.isSelected()) {
            precio = precio;
        } else if (rnbCaseras.isSelected()) {
            precio += 1;
        }

        //Calculo de precio de extras
        if(chbDoble.isSelected()){
            precio += 2;
        }
        if (chbQueso.isSelected()){
            precio += 0.5;
        }
        if (chbPatatas.isSelected()){
            precio += 1;
        }

        //Calculo de precio de salsas
        String ketchup;
        String mostaza;
        String bbq;

        ketchup = chxKetchup.getValue();
        mostaza = chxMostaza.getValue();
        bbq = chxBarbacoa.getValue();

        if (ketchup.equals("0")){
            precio = precio;
        } else if (ketchup.equals("1")) {
            precio += 0.5;
        } else if (ketchup.equals("2")) {
            precio += 1;
        } else if (ketchup.equals("3")){
            precio += 1.5;
        }

        if (mostaza.equals("0")){
            precio = precio;
        } else if (mostaza.equals("1")) {
            precio += 0.5;
        } else if (mostaza.equals("2")) {
            precio += 1;
        } else if (mostaza.equals("3")){
            precio += 1.5;
        }

        if (bbq.equals("0")){
            precio = precio;
        } else if (bbq.equals("1")) {
            precio += 0.5;
        } else if (bbq.equals("2")) {
            precio += 1;
        } else if (bbq.equals("3")){
            precio += 1.5;
        }

        //Calculo de precio de envio
        if (rnbDomicilio.isSelected()){
            precio = precio;
        }else if (rnbLocal.isSelected()){
            precio = precio-(precio*0.20);
        }

        //Calculo de impuestos
        precioIVA = precio*0.21;
        precioPVP = precio + precioIVA;
        //Pasamos los datos por los txt
        txtPrecio.setText("" + precio);
        txtIVA.setText("" + precioIVA);
        txtPVP.setText("" + precioPVP);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Al inicializar, los datos de las salsas se colocan en sus lugares correspondientes
        chxBarbacoa.getItems().addAll(cantidad);
        chxKetchup.getItems().addAll(cantidad);
        chxMostaza.getItems().addAll(cantidad);

    }
}