package com.inwise.guice;

import com.google.inject.AbstractModule;
import com.inwise.dao.UserDao;
import com.inwise.dao.implementation.UserDaoImpl;

/**
 * Created by IntelliJ IDEA.
 * User: Ashay
 * Date: Jan 23, 2012
 * Time: 10:50:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class InwiseModule extends AbstractModule{

    @Override
    protected void configure() {
        
         bind(UserDao.class).to(UserDaoImpl.class);
    }
}
