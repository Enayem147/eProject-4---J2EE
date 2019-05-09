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
@Table(name = "Dealer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealer.findAll", query = "SELECT d FROM Dealer d"),
    @NamedQuery(name = "Dealer.findByDeaID", query = "SELECT d FROM Dealer d WHERE d.deaID = :deaID"),
    @NamedQuery(name = "Dealer.findByPassword", query = "SELECT d FROM Dealer d WHERE d.password = :password"),
    @NamedQuery(name = "Dealer.findByDeaName", query = "SELECT d FROM Dealer d WHERE d.deaName = :deaName"),
    @NamedQuery(name = "Dealer.findByCompanyName", query = "SELECT d FROM Dealer d WHERE d.companyName = :companyName"),
    @NamedQuery(name = "Dealer.findByAddress", query = "SELECT d FROM Dealer d WHERE d.address = :address"),
    @NamedQuery(name = "Dealer.findByLocationID", query = "SELECT d FROM Dealer d WHERE d.locationID = :locationID"),
    @NamedQuery(name = "Dealer.findByPhoneNumber", query = "SELECT d FROM Dealer d WHERE d.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Dealer.findByEmail", query = "SELECT d FROM Dealer d WHERE d.email = :email"),
    @NamedQuery(name = "Dealer.findByFirstLogin", query = "SELECT d FROM Dealer d WHERE d.firstLogin = :firstLogin")})
public class Dealer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Dea_ID")
    private String deaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Dea_Name")
    private String deaName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Company_Name")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Location_ID")
    private int locationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Phone_Number")
    private String phoneNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "First_Login")
    private boolean firstLogin;

    public Dealer() {
    }

    public Dealer(String deaID) {
        this.deaID = deaID;
    }

    public Dealer(String deaID, String password, String deaName, String companyName, String address, int locationID, String phoneNumber, String email, boolean firstLogin) {
        this.deaID = deaID;
        this.password = password;
        this.deaName = deaName;
        this.companyName = companyName;
        this.address = address;
        this.locationID = locationID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.firstLogin = firstLogin;
    }

    public String getDeaID() {
        return deaID;
    }

    public void setDeaID(String deaID) {
        this.deaID = deaID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeaName() {
        return deaName;
    }

    public void setDeaName(String deaName) {
        this.deaName = deaName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deaID != null ? deaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dealer)) {
            return false;
        }
        Dealer other = (Dealer) object;
        if ((this.deaID == null && other.deaID != null) || (this.deaID != null && !this.deaID.equals(other.deaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mybean.Dealer[ deaID=" + deaID + " ]";
    }
    
}
