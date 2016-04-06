package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 *
 * @author: mayuan
 * @time: 2015/3/26 19:25
 */
public interface UserService {

    public void newUser( User user) throws SSException;

    public void update( User user) throws SSException;

    public void deleteById( int id) throws SSException;
    public boolean checkIndepw(String userName,String indepw) throws  SSException;
    public List<User> listAll() throws SSException;
    public User queryById( int id) throws SSException;
    public User queryByUserName( String userName) throws Exception;
    public boolean checkLogin(User user) throws SSException;
    public boolean checkUserName(String name) throws SSException;
}
