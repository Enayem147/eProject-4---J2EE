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
@Table(name = "Channel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Channel.findAll", query = "SELECT c FROM Channel c"),
    @NamedQuery(name = "Channel.findByChannelNumber", query = "SELECT c FROM Channel c WHERE c.channelNumber = :channelNumber"),
    @NamedQuery(name = "Channel.findByChannelName", query = "SELECT c FROM Channel c WHERE c.channelName = :channelName"),
    @NamedQuery(name = "Channel.findByImg", query = "SELECT c FROM Channel c WHERE c.img = :img")})
public class Channel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Channel_Number")
    private Integer channelNumber;
    @Size(max = 50)
    @Column(name = "Channel_Name")
    private String channelName;
    @Size(max = 100)
    @Column(name = "img")
    private String img;

    public Channel() {
    }

    public Channel(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    public Integer getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelNumber != null ? channelNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channel)) {
            return false;
        }
        Channel other = (Channel) object;
        if ((this.channelNumber == null && other.channelNumber != null) || (this.channelNumber != null && !this.channelNumber.equals(other.channelNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mybean.Channel[ channelNumber=" + channelNumber + " ]";
    }
    
}
