package com.example.crapsgame;

import com.example.crapsgame.views.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WelcomeView welcomeView = WelcomeView.getInstance();
        welcomeView.show();
    }

    public static void main(String[] args) {
        launch();
    }
}