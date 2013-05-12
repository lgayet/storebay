package com.loloconsult.storebay.dao;

import com.loloconsult.storebay.AbstractBaseTest;
import com.loloconsult.storebay.entity.Article;
import org.codehaus.jackson.map.Module;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.TransactionManager;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Laurent
 * Date: 08/05/13
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */
public class ArticleDaoTest extends AbstractBaseTest {

    //The EJB to test
    private ArticleDao articleDao;

    @Override
    protected String getClassName() {
        return ArticleDaoTest.class.getName();
    }

    @Before
    public void setUp() throws Exception {
        // Check JNDI dependencies
        // Looks up for the EJB
        articleDao = (ArticleDao) ctx.lookup("java:global/classes/ArticleDao");
    }

    @Test
    public void testCreer() throws Exception {

        Article article = new Article("Article", 30.0);

        //Methode à tester
        articleDao.creer(article);

        Article resultat = getEm().find(Article.class, article.getId());
        assertEquals(Long.valueOf(1L), resultat.getId());
        assertEquals(article, resultat);
        assert(article.getPrix() == resultat.getPrix());
    }

    @Test
    public void testRechercherParNom() throws Exception {

        getTx().begin();

        Article article1 = new Article("Article1", 10.0);
        getEm().persist(article1);
        Article article2 = new Article("Article2", 25.0);
        getEm().persist(article2);

        getTx().commit();

        //Methode à tester
        Article resultat = articleDao.rechercherParNom("Article1");
        assertEquals(article1, resultat);
        assert(article1.getPrix() == resultat.getPrix());

        resultat = articleDao.rechercherParNom("Article2");
        assertEquals(article2, resultat);
        assert(article2.getPrix() == resultat.getPrix());
    }

}
