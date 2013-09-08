package Models;


import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class PermissionSet {

     @Id
     @GeneratedValue(strategy = GenerationType.TABLE )
     private long idPermission;
     @Enumerated(EnumType.STRING)
     private PermissionObject permissionObject;
     @MapKeyEnumerated
     private TypePermission typePermission;
    @ManyToMany(mappedBy = "permissionSets")
    private List<Profile> profiles;


    public PermissionSet(){}

    public PermissionSet(PermissionObject object, TypePermission typePermision)
    {
        this.setPermissionObject(object);
        this.setTypePermission(typePermision);
    }


    public long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(long idPermission) {
        this.idPermission = idPermission;
    }

    public PermissionObject getPermissionObject() {
        return permissionObject;
    }

    public void setPermissionObject(PermissionObject permissionObj) {
        this.permissionObject = permissionObj;
    }

    public TypePermission getTypePermission() {
        return typePermission;
    }

    public void setTypePermission(TypePermission typePermission) {
        this.typePermission = typePermission;
    }

    public boolean isSamePermission(TypePermission typeP, PermissionObject permissionObj)
    {
        return this.permissionObject == permissionObj && this.typePermission == typeP;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}

