package com.shpowernode.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.entity
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/10 17:16
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class Student {
    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生性别（0代表男，1代表女）
     */
    private String stuSex;

    /**
     * 学生状态（0代表离校，1代表在校）
     */
    private String stuStatus;

    /**
     * 学生年龄
     */
    private Integer stuAge;

    /**
     * 学生入学日期
     */
    private String stuDate;

    private Integer teaId;

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    private Integer stuAgeBegin;
    private Integer stuAgeEnd;
    private String stuDateBegin;
    private String stuDateEnd;

    public Integer getStuAgeBegin() {
        return stuAgeBegin;
    }

    public void setStuAgeBegin(Integer stuAgeBegin) {
        this.stuAgeBegin = stuAgeBegin;
    }

    public Integer getStuAgeEnd() {
        return stuAgeEnd;
    }

    public void setStuAgeEnd(Integer stuAgeEnd) {
        this.stuAgeEnd = stuAgeEnd;
    }

    public String getStuDateBegin() {
        return stuDateBegin;
    }

    public void setStuDateBegin(String stuDateBegin) {
        this.stuDateBegin = stuDateBegin;
    }

    public String getStuDateEnd() {
        return stuDateEnd;
    }

    public void setStuDateEnd(String stuDateEnd) {
        this.stuDateEnd = stuDateEnd;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuDate() {
        return stuDate;
    }

    public void setStuDate(String stuDate) {
        this.stuDate = stuDate;
    }
}