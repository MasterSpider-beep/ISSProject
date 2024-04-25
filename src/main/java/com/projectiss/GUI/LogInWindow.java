package com.projectiss.GUI;

import com.projectiss.domain.Angajat;
import com.projectiss.exceptions.ServiceException;
import com.projectiss.services.LogInControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInWindow {
    @FXML
    public TextField txtUsername;
    @FXML
    public TextField txtPassword;
    @FXML
    public Button btnLogin;

    private LogInControl service;

    public void setService(LogInControl service) {
        this.service = service;
    }

    public void initialize(){
        btnLogin.setOnAction(this::onPressLogin);
    }

    private void showErrorMessage(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void onPressLogin(ActionEvent actionEvent){
        if(txtPassword.getText().isEmpty() || txtUsername.getText().isEmpty()){
            showErrorMessage("Please complete the required fields!");
            return;
        }
        try{
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            Angajat angajat = service.checkAngajat(username,password);
            service.initiateLogin(angajat);
            Stage stage = (Stage)btnLogin.getScene().getWindow();
            stage.close();
        } catch (ServiceException e) {
            showErrorMessage(e.getMessage());
        }
    }
}
