package com.shpowernode.model.service;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Student;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.model.service
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/8 15:51
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface IStudentService {
    List<Student> list();

    Student get(int stuId);

    int save(Student student);

    int delete(int stuId);

    int update(Student student);

    List<Student> list(Student student);

    List<Student> list(Pages page);

    int delete(Integer[] stuId);

}
