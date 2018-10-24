package com.myz.analysis.managementanalysis.base.entity;

import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/9/20 08:39
 * @Description: 基类实体(目前主要作用是aop放入当前时间)
 */
public interface BaseEntity {

    public Date getDate();

    public void setDate(Date date);
}
