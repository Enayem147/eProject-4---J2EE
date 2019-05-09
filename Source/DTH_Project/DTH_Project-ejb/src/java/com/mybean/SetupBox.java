/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author r0cklee147
 */
@Entity
@Table(name = "SetupBox")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SetupBox.findAll", query = "SELECT s FROM SetupBox s"),
    @NamedQuery(name = "SetupBox.findBySetID", query = "SELECT s FROM SetupBox s WHERE s.setID = :setID"),
    @NamedQuery(name = "SetupBox.findByImgs", query = "SELECT s FROM SetupBox s WHERE s.imgs = :imgs"),
    @NamedQuery(name = "SetupBox.findBySetName", query = "SELECT s FROM SetupBox s WHERE s.setName = :setName"),
    @NamedQuery(name = "SetupBox.findByQuantity", query = "SELECT s FROM SetupBox s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "SetupBox.findByPrice", query = "SELECT s FROM SetupBox s WHERE s.price = :price"),
    @NamedQuery(name = "SetupBox.findByDescription", query = "SELECT s FROM SetupBox s WHERE s.description = :description"),
    @NamedQuery(name = "SetupBox.findByDiscount", query = "SELECT s FROM SetupBox s WHERE s.discount = :discount")})
public class SetupBox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Set_ID")
    private Integer setID;
    @Size(max = 50)
    @Column(name = "imgs")
    private String imgs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Set_Name")
    private String setName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount")
    private double discount;

    public SetupBox() {
    }

    public SetupBox(Integer setID) {
        this.setID = setID;
    }

    public SetupBox(Integer setID, String setName, int quantity, double price, String description, double discount) {
        this.setID = setID;
        this.setName = setName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.discount = discount;
    }

    public Integer getSetID() {
        return setID;
    }

    public void setSetID(Integer setID) {
        this.setID = setID;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setID != null ? setID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SetupBox)) {
            return false;
        }
        SetupBox other = (SetupBox) object;
        if ((this.setID == null && other.setID != null) || (this.setID != null && !this.setID.equals(other.setID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mybean.SetupBox[ setID=" + setID + " ]";
    }
    
}
