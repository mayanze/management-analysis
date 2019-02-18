package com.react.demo.view.income.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/9/27 11:24
 * @Description:
 */
@Repository
public interface IncomeRepository extends JpaRepository<IncomePo,Long> {
    @Query("select t.createTime, t.money from IncomePo t")
    List<IncomePo> findDateAndMoney();
}
