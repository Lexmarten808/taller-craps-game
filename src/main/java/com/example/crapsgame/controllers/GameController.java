package com.example.crapsgame.controllers;

import com.example.crapsgame.models.AlertBox;
import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Player;
import com.example.crapsgame.models.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private Button questionMarkButton;

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

    AlertBox alertBox=new AlertBox();

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    Game game = new Game();

    private boolean isPointEstablished = false; // Tracks if the point has been set

    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice(); // Create the first dice
        Dice dice2 = new Dice(); // Create the second dice

        // Roll both dice and calculate the total score
        int rollScore = dice1.roll() + dice2.roll();

        // Display the dice images based on their face values
        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));

        // Show the rolled score
        this.rollScoreLabel.setText(String.valueOf(rollScore));

        if (!isPointEstablished) {
            // First roll
            // Determine the result based on the fisrt roll
            if (rollScore == 7 || rollScore == 11) {
                increaseWins(); // Player wins instantly
            } else if (rollScore == 2 || rollScore == 3 || rollScore == 12) {
                increaseLosses(); // Player loses instantly
            } else {
                game.setPoint(rollScore); // Set the point
                isPointEstablished = true;
                pointLabel.setStyle("-fx-background-color: #87e88d; -fx-text-fill: #000000; -fx-border-color: black");
                this.pointLabel.setText(String.valueOf(rollScore)); // Update the point label
            }
        } else {
            // Rolling after point is established
            if (rollScore == game.getPoint()) {
                increaseWins();
                isPointEstablished = false; // Reset state
                pointLabel.setStyle("-fx-background-color: white; -fx-text-fill: #000000; -fx-border-color: black");
                this.pointLabel.setText(String.valueOf(0));
            } else if (rollScore == 7) {
                increaseLosses();
                isPointEstablished = false; // Reset state
                pointLabel.setStyle("-fx-background-color: white; -fx-text-fill: #000000; -fx-border-color: black");
                this.pointLabel.setText(String.valueOf(0));
            }
            // If it's not the point or a 7, just wait for the next roll.
        }


    }

    // Function to increase the number of wins by 1
    private void increaseWins() {
        int wins = game.getWins(); // Get the current number of wins
        wins += 1; // Increment the number of wins by 1
        game.setWins(wins); // Set the new number of wins
        this.winGamesLabel.setText(String.valueOf(wins)); // Update the label with the new value
    }

    // Function to increase the number of losses by 1
    private void increaseLosses() {
        int losses = game.getLosses(); // Get the current number of losses
        losses += 1; // Increment the number of losses by 1
        game.setLosses(losses); // Set the new number of losses
        this.lostGamesLabel.setText(String.valueOf(losses)); // Update the label with the new value
    }

    @FXML
    void onActionQuestionMark(ActionEvent event) {
        alertBox.showAlertBox(
                "Instrucciones",
                "Instrucciones del juego",
                "El juego comienza cuando el jugador realiza su lanzamiento o tiro de salida.\n\n" +
                        "Si en ese lanzamiento sacas un 7 o un 11, ganas automáticamente.\n" +
                        "Si sacas un 2, 3 o 12, es un \"Craps\" y pierdes.\n\n" +
                        "Cualquier otro número (4, 5, 6, 8, 9 o 10) establece el \"punto\".\n" +
                        "Una vez establecido el punto, puedes seguir lanzando los dados con el objetivo\n" +
                        "de volver a sacar ese mismo número. Si lo logras antes de sacar un 7, ganas.\n" +
                        "Pero si sacas un 7 antes del punto, pierdes."
        );
    }

    @FXML
    void onMouseEnteredHoverEffectStart(MouseEvent event) {
        questionMarkButton.setStyle(
                "-fx-background-color: white; " +
                        "-fx-border-color: black; " +
                        "-fx-text-fill: black; " +
                        "-fx-border-radius: 10; " +
                        "-fx-background-radius: 10; " +
                        "-fx-cursor: hand;"
        );
    }

    @FXML
    void onMouseExitedHoverEffectFinish(MouseEvent event) {
        questionMarkButton.setStyle(
                "-fx-background-color: black; " +
                        "-fx-border-color: white; " +
                        "-fx-text-fill: white; " +
                        "-fx-border-radius: 10; " +
                        "-fx-background-radius: 10; " +
                        "-fx-cursor: default;"
        );
    }
}
