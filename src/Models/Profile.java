package Models;

import org.eclipse.persistence.descriptors.AllFieldsLockingPolicy;

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
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private long idProfile;
    private String nameProfile;
    @Temporal(TemporalType.DATE)
    private Date createProfile;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "profile")
    private List<UserScrum> users;
    @ManyToMany
    @JoinTable(name="PerssionSetAssignment" ,joinColumns= @JoinColumn(name="profileId"),
                      inverseJoinColumns= @JoinColumn(name="permissiontSetId") )
    private List<PermissionSet> permissionSets;




    public Profile(String nameProfile)
    {
        this.nameProfile = nameProfile;
        this.createProfile = new Date();
        users = new ArrayList<UserScrum>();
    }

    public  Profile(){}


    public long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(long idProfile) {
        this.idProfile = idProfile;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public Date getCreateProfile() {
        return createProfile;
    }

    public void setCreateProfile(Date createProfile) {
        this.createProfile = createProfile;
    }

    public List<UserScrum> getUsers() {
        return users;
    }

    public void setUsers(List<UserScrum> users) {
        this.users = users;
    }

    public List<PermissionSet> getPermissionSets() {
        return permissionSets;
    }

    public void setPermissionSets(List<PermissionSet> permissionSets) {
        this.permissionSets = permissionSets;
    }
}
