package com.example.crapsgame.models;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

public class AlertBox implements AlertBoxInterface{
    @Override
    public void showAlertBox(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefSize(500, 300);

        alert.showAndWait();
    }

    @Override
    public boolean showConfirmAlertBox(String title, String header, String content) {
        return false;
    }
}
