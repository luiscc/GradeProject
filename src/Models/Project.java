package Models;

import com.sun.deploy.util.ArrayUtil;
import org.eclipse.persistence.descriptors.AllFieldsLockingPolicy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 12:32
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Project implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private long idProject;
    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    private List<Sprint> sprints ;

    @ManyToMany(targetEntity = User.class ,mappedBy = "projects")
    private List<User> users;


    public Project(){ }

    public Project(String name, String des)
    {
        this.name = name;
        this.description =  des;
        this.createdDate = new Date();
        sprints = new ArrayList<Sprint>();
        users = new ArrayList<User>();

    }

    public void addUser(User user)
    {
        users.add(user);
    }
    public void addUser(User user,PermissionSet permission)
    {
        if(permission.isSamePermission(TypePermission.Create,PermissionObject.User))
        {
           users.add(user);
        }
    }
    public boolean removeUser(User user)
    {
        return users.remove(user);
    }
    public boolean removeUser(int position)
    {
        User user = users.remove(position);
        return user !=null ;
    }

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "project")
    public List<Sprint> getSprints()
    {
      return  sprints;
    }

    public void setSprints(List<Sprint> sprints)
    {
        this.sprints = sprints;
    }

    public void addSprint(Sprint sprint)
    {
        this.sprints.add(sprint);
        sprint.setProject(this);
    }


    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
