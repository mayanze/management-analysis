package com.react.demo.util;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auth mayanze
 * @date 2018/12/10
 */
public class ResultMapUtil {
    public static Map getResultMap(Page<?> page){
        List<?> data = page.getContent();
        int total = page.getTotalPages();
        Map resultMap = new HashMap();
        resultMap.put("total",total);
        resultMap.put("data",data);
        return resultMap;
    }
}
