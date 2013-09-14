package Models;

import helpers.ProjectHelper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 22/08/13
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String description;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo [summary=" + summary + ", description=" + description
                + "]";
    }
    private static final String PERSISTENCE_UNIT_NAME = "enterprise";
    private static EntityManagerFactory factory;
    public static void main(String[] args)
    {
        ProjectHelper h = ProjectHelper.getInstance();
       List<Project> project =  h.getProjectByUser("admin","admin");
        for(Project pr : project)
        {
            System.out.println(pr.getName());
        }

    }

}
