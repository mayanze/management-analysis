package com.react.demo.view.income.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: mayanze
 * @Date: 2018/9/27 11:11
 * @Description:
 */
@Controller
@RequestMapping("/income")
public class IncomeApi {

    /**
     *
     * 跳转到编辑页面，有值带值，没值新增
     *
     * @auther mayanze
     * @date 2018/9/27 上午11:22
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model model) {
        return "income/edit";
    }
}
