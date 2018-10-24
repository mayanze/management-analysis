package com.myz.analysis.managementanalysis.view.income.api;

import com.myz.analysis.managementanalysis.view.income.service.IncomeEntity;
import com.myz.analysis.managementanalysis.view.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/10/10 18:29
 * @Description: ECharts 展示数据
 */
@RestController
@RequestMapping("incomeECharts")
public class IncomeECharts {

    @Autowired
    private IncomeService service;

    @RequestMapping("/findEChartsData")
    public List<IncomeEntity> findEChartsData(){
        return service.findDateAndMoney();
    }
}
