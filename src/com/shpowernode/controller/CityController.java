package com.shpowernode.controller;

import com.shpowernode.entity.City;
import com.shpowernode.model.service.ICityService;
import com.shpowernode.model.service.impl.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.controller
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/8 9:23
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
@RequestMapping("city")
public class CityController {

    /**
     * namespace和action
     * namespace  @RequestMapping(“”) 写在类前称为namespace 可以没有
     * action    @RequestMapping(“”)  写在方法前称为action 必须有
     */
    @Autowired
    ICityService cityService;

    /**
     * 1.接收请求参数
     *
     * 2.调用模型层（Service）
     *
     * 3.在作用域中放值
     *
     * 4.响应用户（请求转发，重定向，下载，json）   /=根目录
     */


    /**
     * 1.使用servlet api处理
     */
   /* @RequestMapping("list")
    void list(HttpServletRequest req, HttpServletResponse resp) throws  Exception{
        //1.接收请求参数（这里没有请求，所以不需要接收）
        //String id = req.getParameter("id");

        //2.调用模型层
        List<City> list = cityService.list();

        //3.往作用域中放值
        req.setAttribute("cityList",list);

        //4.请求响应（这里使用转发，因为带有请求参数，需要将查询结果返回）
        req.getRequestDispatcher("/pages/list.jsp").forward(req,resp);
    }*/

    /**
     * 2.使用ModelAndView
     */
   /* @RequestMapping("list")
    ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();

        //2.调用模型层
        List<City> list = cityService.list();

        //3.往作用域中放值
        modelAndView.addObject("cityList",list);

        //4.请求响应
        modelAndView.setView(new InternalResourceView("/pages/list.jsp"));

        //modelAndView.setView(new RedirectView("http://baidu.com"));
        //modelAndView.setView(new RedirectView("/user/edit?id="));//可以出应用，默认就是出应用的
        //modelAndView.setView(new RedirectView("/user/edit?id=1",true));// http://localhost:8080/ssm/user/edit?id=1

        modelAndView.setViewName("list")
        return modelAndView;
    }*/

    /**
     * 3.返回视图的名称  视图名称：被视图解析器的前缀和后缀包夹的字符串
     */
   /* @RequestMapping("list")
    String list(ArrayList<City> cities){
        //2.调用模型层
        List<City> list = cityService.list();

        cities.addAll(list);
        //3.往作用域放值(reqeust,session)   req.setAttribute("cityList",list);
        return "list";//  /pages/list.jsp
    }*/


    /**
     * 4.返回视图的名称
     */
    /*@RequestMapping("list")
    String list(Map<String,Object> map){
        //2.调用模型层
        List<City> list = cityService.list();
        //3.往作用域放值(reqeust,session)
        // req.setAttribute("cityList",list);
        map.put("cityList",list);

        return "list";
    }*/

    /**
     * 5.使用约定
     */
   /* @RequestMapping("list")
    void  list(Map<String ,Object> map){
        //2.调用模型层
        List<City> list = cityService.list();
        //3.往作用域放值
        map.put("cityList",list);
        //4.请求转发,约定: 当没有指明要做何种响应的时候，默认请求转发到 视图解析器的前辍 + namespace + action + 视图解析器的后辍

        //   /pages/city/list.jsp
    }*/

    /**
     * 6.使用约定
     * @param cities
     */
   /* @RequestMapping("list")
    void  list(ArrayList<City> cities){
        //2.调用模型层
        List<City> list = cityService.list();
        //3.往作用域放值
        //City city  = xxxx;

        //list  = listDB;

        cities.addAll(list); // req.setAttribute("cityList",list); //attributeName默认是按照类型做推断：cityList   city
        //4.请求转发,约定: 当没有指明要做何种响应的时候，默认请求转发到 视图解析器的前辍 + namespace + action + 视图解析器的后辍

        //   /pages/city/list.jsp
    }*/

      /**
      * 7.使用约定
      * */
      /*@RequestMapping("list")
      List<City> list(){// cityList

      return cityService.list();//2.调用模型层    返回值默认是要进入到request的attrubte(request.setAttrubute())
      }*/

    /**
     * 8.使用约定
     */
    @RequestMapping("list")
    Map<String ,Object> list(){
        Map<String,Object> map = new HashMap<String,Object>();

        List<City> list = cityService.list();//2.调用模型层
        //3.往作用域放值
        map.put("cityList",list);//request.setAttrubute("cityList",list)
        //4.响应按约定走
        return map;


    }











}
