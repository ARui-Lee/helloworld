package com.shpowernode.model.dao;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.model.dao
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/10 17:16
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

    //分页
    List<Student> selectByPages(Pages page);

    List<Student> selectByStudent(Student student);

    int deleteBatch(Integer[] stuIds);
}