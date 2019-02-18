package com.react.demo.view.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: mayanze
 * @Date: 2018/9/15 17:22
 * @Description:
 */
@Controller
public class MainController {

    /**
     * 统一处理页面请求
     * @return
     */
    @RequestMapping("/page/*/*")
    public String mvc(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        requestURI = requestURI.substring(1,requestURI.length());
        return requestURI;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/pages/hello")
    public String test(){
        return "pages/hello";
    }

    @GetMapping("/pages/log")
    public String log(){
        return "log/list";
    }

    @GetMapping("/log/edit")
    public String edit(){
        return "page/log/edit";
    }

    @RequestMapping("/list")
    public String list(){
        return "/log/web/list";
    }

    @RequestMapping("/Layout")
    public String Layout(){
        return "/example/Layout";
    }
}
