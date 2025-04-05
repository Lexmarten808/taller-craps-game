package com.example.crapsgame.controllers;

import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Player;
import com.example.crapsgame.models.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private Label pointLabel;

    @FXML
    private Label winGamesLabel;

    @FXML
    private Label lostGamesLabel;

    @FXML
    private ImageView diceImageView1;

    @FXML
    private ImageView diceImageView2;

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    Game game = new Game();

    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int rollScore = dice1.roll() + dice2.roll();

        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));
        this.rollScoreLabel.setText(String.valueOf(rollScore));

        if (rollScore == 7 || rollScore == 11) {
            int wins = game.getWins() + 1;
            game.setWins(wins);
            this.winGamesLabel.setText(String.valueOf(wins));
        } else if (rollScore == 2 || rollScore == 3 || rollScore == 12) {
            int losses = game.getLosses() + 1;
            game.setLosses(losses);
            this.lostGamesLabel.setText(String.valueOf(losses));
        } else {
            int point = game.getPoint();
            game.setPoint(point);
            this.pointLabel.setText(String.valueOf(point));
        }
    }
}
