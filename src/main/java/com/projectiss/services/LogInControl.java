package com.projectiss.services;

import com.projectiss.GUI.LogInWindow;
import com.projectiss.GUI.MainWindow;
import com.projectiss.Main;
import com.projectiss.domain.Angajat;
import com.projectiss.exceptions.ServiceException;
import com.projectiss.repository.AngajatiRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class LogInControl {
    private final AngajatiRepository repository;
    private final Properties properties;

    public LogInControl(Properties properties) {
        this.repository = new AngajatiRepository(properties);
        this.properties = properties;
    }

    public Angajat checkAngajat(String username, String password) throws ServiceException {
        Optional<Angajat> angajatOp = repository.findAngajat(username,password);
        if(angajatOp.isEmpty()){
            throw new ServiceException("Incorrect credentials!");
        }
        return angajatOp.get();
    }

    public void initiateLogin(Angajat angajat){

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            MainControl service = new MainControl(this.properties);

            MainWindow mainWindow = fxmlLoader.getController();
            mainWindow.setService(service);
            mainWindow.setAngajat(angajat);
            Stage stage = new Stage();
            stage.setTitle("Main");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
