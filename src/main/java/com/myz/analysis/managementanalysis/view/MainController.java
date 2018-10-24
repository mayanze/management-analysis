package com.myz.analysis.managementanalysis.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: mayanze
 * @Date: 2018/9/15 17:22
 * @Description:
 */
@Controller
public class MainController {
    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/list")
    public String list(){
        return "/log/web/list";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "/log/web/edit";
    }

    @RequestMapping("/Layout")
    public String Layout(){
        return "/example/Layout";
    }
}
