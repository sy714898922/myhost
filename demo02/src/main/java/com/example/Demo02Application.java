package com.example;


import com.example.demo02.User;
import com.example.demo02.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@SpringBootApplication
public class Demo02Application {

    @Autowired
    private UserService service;

    public static void main(String[] args) {
        SpringApplication.run(Demo02Application.class, args);
    }

    @RequestMapping("/hello")
    //参数pageNum为当前页数，默认为第一页
    public String hello2(Model model, @RequestParam(value="pageNum",defaultValue = "1") String pageNum){
        int n=Integer.parseInt(pageNum);
        //参数（n，size） 第几页，每个页面上几个数据
        List<User> users=service.getAllUser(n,2);
        //pageInfo里面有各种分页信息
        PageInfo<User> of = PageInfo.of(users);
        int pages=of.getPages();
        //将数据和分页信息返回html
        model.addAttribute("users",users);
        model.addAttribute("pageNum",n);
        model.addAttribute("totalPages",pages);

        return "hel/hello";
    }
}
