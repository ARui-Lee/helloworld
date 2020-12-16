package com.shpowernode.controller;

import com.shpowernode.entity.Pages;
import com.shpowernode.entity.Student;
import com.shpowernode.entity.Teacher;
import com.shpowernode.model.service.IStudentService;
import com.shpowernode.model.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.controller
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/8 17:06
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;

    @RequestMapping("list")
    List<Student> list(Pages page, ArrayList<Teacher> teachers, Student student){

        teachers.addAll(teacherService.selectAll());
//        return studentService.list();
        //springMVC中向请求域中传值时，如果没有指定传入参数的名称，参数类型为list则默认后缀为list，而list中装的是student对象，前缀就为student，总成studentList
        return studentService.list(page);
    }

    /*@RequestMapping("add")
    void add(){

    }*/

   /* @RequestMapping("save")
    String save(Student student){
        studentService.save(student);
        return "redirect:list"
    }
*/
    @RequestMapping("edit")
    List<Teacher> edit(Student student,Integer stuId){//Integer可以是null,int不能是null.如果

        if (stuId !=null){

            Student studentDB = studentService.get(stuId);
            //对象赋值的方法，将前一个参数的值赋值给后一个对象
            BeanUtils.copyProperties(studentDB,student);
            //(studentDB)source  源（从哪里来），(student)target 目标 (往哪里去)
        }
        return teacherService.selectAll();
    }

    @RequestMapping("del")
    String del(int stuId){
        studentService.delete(stuId);
        return "redirect:list";
    }

    @RequestMapping("saveUpdate")
    String edit1(Student student){
        if (student.getStuId()== null){
            studentService.save(student);
        }else{
            studentService.update(student);
        }
        return "redirect:list";
    }

    @RequestMapping("deleteBatch")
/**
 * 对数据库有影响，所以使用重定向，返回string类型
 */
    String deleteBatch(Integer[] stuIds){
        studentService.delete(stuIds);
        return "redirect:list";
    }



}
