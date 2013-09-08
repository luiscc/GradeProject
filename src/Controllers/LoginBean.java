package Controllers;





/**
 * Created with IntelliJ IDEA.
 * User: Luis Fernando C.C
 * Date: 31/08/13
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */

import org.primefaces.context.RequestContext;


import javax.faces.application.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.*;
import javax.faces.event.*;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@ManagedBean(name = "LoginBean")

public class LoginBean implements Serializable {


    public  String username;

    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(ActionEvent actionEvent) {
       RequestContext context = RequestContext.getCurrentInstance();

        FacesMessage msg = null;
        boolean loggedIn = false;
        System.out.println("resssssssss");
        System.out.println("tes"+context.isAjaxRequest());
        if(username != null  && username.equals("admin") && password != null  && password.equals("admin")) {
            loggedIn = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }
        context.addCallbackParam("categories","res");

        FacesContext.getCurrentInstance().addMessage(null, msg);

       context.addCallbackParam("loggedIn", loggedIn);
    }
}
