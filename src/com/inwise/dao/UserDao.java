package com.inwise.dao;

import com.inwise.pojo.User;

import java.util.List;

/**                                         
 * Created by IntelliJ IDEA.
 * User: Minal
 * Date: Feb 14, 2012
 * Time: 12:47:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao{
    public boolean authenticate(User user);
}
