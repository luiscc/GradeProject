package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 12:48
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Sprint
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idSprint;
    private String nameSprint;
    private String descriptionSprint;
    private int hoursWorked;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Project project;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
    private List<UserStory> usersStories;

    public Sprint(){}

    public Sprint(String nameS ,String despS)
    {
      nameSprint = nameS;
      descriptionSprint = despS;
      startDate = new Date();
      endDate = new Date();
      usersStories = new ArrayList<UserStory>();
    }

    public List<UserStory> getUsersStories()
    {
        return usersStories;
    }

    public void addUserStory(UserStory userStory)
    {
        usersStories.add(userStory);
        userStory.setSprint(this);
    }




    public void setUsersStories(List<UserStory> userStories)
    {
        this.usersStories = userStories;
    }

    public String getNameSprint() {
        return nameSprint;
    }

    public void setNameSprint(String nameSprint) {
        this.nameSprint = nameSprint;
    }

    public String getDescriptionSprint() {
        return descriptionSprint;
    }

    public void setDescriptionSprint(String descriptionSprint) {
        this.descriptionSprint = descriptionSprint;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Project  getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
