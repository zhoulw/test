package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * user: mayuan
 * date: 2016/3/27
 * time: 20:04
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController extends AbstractController {

    @RequestMapping(value = "/listUser" ,method = RequestMethod.GET)
    public String listUser(Model model){
         try {
             List<User> list = new ArrayList<User>();
             list=userService.listAll();
                  model.addAttribute("userList",list) ;
             return "userList";
                 } catch (SSException ee ){
                     LogClerk.errLog.error(ee);
                     sendErrMsg(ee.getMessage());
                     return ADMIN_SYS_ERR_PAGE;
              }
    }



    @RequestMapping(value = "delete" ,method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") int id){
         try {
                 userService.deleteById(id);
             return "redirect:/user/listUser";
                 } catch (SSException ee ){
                     LogClerk.errLog.error(ee);
                     sendErrMsg(ee.getMessage());
                     return ADMIN_SYS_ERR_PAGE;
              }
    }

    /**
     *d登陆
     * @param user
     * @param password2
     * @param model
     * @return
     */
    @RequestMapping(value = "/new" ,method = RequestMethod.POST)
    public String newUser(User user, @RequestParam("password2")String password2, Model model){
        try {
            if (!user.getPassword().equals(password2))
            {
                model.addAttribute("message","密码不一致");
                return "form";
            }
            if (userService.checkUserName(user.getUserName()))
            {
                model.addAttribute("message","用户名已经存在");
                return "form";
            }
            user.setPassword(CommonUtil.md5(user.getPassword()));
            userService.newUser(user);
            model.addAttribute("message","success");
            return "message";
        } catch (SSException ee ){
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
