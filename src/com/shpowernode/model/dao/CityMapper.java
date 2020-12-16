package com.shpowernode.model.dao;

import com.shpowernode.entity.City;

import java.util.List;

/**     
           
* @ProjectName:    ssm
      
* @Package:        com.shpowernode.model.dao
           
* @Description:     java类作用描述 
      
* @Author:         李文瑞     
* @CreateDate:     2020/12/7 21:56
            
* @Version:        1.0
      
* Copyright: Copyright (c) 2020      
*
      
*/
public interface CityMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cid);

    List<City> selectAll();

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}