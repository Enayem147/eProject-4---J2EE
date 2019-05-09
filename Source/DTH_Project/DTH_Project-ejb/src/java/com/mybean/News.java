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
@Table(name = "News")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByNewsID", query = "SELECT n FROM News n WHERE n.newsID = :newsID"),
    @NamedQuery(name = "News.findByIntroduction", query = "SELECT n FROM News n WHERE n.introduction = :introduction"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByDescription1", query = "SELECT n FROM News n WHERE n.description1 = :description1"),
    @NamedQuery(name = "News.findByImage1", query = "SELECT n FROM News n WHERE n.image1 = :image1"),
    @NamedQuery(name = "News.findByDescription2", query = "SELECT n FROM News n WHERE n.description2 = :description2"),
    @NamedQuery(name = "News.findByImage2", query = "SELECT n FROM News n WHERE n.image2 = :image2"),
    @NamedQuery(name = "News.findByPostName", query = "SELECT n FROM News n WHERE n.postName = :postName"),
    @NamedQuery(name = "News.findByCreatedate", query = "SELECT n FROM News n WHERE n.createdate = :createdate")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "News_ID")
    private Integer newsID;
    @Size(max = 2147483647)
    @Column(name = "Introduction")
    private String introduction;
    @Size(max = 2147483647)
    @Column(name = "Title")
    private String title;
    @Size(max = 2147483647)
    @Column(name = "Description1")
    private String description1;
    @Size(max = 2147483647)
    @Column(name = "Image1")
    private String image1;
    @Size(max = 2147483647)
    @Column(name = "Description2")
    private String description2;
    @Size(max = 2147483647)
    @Column(name = "Image2")
    private String image2;
    @Size(max = 2147483647)
    @Column(name = "Post_Name")
    private String postName;
    @Column(name = "Create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public News() {
    }

    public News(Integer newsID) {
        this.newsID = newsID;
    }

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsID != null ? newsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsID == null && other.newsID != null) || (this.newsID != null && !this.newsID.equals(other.newsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mybean.News[ newsID=" + newsID + " ]";
    }
    
}
