package com.mycompany.pizzadjack;

import com.mycompany.pizzadjack.db.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SignUpController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_PizzaDjack_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private TextField signUpName;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpAdress;

    @FXML
    private TextField signUpTelephone;
    
    @FXML
    private Button exit;

    
    @FXML
    void exit(MouseEvent event) throws IOException {
        App.setRoot("sample");

    }
    @FXML
    void registration() throws IOException{
    addToUserTable(
        login_field.getText(),
        password_field.getText(),
        signUpName.getText(),
        signUpLastName.getText(),
        signUpTelephone.getText(),
        signUpAdress.getText()
    );
        App.setRoot("sample");
    }
    
    public static void addToUserTable(String login, String password, String name, String lastname, String phone, String addres){
                int role = 3;
                Query q = em.createNamedQuery("User.findAll");
                List<User> users = q.getResultList();
                int id = users.size() + 1;
                em.getTransaction().begin();
                em.createNativeQuery("INSERT INTO User ( id, name, login, password, role, UserRole_id, phone, adress, lastname)"
                    + " VALUES ( :a, :b, :c, :d, :e, :f, :g, :h, :l )")
                    .setParameter("a", id)
                    .setParameter("b", name)
                    .setParameter("c", login)
                    .setParameter("d", password)
                    .setParameter("e", role)
                    .setParameter("f", role)
                    .setParameter("g", phone)
                    .setParameter("h", addres)
                    .setParameter("l", lastname).executeUpdate();
                em.getTransaction().commit();               
    }
}

