package com.shpowernode.model.service;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Teacher;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.model.service
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/14 8:48
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface ITeacherService {
    List<Teacher> selectAll();

    List<Teacher> selectAll(Pages page);
    Teacher selectByPrimaryKey(int teaId);

    int insertInto(Teacher teacher);

    int delete(int teaId);

    int update(Teacher teacher);

    List<Teacher>selectByTeacher(Teacher teacher);

    int deleteBatch(Integer[] teaIds);
}
