package com.example.crapsgame.controllers;

import com.example.crapsgame.models.AlertBox;
import com.example.crapsgame.models.Player;
import com.example.crapsgame.views.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private ImageView imageView;
    private int cont = 0;

    @FXML
    private TextField nicknameTextField;

    @FXML
    public void onActionStartButton(ActionEvent actionEvent) throws IOException {
        String nickname = nicknameTextField.getText();
        Player player = new Player();
        player.setNickname(nickname);

        // new AlertBox().showAlertBox("Are you ready?!", "Are you ready?!", "Are you ready?!");

        GameView gameView = GameView.getInstance();
        gameView.show();
        gameView.getController().setPlayer(player);
        gameView.getController().showNicknameLabel();

    }
}
