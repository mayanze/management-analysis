package com.react.demo.view.base.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/9/20 08:39
 * @Description: 基类实体(目前主要作用是aop放入当前时间)
 */
@Data
@MappedSuperclass
public class BaseEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     public long id;
     public String creator;
     public Date createTime;
     public String remark;
}
