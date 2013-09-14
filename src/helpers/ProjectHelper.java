package helpers;

import Beans.Connector;
import Models.Project;
import Models.UserScrum;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 14/09/13
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class ProjectHelper
{
    private EntityManager entityManager;
    private static  ProjectHelper projectHelper;
    public ProjectHelper()
    {
        entityManager = Connector.createEntityManage();
    }
    public static ProjectHelper getInstance()
    {
        if (projectHelper == null)
        {
            projectHelper = new ProjectHelper();
        }
        return projectHelper;
    }
    public Long  getNumbersProjectByUser(UserScrum user)
    {
        Query query = entityManager.createQuery("select count(u) from UserScrum u join u.projects p");
        return (Long) query.getSingleResult();
    }

    public List<Project> getProjectByUser(UserScrum user)
    {
        Query query = entityManager.createQuery("select p from Project p join p.users u " +
                                                "where u.password =:p1 and u.userlogin =:ul");
        query.setParameter("p1", user.getPassword());
        query.setParameter("ul",user.getUserlogin());
        return query.getResultList();
    }
    public List<Project> getProjectByUser(String password, String userLogin)
    {
        Query query = entityManager.createQuery("select p from Project p join p.users u " +
                                                        "where u.password =:p1 and u.userlogin =:ul");
        query.setParameter("p1", password);
        query.setParameter("ul",userLogin);
        List<Project> projects =query.getResultList();
        return projects;
    }

}
