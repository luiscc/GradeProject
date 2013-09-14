package Controllers;

/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 14/09/13
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
public class Document
{
    private String nameDocument;
    private int number;

    public Document(String nd, int n)
    {
        this.setNameDocument(nd);
        this.setNumber(n);
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
