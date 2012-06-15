package com.inwise.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.Validate;
import com.inwise.pojo.User;
import com.inwise.security.MyActionBeanContext;
import com.inwise.utils.PasswordEncryptor;
import com.inwise.dao.UserDao;
import com.inwise.dao.implementation.UserDaoImpl;
import com.google.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: Milind
 * Date: Feb 9, 2012
 * Time: 10:43:32 AM
 * To change this template use File | Settings | File Templates.
 */


public class BaseActionBean implements ActionBean{
    private MyActionBeanContext context;

    public MyActionBeanContext getContext() {
        return context;
    }
    public void setContext(ActionBeanContext context) {
        this.context = (MyActionBeanContext) context;
    }

    @ValidateNestedProperties({
            @Validate(field="username",on="login", required =true, label = "Username"),
            @Validate(field="password",on="login", required = true, label = "Password")
    })

    public User user;


    @Inject protected UserDaoImpl userDao;
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        if(id != 0) {

            return userDao.find(id);
        }

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
