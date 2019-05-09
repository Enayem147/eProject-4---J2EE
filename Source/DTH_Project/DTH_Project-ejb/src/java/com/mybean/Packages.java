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
@Table(name = "Packages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findByPackageID", query = "SELECT p FROM Packages p WHERE p.packageID = :packageID"),
    @NamedQuery(name = "Packages.findByPackageName", query = "SELECT p FROM Packages p WHERE p.packageName = :packageName"),
    @NamedQuery(name = "Packages.findByNumberofChannels", query = "SELECT p FROM Packages p WHERE p.numberofChannels = :numberofChannels"),
    @NamedQuery(name = "Packages.findBySetID", query = "SELECT p FROM Packages p WHERE p.setID = :setID"),
    @NamedQuery(name = "Packages.findByPricePerMonth", query = "SELECT p FROM Packages p WHERE p.pricePerMonth = :pricePerMonth"),
    @NamedQuery(name = "Packages.findByDescription", query = "SELECT p FROM Packages p WHERE p.description = :description"),
    @NamedQuery(name = "Packages.findByDiscount", query = "SELECT p FROM Packages p WHERE p.discount = :discount")})
public class Packages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Package_ID")
    private String packageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Package_Name")
    private String packageName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Number_of_Channels")
    private int numberofChannels;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Set_ID")
    private int setID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price_Per_Month")
    private double pricePerMonth;
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Discount")
    private Double discount;

    public Packages() {
    }

    public Packages(String packageID) {
        this.packageID = packageID;
    }

    public Packages(String packageID, String packageName, int numberofChannels, int setID, double pricePerMonth) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.numberofChannels = numberofChannels;
        this.setID = setID;
        this.pricePerMonth = pricePerMonth;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getNumberofChannels() {
        return numberofChannels;
    }

    public void setNumberofChannels(int numberofChannels) {
        this.numberofChannels = numberofChannels;
    }

    public int getSetID() {
        return setID;
    }

    public void setSetID(int setID) {
        this.setID = setID;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageID != null ? packageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.packageID == null && other.packageID != null) || (this.packageID != null && !this.packageID.equals(other.packageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mybean.Packages[ packageID=" + packageID + " ]";
    }
    
}
