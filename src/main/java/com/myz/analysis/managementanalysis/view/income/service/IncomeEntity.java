package com.myz.analysis.managementanalysis.view.income.service;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: mayanze
 * @Date: 2018/9/27 11:12
 * @Description:  工资
 */
@Entity
@Table(name = "income_t")
public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private Float   money;
    private Date date;
    private String  remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
    @Column(columnDefinition = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
