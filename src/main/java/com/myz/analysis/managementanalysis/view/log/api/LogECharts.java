package com.myz.analysis.managementanalysis.view.log.api;

import com.myz.analysis.managementanalysis.view.log.service.LogEntity;
import com.myz.analysis.managementanalysis.view.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: mayanze
 * @Date: 2018/10/11 19:05
 * @Description:
 */
@Controller
@RequestMapping("/logECharts")
public class LogECharts {
    @Autowired
    private LogService service;

    @RequestMapping("/forwardECharts")
    public String Layout(){
        return "log/ECharts/log";
    }

    @RequestMapping("/findEChartsData")
    public @ResponseBody List<LogEntity> findEChartsData(String month){
        return service.findDateAndMoney(month);
    }
}
