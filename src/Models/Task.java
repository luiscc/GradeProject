package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idTask;
    private String nameTask;
    private int estimateHours;
    private int workedHours;
    private int RemainHours;
    @Temporal(TemporalType.DATE)
    private Date createTask;
    @ManyToOne
    @JoinColumn(nullable = false)
    private UserStory userStory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private List<LogHour> logHours;

    public Task(String name, int estimateHours)
    {
        this.setNameTask(name);
        this.setEstimateHours(estimateHours);
        setCreateTask(new Date());
        logHours = new ArrayList<LogHour>();
    }

    public Task() {}


    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(long idTask) {
        this.idTask = idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public int getEstimateHours() {
        return estimateHours;
    }

    public void setEstimateHours(int estimateHours) {
        this.estimateHours = estimateHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public int getRemainHours() {
        return estimateHours -workedHours;
    }



    public Date getCreateTask() {
        return createTask;
    }

    public void setCreateTask(Date createTask) {
        this.createTask = createTask;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public List<LogHour> getLogHours() {
        return logHours;
    }

    public void setLogHours(List<LogHour> logHours) {
        this.logHours = logHours;
    }
    public void addLogHour(LogHour logHour)
    {
        this.logHours.add(logHour);
        logHour.setTask(this);
    }
}
