package com.mycompany.pizzadjack;

import com.mycompany.pizzadjack.db.Zakaz;
import java.io.IOException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdminController {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_PizzaDjack_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    private Zakaz currentZak;
    @FXML
    TableView ZakazTables;
    @FXML
    TableColumn<Zakaz, String> ColumnName;
    @FXML
    TableColumn<Zakaz, String> ColumnSecondName;
    @FXML
    TableColumn<Zakaz, String> ColumnPhone;
    @FXML
    TableColumn<Zakaz, String> ColumnAdres;
    @FXML
    TableColumn<Zakaz, String> ColumnZakaz;
    @FXML
    TableColumn<Zakaz, String> ColumnPrice;
    static int id = 0;
    @FXML
    private void initialize() {
        Query q = em.createNamedQuery("Zakaz.findAll");
        List<Zakaz> z = q.getResultList();
        ObservableList tableModel = ZakazTables.getItems();

        ColumnName.setCellValueFactory((TableColumn.CellDataFeatures<Zakaz, String> cd) -> {

            return new SimpleStringProperty(cd.getValue().getFirstName());
        });
        ColumnSecondName.setCellValueFactory((TableColumn.CellDataFeatures<Zakaz, String> cd) -> {

            return new SimpleStringProperty(cd.getValue().getSecondName());
        });
        ColumnAdres.setCellValueFactory((TableColumn.CellDataFeatures<Zakaz, String> cd) -> {

            return new SimpleStringProperty(cd.getValue().getAdres());
        });
        ColumnZakaz.setCellValueFactory((TableColumn.CellDataFeatures<Zakaz, String> cd) -> {

            return new SimpleStringProperty(cd.getValue().getZakaz());
        });
        ColumnPhone.setCellValueFactory((TableColumn.CellDataFeatures<Zakaz, String> cd) -> {

            return new SimpleStringProperty(cd.getValue().getPhone());
        });
        ColumnPrice.setCellValueFactory((TableColumn.CellDataFeatures<Zakaz, String> cd) -> {

            return new SimpleStringProperty(cd.getValue().getPrice());
        });

        z.forEach(p -> {
            tableModel.add(p);
        });
    }
    @FXML
    private void onMouseClicked() {
        int rowIndex = ZakazTables.getSelectionModel().getFocusedIndex();
        currentZak = (Zakaz) ZakazTables.getItems().get(rowIndex);
        id = (currentZak.getId());
        
    }        
    @FXML
    void deleteZakaz() throws IOException {
        if(id > -1){
            em.getTransaction().begin();
            em.createNativeQuery("Delete From Pizza.zakaz Where Id = " + id).executeUpdate();              
            em.getTransaction().commit();
            id = 0;
            App.setRoot("adminPanel");
        }
    }
}
