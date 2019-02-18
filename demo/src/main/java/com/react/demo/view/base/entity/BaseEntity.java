package com.react.demo.view.base.entity;

import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/9/20 08:39
 * @Description: 基类实体(目前主要作用是aop放入当前时间)
 */
public interface BaseEntity {

     Date getDate();

     void setDate(Date date);
}
