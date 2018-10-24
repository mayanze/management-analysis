package com.myz.analysis.managementanalysis.view.log.service;

import com.myz.analysis.managementanalysis.base.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 资产管理日志（前期好多东西没来的及做，先存到这里）
 * strategy = GenerationType.IDENTITY 根据数据库自增
 * strategy = GenerationType.AUTO 程序自增
 * 两者区别：比如数据库手动添加一条数据id自增了一个变成1
 * 前者可以根据数据库当前情况自增会新增一条数据id变为2
 * 而后者还是会从1开始发现数据库有1了直接报错
 *
 * @Auther: mayanze
 * @Date: 2018/9/11 09:27
 */
@Table(name = "log_t")
@Entity
public class LogEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private Float   money;
    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "Date")
    private Date    date;
    private String  remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
