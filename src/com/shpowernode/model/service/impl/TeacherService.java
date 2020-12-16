package com.shpowernode.model.service.impl;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Teacher;
import com.shpowernode.model.dao.TeacherMapper;
import com.shpowernode.model.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.model.service.impl
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/14 8:56
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class TeacherService implements ITeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    //查询全部
    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public List<Teacher> selectAll(Pages page) {
        //先计算出count总记录数，然后用set方法将算出的count传入page

        int count = teacherMapper.selectCount();
        page.setTotalRowCount(count);
        return teacherMapper.selectByPages(page);
    }

    //主键查询
    @Override
    public Teacher selectByPrimaryKey(int teaId) {
        return teacherMapper.selectByPrimaryKey(teaId);
    }



    //添加
    @Override
    public int insertInto(Teacher teacher) {
        return teacherMapper.insertSelective(teacher);
    }

    //删除
    @Override
    public int delete(int teaId) {
        return teacherMapper.deleteByPrimaryKey(teaId);
    }

    //更改
    @Override
    public int update(Teacher teacher) {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public List<Teacher> selectByTeacher(Teacher teacher) {
        return teacherMapper.selectByTeacher(teacher);
    }

    @Override
    public int deleteBatch(Integer[] teaIds) {
        return teacherMapper.deleteBatch(teaIds);
    }


}
