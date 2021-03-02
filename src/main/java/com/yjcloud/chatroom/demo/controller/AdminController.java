package com.yjcloud.chatroom.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yjcloud.chatroom.demo.mapper.AdminMapper;
import com.yjcloud.chatroom.demo.model.Admin;
import com.yjcloud.chatroom.demo.util.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class AdminController {
    @Autowired
    private HttpServletRequest request;
    @Resource
    private AdminMapper adminMapper;
    @RequestMapping("/logout")
    public  ModelAndView  logout(){
        ModelAndView modelAndView=new ModelAndView();
        HttpSession session=request.getSession();
        if (session != null) {
            session.invalidate();//调用session的invalidate()方法，将保存的session删除
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/go_login")
    public ServerResponse go_login(String name, String psw,HttpServletRequest request)throws Exception {
        psw=new Md5Hash(psw,"java").toString();
        List<Admin> list=adminMapper.findByNameAndPsw(name,psw);
        try {
            Admin admin=list.get(0);
            log.info(admin.getName()+" "+admin.getPsw());
            HttpSession session = request.getSession();
            session.setAttribute("user",admin);
            return ServerResponse.success();
        }catch (Exception e) {
            return ServerResponse.fail(e.getMessage());
        }
    }
    @RequestMapping("/student")
     public String student(){
        return "/student";
    }
    @RequestMapping("/updateStudent")
    public String updateStudent(){
        return "/updateStudent";
    }
    @RequestMapping("/teacher")
    public String teacher(){
        return "/teacher";
    }
    @RequestMapping("/updateTeacher")
    public String updateTeacher(){
        return "/updateTeacher";
    }
    @RequestMapping("/chatroom")
    public ModelAndView webSocket(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/index");
        Admin user = (Admin) request.getSession().getAttribute("user");
        modelAndView.addObject("nickname",user.getName());
        return modelAndView;
    }
}
