package com.shpowernode.entity;

/**     
           
* @ProjectName:    ssm
      
* @Package:        com.shpowernode.entity
           
* @Description:     java类作用描述 
      
* @Author:         李文瑞     
* @CreateDate:     2020/12/7 21:56
            
* @Version:        1.0
      
* Copyright: Copyright (c) 2020      
*
      
*/
public class City {
    private Integer cid;

    private String cname;

    private Integer pid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", cname=").append(cname);
        sb.append(", pid=").append(pid);
        sb.append("]");
        return sb.toString();
    }
}