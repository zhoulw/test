package com.pandawork.mapper;

import com.pandawork.common.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/*
 **
 * studentMapper
 *
 */
public interface StudentMapper {



    public void newStudent( @Param("student") Student student) throws Exception;

    public void update(@Param("student") Student student) throws Exception;

    public Student queryById(@Param("id") int id) throws Exception;

    public void deleteById(@Param("id") int id) throws Exception;

    public List<Student> listAll() throws Exception;

    public String queryIndepw(@Param("studentNumber")String studentnumber)  throws Exception;

    public Student queryByStudentNumber(String studentNumber) throws Exception;

    public int countByStudentNumber(@Param("studentNumber") String studentNumber) throws Exception;
}


