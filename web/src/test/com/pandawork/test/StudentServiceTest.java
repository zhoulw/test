package test;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by zhoulw on 2016/4/6.
 */
public class StudentServiceTest extends AbstractTestCase{
    @Autowired
    private StudentService studentService;

    @Test
    public  void checkStudentNumber() throws SSException {
        studentService.checkStudentNumber("1");
    }

    @Test
    public  void newStudent() throws SSException {
        Student student = new Student();
        student.setStudentNumber("201405");
        student.setClassNumber("123");
        student.setPassword("123");
        student.setName("ma");
        student.setBirthday(new Date());
        student.setSex("1");
        student.setCollege("软件");
        student.setGrade(2);
        studentService.newStudent(student);
    }
}
