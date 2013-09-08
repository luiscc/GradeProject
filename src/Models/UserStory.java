package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class UserStory
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idUserStory;


    private String nameStory;
    private String descriptionStory;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private long totalHours;
    private long estimateHours;
    private long workedHours;
    @ManyToOne
    @JoinColumn( nullable = false)
    private Sprint sprint;
    private String  acceptTestCases ;
    @Enumerated(EnumType.STRING)
    private StatusUserHistory status;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "userStory")
    private List<Task> tasks;

    public UserStory(){}


   public UserStory(String nameStory,String descriptionStory)
   {
       this.nameStory = nameStory;
       this.descriptionStory = descriptionStory;
       startDate = new Date();
       endDate = new Date();
       setTasks(new ArrayList<Task>());
   }


    public void setStatusSprint(StatusUserHistory status)
    {
        this.status = status;
    }
    public StatusUserHistory  getStatusSprint()
    {
        return this.status;
    }

   private List<String> getAcceptTestCases()
   {
       String result[] = acceptTestCases.split("-.-");
       ArrayList<String> stringsArrays = new ArrayList<String>();
       for (int index=0 ; index<result.length; index++)
       {
           stringsArrays.add(result[index]);
       }
       return stringsArrays;
   }

   public void setAcceptTestCases(List<String> testCases)
   {
       String result ="";
       for(String res : testCases)
       {
            result += res + "-.-";
       }
       this.acceptTestCases = result.substring(0,result.length()-3);
   }

    public long getIdUserStory() {
        return idUserStory;
    }

    public void setIdUserStory(long idUserStory) {
        this.idUserStory = idUserStory;
    }

    public String getNameStory() {
        return nameStory;
    }

    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public String getDescriptionStory() {
        return descriptionStory;
    }

    public void setDescriptionStory(String descriptionStory) {
        this.descriptionStory = descriptionStory;
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

    public long getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(long totalHours) {
        this.totalHours = totalHours;
    }

    public long getEstimateHours() {
        return estimateHours;
    }

    public void setEstimateHours(long estimateHours) {
        this.estimateHours = estimateHours;
    }

    public long getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(long workedHours) {
        this.workedHours = workedHours;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task)
    {
        this.tasks.add(task);
        task.setUserStory(this);
    }
}
