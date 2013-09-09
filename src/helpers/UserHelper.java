package helpers;

import Beans.Connector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * UserProject: Luis Fernando C.C
 * Date: 8/09/13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class UserHelper
{
    private EntityManager entityManager;
    private static UserHelper userHelper;

    public static UserHelper getInstance()
    {
        if (userHelper==null)
        {
            userHelper = new UserHelper();
        }
        return userHelper;
    }

    private UserHelper()
    {
        entityManager = Connector.createEntityManage();
    }
    public boolean existUser(String userLogin, String passwordUser)
    {
        Query query = entityManager.createQuery("select count(u) from UserScrum u  where u.password=:password AND " +
                                                 "u.userlogin =:userLogin ");


        query.setParameter("password",passwordUser);
        query.setParameter("userLogin",userLogin);
        Long result = (Long) query.getSingleResult();
        return result.intValue()>0;
    }
}
