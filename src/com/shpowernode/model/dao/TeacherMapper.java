package com.shpowernode.model.dao;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Teacher;

import java.util.List;

/**     
           
* @ProjectName:    ssm
      
* @Package:        com.shpowernode.model.dao
           
* @Description:     java类作用描述 
      
* @Author:         李文瑞     
* @CreateDate:     2020/12/14 8:46
            
* @Version:        1.0
      
* Copyright: Copyright (c) 2020      
*
      
*/
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teaId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teaId);

    int updateByPrimaryKeySelective(Teacher record);

    List<Teacher> selectAll();
//总记录数算不出来，只能查，所以写sql语句
    int selectCount();



    List<Teacher> selectByPages(Pages page);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> selectByTeacher(Teacher teacher);

    int deleteBatch(Integer[]teaIds);
}