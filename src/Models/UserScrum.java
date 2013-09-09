package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 8/09/13
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class UserScrum {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idUser;
    private String email;
    private String nameUser;
    private String lastNameUser;
    private String password;
    private String keyPassword;
    private String userlogin;
    @Temporal(TemporalType.DATE)
    private Date createUser;
    @Temporal(TemporalType.DATE)
    private Date lastLogin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USER_PROJECT", joinColumns =@JoinColumn(name = "User_ID"),
                      inverseJoinColumns = @JoinColumn(name = "Project_ID"  ))
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "ProfileUserId", nullable = false)
    private Profile profile;



    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public Date getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Date createUser) {
        this.createUser = createUser;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
