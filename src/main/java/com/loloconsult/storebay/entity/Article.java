package com.loloconsult.storebay.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Laurent
 * Date: 04/05/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "PRIX")
    private double prix;
    @Basic(optional = true)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = true)
    @Column(name = "IMAGE_URL")
    private String urlImage;

    public Article() {
    }

    public Article(String nom) {
        this.nom = nom;
    }

    public Article(String nom, double prix, String description, String urlImage) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.urlImage = urlImage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
