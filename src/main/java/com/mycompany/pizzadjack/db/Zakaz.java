/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzadjack.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author satan
 */
@Entity
@Table(name = "zakaz")
@NamedQueries({
    @NamedQuery(name = "Zakaz.findAll", query = "SELECT z FROM Zakaz z"),
    @NamedQuery(name = "Zakaz.findById", query = "SELECT z FROM Zakaz z WHERE z.id = :id"),
    @NamedQuery(name = "Zakaz.findByFirstName", query = "SELECT z FROM Zakaz z WHERE z.firstName = :firstName"),
    @NamedQuery(name = "Zakaz.findBySecondName", query = "SELECT z FROM Zakaz z WHERE z.secondName = :secondName"),
    @NamedQuery(name = "Zakaz.findByAdres", query = "SELECT z FROM Zakaz z WHERE z.adres = :adres"),
    @NamedQuery(name = "Zakaz.findByPhone", query = "SELECT z FROM Zakaz z WHERE z.phone = :phone"),
    @NamedQuery(name = "Zakaz.findByZakaz", query = "SELECT z FROM Zakaz z WHERE z.zakaz = :zakaz"),
    @NamedQuery(name = "Zakaz.findByPrice", query = "SELECT z FROM Zakaz z WHERE z.price = :price")})
public class Zakaz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "SecondName")
    private String secondName;
    @Column(name = "Adres")
    private String adres;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Zakaz")
    private String zakaz;
    @Column(name = "price")
    private String price;

    public Zakaz() {
    }

    public Zakaz(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZakaz() {
        return zakaz;
    }

    public void setZakaz(String zakaz) {
        this.zakaz = zakaz;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zakaz)) {
            return false;
        }
        Zakaz other = (Zakaz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pizzadjack.db.Zakaz[ id=" + id + " ]";
    }
    
}
