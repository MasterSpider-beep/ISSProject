package com.projectiss.GUI;

import com.projectiss.domain.AccessLevel;
import com.projectiss.domain.Angajat;
import com.projectiss.domain.Produs;
import com.projectiss.services.MainControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainWindow {
    @FXML
    public TableView<Produs> tableProduse;
    @FXML
    public TableColumn<Produs,String> colNumeProduse;
    @FXML
    public TableColumn<Produs,Float> colPretProduse;
    @FXML
    public TableColumn<Produs,Integer> colStockProduse;
    @FXML
    public TableView tableComanda;
    @FXML
    public TableColumn colNumeComanda;
    @FXML
    public TableColumn colCantitateComanda;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnReset;
    @FXML
    public Button btnOrder;
    @FXML
    public Button btnRestock;
    @FXML
    public Spinner<Integer> spinnerBox;
    private MainControl service;
    private Angajat angajat;
    private final ObservableList<Produs> produseObservable = FXCollections.observableArrayList();

    public void setService(MainControl service) {
        this.service = service;
        showProduse();
    }
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
        showButtons();
    }

    public void showProduse(){
        produseObservable.setAll(service.getAllProduse());
    }

    public void initialize(){
        colNumeProduse.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPretProduse.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStockProduse.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableProduse.setItems(produseObservable);

        btnAdd.setVisible(false);
        btnOrder.setVisible(false);
        btnReset.setVisible(false);
        btnRestock.setVisible(false);
    }

    private void showButtons(){
        btnAdd.setVisible(true);
        btnReset.setVisible(true);
        btnOrder.setVisible(true);
        if(angajat.getAccessLevel()== AccessLevel.supervizor){
            btnRestock.setVisible(true);
        }
    }
}
