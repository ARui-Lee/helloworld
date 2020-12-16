package com.shpowernode.model.service.impl;

import com.shpowernode.entity.City;
import com.shpowernode.model.dao.CityMapper;
import com.shpowernode.model.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.model.service.impl
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/8 9:17
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class CityService implements ICityService {
    @Autowired
    CityMapper cityMapper ;

    @Override
    public List<City> list() {
        return cityMapper.selectAll();
    }
}
