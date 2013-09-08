package Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class LogHour {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idLogHour;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    private int workHours;

    @ManyToOne
    private Task task;

    public LogHour() {}

    public LogHour(int workHours)
    {
        this.workHours = workHours;
        this.createDate = new Date();
    }


    public long getIdLogHour() {
        return idLogHour;
    }

    public void setIdLogHour(long idLogHour) {
        this.idLogHour = idLogHour;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

