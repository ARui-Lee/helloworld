package com.shpowernode.controller;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Teacher;
import com.shpowernode.model.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.controller
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/14 9:00
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    @RequestMapping("list")
    public List<Teacher> list(Pages page,Teacher teacher){

//        return teacherService.selectByTeacher(teacher);
        return teacherService.selectAll(page);
    }

    @RequestMapping("edit")
    public Teacher edit( Teacher teacher,Integer teaId){
        if (teaId != null){
            return teacherService.selectByPrimaryKey(teaId);
        }
        return null;
    }

    @RequestMapping("editDB")
    public String editDB( Teacher teacher,Integer teaId){
        if (teaId!=null){
            teacherService.update(teacher);
        }else{
            teacherService.insertInto(teacher);
        }
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String del(Integer teaId){
        teacherService.delete(teaId);
        return "redirect:list";
    }

    @RequestMapping("deleteBatch")
    public String deleteBatch(Integer[] teaIds){
        if (teaIds.length!=0 && teaIds!=null){
            teacherService.deleteBatch(teaIds);
        }
        return "redirect:list";
    }
}
