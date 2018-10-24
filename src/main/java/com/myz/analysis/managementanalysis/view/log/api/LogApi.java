package com.myz.analysis.managementanalysis.view.log.api;

import com.myz.analysis.managementanalysis.view.log.service.LogEntity;
import com.myz.analysis.managementanalysis.view.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:32
 * @Description:
 */
@Controller
@RequestMapping("/log")
public class LogApi {
    @Autowired
    private LogService service;

    @RequestMapping("/save")
    @ResponseBody
    public LogEntity save(LogEntity entity) {
        return service.save(entity);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Page<LogEntity> findAll(@PageableDefault(sort = {"date"} , direction = Sort.Direction.DESC) Pageable pageable){
        return service.findAll(pageable);
    }
}
