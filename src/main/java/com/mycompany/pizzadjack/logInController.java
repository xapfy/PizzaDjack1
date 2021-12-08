package com.mycompany.pizzadjack;

import static com.mycompany.pizzadjack.SignUpController.em;
import com.mycompany.pizzadjack.db.User;
import com.mycompany.pizzadjack.db.Zakaz;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.Query;

public class logInController {
    int skidka = 0;
    @FXML
    private Text textcupon;
    @FXML
    private CheckBox checkBoxFour;
    @FXML
    private TextField cupTF;
    @FXML
    private CheckBox checkBoxOne;

    @FXML
    private CheckBox checkBoxThree;

    @FXML
    private CheckBox checkBoxTwo;
    
    @FXML
    void createZakaz(MouseEvent event) throws IOException{
        int kolvoPizz = 0;
        String namesPizza = "";
        if (checkBoxOne.isSelected()){
            kolvoPizz++;
            namesPizza += "Женини " + "\n";
        }
        if (checkBoxTwo.isSelected()){
            kolvoPizz++;
            namesPizza += "Максони " + "\n";
        }
        if (checkBoxThree.isSelected()){
            kolvoPizz++;
            namesPizza += "Сулугуни " + "\n";
        }
        if (checkBoxFour.isSelected()){
            kolvoPizz++;
            namesPizza += "Пеперони " + "\n";
        }
        String price = Integer.toString(kolvoPizz * 299); 
        price += " (скидка" + skidka + " рублей)";
        System.out.println("Цена: " + price);
        System.out.println("Пиццы:" + namesPizza);  
        
        addToZakazTable(Helper.FirstName, Helper.SecondName, Helper.Addres, Helper.Phone, namesPizza, price);
        App.setRoot("zakazGo");
    }
    
    
    public static void addToZakazTable(String FirstName, String SecondName, String Adres, String phone, String pizzaList, String price){

                Query q = em.createNamedQuery("Zakaz.findAll");
                List<Zakaz> zakaz = q.getResultList();
                int id;
                if (zakaz.size() != 0){
                    Zakaz z = zakaz.get(zakaz.size()-1);
                    id = z.getId() + 1;
                } else 
                    id = 0;
                
               
                
                em.getTransaction().begin();
                em.createNativeQuery("INSERT INTO zakaz (id, FirstName, SecondName, Adres, Phone, Zakaz, price)"
                    + " VALUES ( :a, :b, :c, :d, :e, :f, :g)")
                    .setParameter("a", id)
                    .setParameter("b", FirstName)
                    .setParameter("c", SecondName)
                    .setParameter("d", Adres)
                    .setParameter("e", phone)
                    .setParameter("f", pizzaList)
                    .setParameter("g", price).executeUpdate();
                em.getTransaction().commit();               
    }
        
    @FXML
    private Button exitLogIn;

    @FXML
    void exit1(MouseEvent event) throws IOException {
        App.setRoot("sample");

    }
    
    @FXML
    void checkCupon(){
        if (cupTF.getText().equals("promo")){
            
            skidka = 100;
            textcupon.setText("Вы получили скидку 100 рублей");
            cupTF.setDisable(true);
            cupTF.setVisible(false);
        }
    }    
}



