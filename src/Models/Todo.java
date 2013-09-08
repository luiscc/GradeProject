package Models;

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
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Read the existing entries and write to console
      //  Query q = em.createQuery("select t from Todo t");
     //   List<Todo> todoList = q.getResultList();
    //    for (Todo todo : todoList) {
    //        System.out.println(todo);
    //    }
    //    System.out.println("Size: " + todoList.size());

        // Create new todo
        em.getTransaction().begin();
       Project project = new Project("test","description");
       Sprint sprint = new Sprint("s","s");


        UserStory us = new UserStory("tes","tes");
        ArrayList<String> test = new ArrayList<String>();
        test.add("var");
        test.add("var");
        test.add("var");

        us.setAcceptTestCases(test);

        us.setStatusSprint(StatusUserHistory.workingInProgress);

        Task task = new Task("research",15);
        LogHour log1 = new LogHour(7);
        LogHour log2 = new LogHour(7);
        task.addLogHour(log1);
        task.addLogHour(log2);
        us.addTask(task);
        sprint.addUserStory(us);
        project.addSprint(sprint);

        //do todo = new Todo();
        //do.setSummary("This is a test");
        //do.setDescription("This is a test");
       em.persist(project);
       em.persist(sprint);
       em.persist(us);
       em.persist(task);

       em.getTransaction().commit();

        em.close();
    }

}
