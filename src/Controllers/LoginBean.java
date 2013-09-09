package Controllers;





/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 31/08/13
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */

import helpers.UserHelper;
import org.primefaces.context.RequestContext;


import javax.faces.application.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.*;
import javax.faces.event.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "LoginBean")

public class LoginBean implements Serializable {


    private  String username;
    private String error;
    private  String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void login(ActionEvent actionEvent) throws IOException
    {
        RequestContext context = RequestContext.getCurrentInstance();
        UserHelper helper = UserHelper.getInstance();
        Boolean result =helper.existUser(username, password);
        System.out.println(result);
        if (result)
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("views/main.xhtml");
        }
        else
        {
            error="invalid Credentials";
            context.addCallbackParam("validationFailed",false);
        }


    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
