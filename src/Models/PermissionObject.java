package Models;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public enum PermissionObject {

    UserStory("UserStory"),
    Project("Project"),
    Sprint("Sprint"),
    Task("Task"),
    LogHours("LogUser"),
    User("User");
    private final String value;
    private PermissionObject(String name)
    {
        this.value = name;
    }
    public boolean  equalsValue(String otherValue)
    {
        return (otherValue == null)? false : value.equals(otherValue);
    }
    public String getValue()
    {
        return this.value;
    }


}
