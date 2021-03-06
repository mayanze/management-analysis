package com.react.demo.view.income.api;

import com.react.demo.view.base.BaseApi;
import com.react.demo.view.base.BaseService;
import com.react.demo.view.income.service.IncomePo;
import com.react.demo.view.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mayanze
 * @Date: 2018/9/27 11:11
 * @Description:
 */
@RestController
@RequestMapping("/income")
public class IncomeApi extends BaseApi<IncomePo> {

    @Autowired
    private IncomeService service;

    @Override
    public BaseService<IncomePo> service() {
        return service;
    }
}
