package com.pandawork.web.controller;
import com.pandawork.web.spring.AbstractController;
import com.sun.deploy.net.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * user: mayuan
 * date: 2016/3/27
 * time: 10:18
 **/
@Controller
@RequestMapping(value = "/")
@SessionAttributes("uid")
public class testController  extends AbstractController {

    @RequestMapping(value="/")
    public  String toTest(){
        return "regester";

    }

    @RequestMapping(value = {"/test1","/test/1"})
    public String test1(Model model){
        model.addAttribute("message","test1");
        return "message";
    }


    @RequestMapping(value = "/test2/{id}")
    public String test2(Model model,@PathVariable("id")int uid){
        model.addAttribute("key",uid);
        model.addAttribute("message","test2");
        return "message";
    }

    @RequestMapping(value = "/test3")
    public String test3(Model model){
        //model.addAttribute("key",uid);
        model.addAttribute("message","test3");
        return "message";
    }


    @RequestMapping(value = "/toform",method = RequestMethod.GET)
    public String TOfORM(){

        return "form";
    }



    @RequestMapping(value = "/test4",method = RequestMethod.POST)
    public String test4(@ModelAttribute("uid") int id, Model model){

        model.addAttribute("key",id);
        model.addAttribute("message","test4");
        return "message";
    }


    @RequestMapping(value = "/test5",params = "!userName",method = RequestMethod.GET)
    public String test5(Model model){

        model.addAttribute("message","test5");
        return "message";
    }

}
