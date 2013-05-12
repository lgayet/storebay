package com.loloconsult.storebay;

import org.junit.BeforeClass;

import javax.annotation.PreDestroy;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Laurent
 * Date: 11/05/13
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBaseTest {

    protected static EJBContainer ec;
    protected static Context ctx;
    protected static Long millis = new Date().getTime();

    protected static Resources resources;

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File[]{new File("target/classes-sans-persistence/classes"), new File("target/test-classes")});
        ec = EJBContainer.createEJBContainer(properties);
        ctx = ec.getContext();

        resources = (Resources) ctx.lookup("java:global/classes/Resources");
    }

    @PreDestroy
    public void closeContainer() throws Exception {
        if (ec != null) {
            ec.close();
        }
        getLog().info(">>> test of " + getClassName() + " took : " + (new Date().getTime() - millis) + " millis");
    }

    protected abstract String getClassName();

    public Logger getLog() {
        return resources.getLog();
    }

    public EntityManager getEm() {
        return resources.getEm();
    }

    public UserTransaction getTx() {
        return resources.getTx();
    }
}
