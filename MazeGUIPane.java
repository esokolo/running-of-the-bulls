package com.Lab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MazeGUIPane extends BorderPane {

    private StreetMap streetMap;
    private int numberOfRows;
    private int numberOfColumns;
    private GridPane gridPane;
    private Label[][] labels;
    private HBox hBox;
    private HBox titleHBox;
    private Button resetButton;
    private Coordinate[][] result;

    public MazeGUIPane(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        makeLabels();
        addTopHBox();
        addBottomHBox();

        Handling();

        setTop(titleHBox);
        setCenter(gridPane);
        setBottom(hBox);
    }

    private void makeLabels() {
        this.streetMap = new
                StreetMap(numberOfRows, numberOfColumns);
        this.gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: aquamarine");
        gridPane.setAlignment(Pos.CENTER);
        this.labels = new Label[numberOfRows][numberOfColumns];
        result = streetMap.getCoordinates();

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                labels[i][j] = new Label("  ");
                labels[i][j].setPadding(new Insets(0.5, 12, 0.5, 12));
                if (result[i][j].getValue() == 'W')
                    labels[i][j].setStyle("-fx-background-color: red");
                gridPane.add(labels[i][j], j, i);
            }
        }
        labels[0][1].setText("S");
        labels[numberOfRows - 1][numberOfColumns - 2].setText("E");
    }

    private void addBottomHBox() {
        hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        resetButton = new Button("Reset");
        hBox.setPadding(new Insets(10, 12, 15, 45));
        hBox.getChildren().add(resetButton);
    }

    private void addTopHBox() {
        titleHBox = new HBox(15);
        titleHBox.setAlignment(Pos.CENTER);
        Label titleLabel = new Label("The Map of the Game");
        titleHBox.setPadding(new Insets(15, 12, 15, 15));
        titleLabel.setStyle("-fx-font-size: 30");
        titleHBox.getChildren().add(titleLabel);
    }

    private void Handling()
    {
        for (int i = 1; i < numberOfRows - 1; i++)
            for (int j = 1; j < numberOfColumns - 1; j++)
            {
                final int m = i;
                final int k = j;

                if (result[i][j].getValue() == ' ')
                    result[m][k].setValue('W');
                else
                    result[m][k].setValue(' ');


                labels[i][j].setOnMouseClicked(event -> {
                    if (result[m][k].getValue() == ' ')
                    {
                        labels[m][k].setStyle("-fx-background-color: aquamarine");
                        result[m][k].setValue('W');
                    }
                    else
                    {
                        labels[m][k].setStyle("-fx-background-color: red");
                        result[m][k].setValue(' ');
                    }
                });
        }
    }
}

















