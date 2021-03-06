package com.react.demo.view.income.service;

import com.react.demo.view.base.BaseRepository;
import com.react.demo.view.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: mayanze
 * @Date: 2018/10/10 18:33
 * @Description:
 */
@Service
public class IncomeServiceImpl extends BaseServiceImpl<IncomePo> implements IncomeService{
    @Autowired
    private IncomeRepository repository;

    @Override
    public BaseRepository<IncomePo> repository() {
        return repository;
    }
}
