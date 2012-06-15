package com.inwise.action;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.ajax.JavaScriptResolution;

import java.util.List;
import java.util.Iterator;

import javax.annotation.security.RolesAllowed;

import com.inwise.action.BaseActionBean;
import com.inwise.pojo.User;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: Feb 20, 2012
 * Time: 3:33:43 PM
 * To change this template use File | Settings | File Templates.
 */
@HttpCache(allow = false)
public class UserActionBean extends BaseActionBean {

    private final String LOGIN="jsp/login.jsp";
    private final String SUCCESS="jsp/main_page.jsp";
    private List<User> userlst;
     private String addUserName;
    private  boolean flag;

    public List<User> getUserlst() {
        return userlst;
    }
    public void setUserlst(List<User> userlst) {
           this.userlst = userlst;

       }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @DefaultHandler
    public Resolution pre(){
        
        return new ForwardResolution(LOGIN);
    }

    public Resolution login(){
        if(userDao.authenticate(user)){
        return new ForwardResolution(SUCCESS);    
        }

        else
            return new RedirectResolution(getContext().getSourcePage());
    }
    
}
