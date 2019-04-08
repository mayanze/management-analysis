package com.react.demo.view.base;

import com.alibaba.fastjson.JSON;
import com.react.demo.util.ResultMapUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Optional;

public abstract class BaseApi<T> {

    public abstract BaseService<T> service();

    @RequestMapping("/save")
    public T save(String data,T t) {
        T entity = (T) JSON.parseArray(data,t.getClass()).get(0);
        return (T) service().save(entity);
    }

    @RequestMapping("/findById")
    public Optional<T> findById(Long id){
        Optional<T> entity = service().findById(id);
        return entity;
    }

    @RequestMapping("/findAll")
    public Map findAll(T logEntity, String sortField, String sortOrder, @PageableDefault(sort = {"createTime"} , direction = Sort.Direction.DESC) Pageable pageable){
        Page<T> page = null;
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
            page = service().findAll(logEntity,pageRequest);
        }else {
            page = service().findAll(logEntity,pageable);
        }
        return ResultMapUtil.getResultMap(page);
    }
}
