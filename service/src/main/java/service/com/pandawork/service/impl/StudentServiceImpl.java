package com.pandawork.service.impl;

import com.pandawork.common.entity.Student;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.StudentMapper;
import com.pandawork.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoulw on 2016/4/6.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    @Qualifier("commonDao")//commonDao别名
    private CommonDao commonDao;


    @Override
    public Student queryById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return studentMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void newStudent(@Param("student") Student student) throws SSException {
        if (Assert.isNull(student)) {
            return ;
        }

        Assert.isNotNull(student.getStudentNumber(), NFException.StudentNumberNotNull);
        Assert.isNotNull(student.getPassword(), NFException.PasswordNotNull);

        try {
            student.setPassword(CommonUtil.md5(student.getPassword()));
            studentMapper.newStudent(student);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void update(@Param("student") Student student) throws SSException {
        if (Assert.isNull(student)) {
            return ;
        }

        // 判断用户名和密码是否为空
       Assert.isNotNull(student.getStudentNumber(), NFException.StudentNumberNotNull);
        Assert.isNotNull(student.getPassword(), NFException.PasswordNotNull);

        try {
            studentMapper.update(student);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void deleteById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return ;
        }

        try {
            studentMapper.deleteById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Student> listAll() throws SSException {
        try {
            return studentMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }



    /*    @Override
        public boolean checkLogin(User user) throws SSException {
            if (Assert.isNull(user)) {
                return false;
            }

            try {
                user.setPassword(CommonUtil.md5(user.getPassword()));
                return userMapper.countByUserNameAndPassword(user.getUserName(), user.getPassword()) > 0 ? true : false;
            } catch (Exception e) {
                LogClerk.errLog.error(e);
                throw SSException.get(NFException.SystemException, e);
            }
        }*/
    @Override
    public Student queryByStudentNumber( String studentNumber) throws Exception {


        try {
            return studentMapper.queryByStudentNumber(studentNumber);

        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
    @Override
    public boolean checkIndepw(String studentNumber,String indepw) throws SSException {
        try {
            if(studentMapper.queryIndepw(studentNumber).equals(indepw)){
                return true;
            }
            else{return false;}
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public boolean checkLogin(Student student) throws SSException {
        return false;
    }

   @Override
   public boolean checkStudentNumber(String studentNumber) throws SSException {
       try {

           return studentMapper.countByStudentNumber(studentNumber)>0?true:false;
       } catch (Exception e) {
           LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
