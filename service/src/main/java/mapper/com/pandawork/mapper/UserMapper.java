package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/*
 **
 * UserMapper
 *
 * @author: mayuan
 * @time: 2015/8/26 16:57
 */
public interface UserMapper {



    public void newUser( User user) throws Exception;

    public void update(@Param("user") User user) throws Exception;

    public User queryById(@Param("id") int id) throws Exception;

    public void deleteById(@Param("id") int id) throws Exception;

    public List<User> listAll() throws Exception;

    public String queryIndepw(@Param("userName")String userName)  throws Exception;

    public User queryByUserName(String userName) throws Exception;

    public int countByUserName(@Param("userName") String userName) throws Exception;
}
