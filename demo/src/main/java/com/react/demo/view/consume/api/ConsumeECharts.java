package com.react.demo.view.consume.api;

import com.react.demo.view.consume.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mayanze
 * @Date: 2018/10/10 18:29
 * @Description: ECharts 展示数据
 */
@RestController
@RequestMapping("incomeECharts")
public class ConsumeECharts {

    @Autowired
    private ConsumeService service;

//    @RequestMapping("/findEChartsData")
//    public List<ConsumePo> findEChartsData(){
//        return service.findDateAndMoney();
//    }
}
