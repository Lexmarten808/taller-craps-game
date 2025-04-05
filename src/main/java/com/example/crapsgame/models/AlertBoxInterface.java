package com.example.crapsgame.models;

public interface AlertBoxInterface {
    void showAlertBox(String title, String header, String content);
    boolean showConfirmAlertBox(String title, String header, String content);
}
