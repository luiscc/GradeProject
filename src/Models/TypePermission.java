package Models;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 16:21
 * To change this template use File | Settings | File Templates.
 */
public  enum  TypePermission
{
    Update("Update Entity"),
    Create("Create"),
    Delete("Delete"),
    View("View");

    private final String value;
    private TypePermission(String name)
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
