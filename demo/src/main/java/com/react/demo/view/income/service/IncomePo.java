package com.react.demo.view.income.service;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @auth mayanze
 * @date 2019-02-11
 */
@Data
@Entity
@Table(name = "income_t")
public class IncomePo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long type;
  private double money;
  private String creator;
  private Date createTime;
  private Date modifyTime;
  private long version;
  private String remark;
  }
