package com.shpowernode.entity;

/**     
           
* @ProjectName:    ssm
      
* @Package:        com.shpowernode.entity
           
* @Description:     java类作用描述 
      
* @Author:         李文瑞     
* @CreateDate:     2020/12/14 8:46
            
* @Version:        1.0
      
* Copyright: Copyright (c) 2020      
*
      
*/
public class Teacher {
    /**
    * 教师id
    */
    private Integer teaId;

    /**
    * 教师姓名
    */
    private String teaName;

    /**
    * 教师年龄int
    */
    private Integer teaAge;

    /**
    * 教师性别varchar
    */
    private String teaSex;

    private String teaAgeBegin;
    private String teaAgeEnd;

    public String getTeaAgeEnd() {
        return teaAgeEnd;
    }

    public void setTeaAgeEnd(String teaAgeEnd) {
        this.teaAgeEnd = teaAgeEnd;
    }

    public String getTeaAgeBegin() {
        return teaAgeBegin;
    }

    public void setTeaAgeBegin(String teaAgeBegin) {
        this.teaAgeBegin = teaAgeBegin;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teaId=").append(teaId);
        sb.append(", teaName=").append(teaName);
        sb.append(", teaAge=").append(teaAge);
        sb.append(", teaSex=").append(teaSex);
        sb.append("]");
        return sb.toString();
    }
}