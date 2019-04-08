package com.react.demo.view.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/9/20 08:39
 * @Description: 基类实体(目前主要作用是aop放入当前时间)
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     public long id;
     public String creator;
     @Temporal(TemporalType.DATE)
     public Date createTime;
     public String remark;
}
