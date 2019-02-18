package com.react.demo.view.income.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/10/10 18:33
 * @Description:
 */
@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    private IncomeRepository repository;

    @Override
    public List<IncomePo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<IncomePo> findDateAndMoney() {
        return repository.findDateAndMoney();
    }
}
