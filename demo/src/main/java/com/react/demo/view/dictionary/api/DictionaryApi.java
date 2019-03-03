package com.react.demo.view.dictionary.api;


import com.alibaba.fastjson.JSON;
import com.react.demo.util.ResultMapUtil;
import com.react.demo.view.dictionary.service.DictionaryPo;
import com.react.demo.view.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @Auther: mayanze
 * @Date: 2018/9/14 23:32
 * @Description:
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryApi {
    @Autowired
    private DictionaryService service;

    @RequestMapping("/save")
    public DictionaryPo save(String data) {
        DictionaryPo entity = JSON.parseArray(data,DictionaryPo.class).get(0);
        return service.save(entity);
    }

    @RequestMapping("/findById")
    public Optional<DictionaryPo> findById(Long id){
        Optional<DictionaryPo> entity = service.findById(id);
        return entity;
    }
    @RequestMapping("/deleteById")
    public void deleteById(Long... id) {
        service.deleteById(id);
    }

    @RequestMapping("/findAll")
    public Map findAll(DictionaryPo logEntity, String sortField, String sortOrder, @PageableDefault(sort = {"createTime"} , direction = Sort.Direction.DESC) Pageable pageable){
        Page<DictionaryPo> page = null;
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
