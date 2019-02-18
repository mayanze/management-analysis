package com.react.demo.view.log.api;


import com.alibaba.fastjson.JSON;
import com.react.demo.util.ResultMapUtil;
import com.react.demo.view.log.service.LogEntity;
import com.react.demo.view.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:32
 * @Description:
 */
@RestController
@RequestMapping("/log")
public class LogApi {
    @Autowired
    private LogService service;

    @RequestMapping("/save")
    public LogEntity save(String data) {
        LogEntity entity = JSON.parseArray(data,LogEntity.class).get(0);
        return service.save(entity);
    }

    @RequestMapping("/findById")
    public Optional<LogEntity> findById(Long id){
        Optional<LogEntity> entity = service.findById(id);
        return entity;
    }
    @RequestMapping("/deleteById")
    public void deleteById(Long... id) {
        service.deleteById(id);
    }

    @RequestMapping("/findAll")
    public Map findAll(LogEntity logEntity,String sortField,String sortOrder, @PageableDefault(sort = {"date"} , direction = Sort.Direction.DESC) Pageable pageable){
        Page<LogEntity> page = null;
        if(!StringUtils.isEmpty(sortField)){
            int pageSize = pageable.getPageSize();
            int pageNumber = pageable.getPageNumber();
            Sort.Direction direction = null;
            switch (sortOrder){
                case "desc":
                    direction = Sort.Direction.DESC;
                    break;
                default:
                    direction = Sort.Direction.ASC;
            }
            Sort sort = new Sort(direction,sortField);
            PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
            page = service.findAll(logEntity,pageRequest);
        }else {
            page = service.findAll(logEntity,pageable);
        }
        return ResultMapUtil.getResultMap(page);
    }
}
