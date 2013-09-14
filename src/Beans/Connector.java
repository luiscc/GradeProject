package Beans;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 22/08/13
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class Connector {

    private static final String PERSISTENCE_UNIT_NAME = "enterprise";
    private static EntityManagerFactory factory;
    private static EntityManager em;
    public static EntityManager createEntityManage()
    {
        if (em == null)
        {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
        }
        return em;
    }

    public static void saveEntity(Object objectValue)
    {
        em = createEntityManage();
        try
        {
            em.getTransaction().begin();
            em.persist(objectValue);
            em.getTransaction().commit();
        }finally {
            em.close();

        }
    }

    public static void removeEntities(List objects)
    {
        em = createEntityManage();
        try
        {
            em.getTransaction().begin();
            Iterator it =objects.iterator();
            while (it.hasNext())
            {
                Object valueObject = it.next();
                em.remove(valueObject);
            }
            em.getTransaction().commit();


        }finally {
            em.close();
        }
    }


    public static void saveEntities(List objects)
    {
        em = createEntityManage();
        try
        {
            em.getTransaction().begin();
            Iterator it =objects.iterator();
            while (it.hasNext())
            {
                Object valueObject = it.next();
                em.persist(valueObject);
            }
            em.getTransaction().commit();


        }finally {
            em.close();
        }
    }
    public static void removeEntity(Object entityValue)
    {
        em = createEntityManage();

        try
        {
            em.getTransaction().begin();
            em.remove(entityValue);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }

    }


}
