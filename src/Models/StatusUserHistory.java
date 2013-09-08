package Models;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 24/08/13
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
public enum StatusUserHistory {

    workingInProgress("Working In Progress"),
    ReadyForQE("Ready For QA"),
    Candidate("Candidate"),
    BackLog("BackLog");

    private final String value;
    private StatusUserHistory(String name)
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
