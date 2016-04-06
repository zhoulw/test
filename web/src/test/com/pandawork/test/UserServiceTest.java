package test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceTest
 *
 * @author: mayuan
 * @time: 2015/8/24 20:02
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void queryById() throws SSException {

        userService.deleteById(11);
    }

    @Test
    public void newUser() throws SSException {
        User user = new User();
        user.setUserName("pig");
        user.setPassword("pig");
        userService.newUser(user);
    }

    @Test
    public  void checkLogin() throws SSException{
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        if(userService.checkLogin(user))
       System.out.print("yyyyyyy");
    }

    @Test
    public  void listAll() throws SSException{
       System.out.print(userService.listAll().get(1).getUserName());
    }




}
