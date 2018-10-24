package com.myz.analysis.managementanalysis.view.income.service;

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
    public List<IncomeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<IncomeEntity> findDateAndMoney() {
        return repository.findDateAndMoney();
    }
}
