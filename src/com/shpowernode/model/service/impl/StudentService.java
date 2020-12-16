package com.shpowernode.model.service.impl;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Student;
import com.shpowernode.model.dao.StudentMapper;
import com.shpowernode.model.dao.TeacherMapper;
import com.shpowernode.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.model.service.impl
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/8 15:51
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("studentService")
public class StudentService implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        return studentMapper.selectAll();
    }



    @Override
    public Student get(int stuId) {
        return studentMapper.selectByPrimaryKey(stuId);
    }

    @Override
    public int save(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int delete(int stuId) {
        return studentMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    public int update(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public List<Student> list(Student student) {
        return studentMapper.selectByStudent(student);
    }


    @Override
    public List<Student> list(Pages page) {
        return studentMapper.selectByPages(page);
    }


    @Override
    public int delete(Integer[] stuId) {
        return studentMapper.deleteBatch(stuId);
    }


}
