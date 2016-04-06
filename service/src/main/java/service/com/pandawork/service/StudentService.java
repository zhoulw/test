package com.pandawork.service;

import com.pandawork.common.entity.Student;
import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by zhoulw on 2016/4/6.
 */
public interface StudentService {

    public void newStudent(Student student) throws SSException;

    public void update( Student student) throws SSException;

    public void deleteById( int id) throws SSException;

    public boolean checkIndepw(String studentNumber,String indepw) throws  SSException;
    public List<Student> listAll() throws SSException;
    public Student queryById( int id) throws SSException;
    public Student queryByStudentNumber( String studentNumber) throws Exception;
    public boolean checkLogin(Student student) throws SSException;
    public boolean checkStudentNumber(String name) throws SSException;

}
