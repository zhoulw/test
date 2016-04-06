package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.jar.Attributes;

/**
 * student
 */
@Table(name = "t_student")
@Entity
public class Student extends AbstractEntity {
    @Id
    private Integer id;

    @Column(name = "student_num")
    private String studentNumber;

    private String name;
    private String sex;
    private Integer grade;

    @Column(name="is_good_student")
    private Integer isGoodStudent;

    private String password;

    @Column(name = "class_num")
    private String classNumber ;

    private String college;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getIsGoodStudent() {
        return isGoodStudent;
    }

    public void setIsGoodStudent(Integer isGoodStudent) {
        this.isGoodStudent = isGoodStudent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
