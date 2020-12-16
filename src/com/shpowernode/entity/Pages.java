package com.shpowernode.entity;

/**
 * @ProjectName: ssm
 * @Package: com.shpowernode.entity
 * @Description: java类作用描述
 * @Author: 李文瑞
 * @CreateDate: 2020/12/15 19:44
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 *
 * 因为要实现翻页，limit（x，y）中x的值会变化，而mysql中不会自己计算x，
 * 所以要新建一个实体类，将x在实体类中算出后，传入mysql中进行分页查询
 * //守入口
 */
public class Pages {
    //当前页数
    private int no=1;

    //每页记录数
    private int pageNo=10;

    //起始数据号
    private int skipNo=0;

    //总页数  没有数据也能打开一页
    private int totalPageNo=1;

    //总记录
    private int totalRowCount=0;



    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;
        //重新计算总页数
        //守入口
        reCountTotalPageNo();
    }

    public int getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(int totalPageNo) {
        this.totalPageNo = totalPageNo;


    }


    /**
     * 计算起始行（数据）号的值
     *
     * @return
     */
    public void reCountSkipNo(){
        this.skipNo = (this.no - 1) * this.pageNo;
    }

    /**
     * 计算总页数= 总记录数/每页记录数
     * @return
     */
    public void reCountTotalPageNo(){
        //如果totalRowCount总记录数除pageNo除不尽，即有余数，则页码需要加一
        //方法一：先用*1.0使记录数变为double，然后使用math类的ceil()向上取整方法，将不为整数的结果+1
        this.totalPageNo = (int) Math.ceil(this.totalRowCount*1.0/this.pageNo);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
//        每次取当前页码都要重新计算起始行号
        reCountSkipNo();
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
//      如果更改每页记录数要重新计算起始行号
        reCountSkipNo();
    }

    public int getSkipNo() {
        return skipNo;
    }

    public void setSkipNo(int skipNo) {
        this.skipNo = skipNo;
    }
}
