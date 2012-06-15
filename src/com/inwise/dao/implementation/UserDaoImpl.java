package com.inwise.dao.implementation;

import com.wideplay.warp.persist.Transactional;
import com.inwise.dao.BaseDao;
import com.inwise.dao.UserDao;
import com.inwise.pojo.User;

import java.util.List;

import org.hibernate.criterion.Restrictions;

/**
 * Created by IntelliJ IDEA.
 * User: Minal
 * Date: Feb 14, 2012
 * Time: 12:46:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl extends BaseDao<User,Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    public boolean authenticate(User user){
        if(sessionProvider.get().createCriteria(User.class).add(Restrictions.eq("username",user.getUsername())).add(Restrictions.eq("password",user.getPassword())).uniqueResult()!=null){
            return true;
        }
        return false;
    }
}



