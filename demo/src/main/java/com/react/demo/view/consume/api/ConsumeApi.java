package com.react.demo.view.consume.api;

import com.react.demo.view.base.BaseApi;
import com.react.demo.view.base.BaseService;
import com.react.demo.view.consume.service.ConsumePo;
import com.react.demo.view.consume.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mayanze
 * @Date: 2018/9/27 11:11
 * @Description:
 */
@RestController
@RequestMapping("/consume")
public class ConsumeApi extends BaseApi<ConsumePo> {

    @Autowired
    private ConsumeService service;

    @Override
    public BaseService<ConsumePo> service() {
        return service;
    }
}
