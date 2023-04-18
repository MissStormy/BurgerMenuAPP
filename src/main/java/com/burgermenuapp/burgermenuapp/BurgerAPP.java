package com.burgermenuapp.burgermenuapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BurgerAPP extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BurgerAPP.class.getResource("burgerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 560);
        stage.setTitle("Burger Menu APP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}