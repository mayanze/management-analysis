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
    @RequestMapping(value = {"/page/*","/page/*/*","/page/*/*/*"})
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

    @RequestMapping("/Layout")
    public String Layout(){
        return "/example/Layout";
    }
}
