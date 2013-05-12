package com.loloconsult.storebay.dao;

import com.loloconsult.storebay.entity.Article;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Laurent
 * Date: 04/05/13
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ArticleDao {

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext(name = "datasource")
    private EntityManager em;

    // Enregistrement d'un nouvel utilisateur
    public void creer(Article article){
        em.persist(article);
    }

    // Recherche d'un article à partir de son nom
    public Article rechercherParNom(String nom) throws NoResultException {
        Article article = (Article) em.createQuery("SELECT a FROM Article a WHERE a.nom=:nom")
                .setParameter("nom", nom)
                .getSingleResult();
        return article;
    }
}
