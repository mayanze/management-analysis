package com.react.demo.view.income.service;


import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/10/10 18:31
 * @Description:
 */
public interface IncomeService {
    List<IncomePo> findAll();

    List<IncomePo> findDateAndMoney();
}
