package com.pandawork.web.controller;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/student")
public class StudentController extends AbstractController {

    @RequestMapping(value = "/listStudent" ,method = RequestMethod.GET)
    public String listStudent(Model model){
        try {
            List<Student> list = new ArrayList<Student>();
            list=studentService.listAll();
            model.addAttribute("studentList",list) ;
            return "studentList";
        } catch (SSException ee ){
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "delete" ,method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("id") int id){
        try {
            studentService.deleteById(id);
            return "redirect:/student/listStudent";
        } catch (SSException ee ){
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     *
     * @param student
     * @param password2
     * @param model
     * @return
     */
    @RequestMapping(value = "/new" ,method = RequestMethod.POST)
    public String newStudent(Student student, @RequestParam("date")String date,@RequestParam("password2")String password2, Model model) throws ParseException {
        try {
            String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
            Pattern pattern = Pattern.compile(rexp);
            Matcher matcher = pattern.matcher(date);
            if (!matcher.find()){
                model.addAttribute("message","生日格式不正确");
                return "regester";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            student.setBirthday(sdf.parse(date));
            if (!student.getPassword().equals(password2))
            {
                model.addAttribute("message","密码不一致");
                return "regester";
            }
            if (studentService.checkStudentNumber(student.getStudentNumber()))
            {
                model.addAttribute("message","学生已存在");
                return "regester";
            }
           student.setPassword(CommonUtil.md5(student.getPassword()));
            studentService.newStudent(student);
            model.addAttribute("message","success");
            return "successregister";
        } catch (SSException ee ){
            LogClerk.errLog.error(ee);
            sendErrMsg(ee.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
