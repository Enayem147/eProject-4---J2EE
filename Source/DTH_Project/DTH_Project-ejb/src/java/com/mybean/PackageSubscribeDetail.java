/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author r0cklee147
 */
@Entity
@Table(name = "PackageSubscribeDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PackageSubscribeDetail.findAll", query = "SELECT p FROM PackageSubscribeDetail p"),
    @NamedQuery(name = "PackageSubscribeDetail.findByPSDetailID", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.pSDetailID = :pSDetailID"),
    @NamedQuery(name = "PackageSubscribeDetail.findByCusID", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.cusID = :cusID"),
    @NamedQuery(name = "PackageSubscribeDetail.findByPackageID", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.packageID = :packageID"),
    @NamedQuery(name = "PackageSubscribeDetail.findByPackageSubscribeDate", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.packageSubscribeDate = :packageSubscribeDate"),
    @NamedQuery(name = "PackageSubscribeDetail.findByMonth", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.month = :month"),
    @NamedQuery(name = "PackageSubscribeDetail.findByPrice", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.price = :price"),
    @NamedQuery(name = "PackageSubscribeDetail.findByExpired", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.expired = :expired"),
    @NamedQuery(name = "PackageSubscribeDetail.findByInstalltionStatus", query = "SELECT p FROM PackageSubscribeDetail p WHERE p.installtionStatus = :installtionStatus")})
public class PackageSubscribeDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PS_Detail_ID")
    private Integer pSDetailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Cus_ID")
    private String cusID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Package_ID")
    private String packageID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Package_Subscribe_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date packageSubscribeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Month")
    private int month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @Column(name = "Expired")
    private Boolean expired;
    @Column(name = "Installtion_Status")
    private Boolean installtionStatus;

    public PackageSubscribeDetail() {
    }

    public PackageSubscribeDetail(Integer pSDetailID) {
        this.pSDetailID = pSDetailID;
    }

    public PackageSubscribeDetail(Integer pSDetailID, String cusID, String packageID, Date packageSubscribeDate, int month, double price) {
        this.pSDetailID = pSDetailID;
        this.cusID = cusID;
        this.packageID = packageID;
        this.packageSubscribeDate = packageSubscribeDate;
        this.month = month;
        this.price = price;
    }

    public Integer getPSDetailID() {
        return pSDetailID;
    }

    public void setPSDetailID(Integer pSDetailID) {
        this.pSDetailID = pSDetailID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public Date getPackageSubscribeDate() {
        return packageSubscribeDate;
    }

    public void setPackageSubscribeDate(Date packageSubscribeDate) {
        this.packageSubscribeDate = packageSubscribeDate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Boolean getInstalltionStatus() {
        return installtionStatus;
    }

    public void setInstalltionStatus(Boolean installtionStatus) {
        this.installtionStatus = installtionStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pSDetailID != null ? pSDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageSubscribeDetail)) {
            return false;
        }
        PackageSubscribeDetail other = (PackageSubscribeDetail) object;
        if ((this.pSDetailID == null && other.pSDetailID != null) || (this.pSDetailID != null && !this.pSDetailID.equals(other.pSDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mybean.PackageSubscribeDetail[ pSDetailID=" + pSDetailID + " ]";
    }
    
}
