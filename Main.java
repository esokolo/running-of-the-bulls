package com.Lab;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {

    public void start(Stage primaryStage) {

        Scene scene = new Scene(new MazeGUIPane(25, 25), 810, 700);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab 9");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
