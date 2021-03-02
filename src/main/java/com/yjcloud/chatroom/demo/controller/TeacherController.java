package com.yjcloud.chatroom.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjcloud.chatroom.demo.mapper.TeacherMapper;
import com.yjcloud.chatroom.demo.model.Teacher;
import com.yjcloud.chatroom.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    @ResponseBody
    @RequestMapping("/list")
    public ServerResponse list(@RequestParam(value = "page",required = false)Integer page,@RequestParam(value = "limit",required = false)Integer limit){
        PageHelper.startPage(page,limit);
        List<Teacher> list=teacherMapper.findAll();
        PageInfo<Teacher> pageInfo=new PageInfo<Teacher>(list);
        return ServerResponse.layui(pageInfo.getList(),pageInfo.getTotal());
    }
    @RequestMapping("/go_update")
    @ResponseBody
    public ServerResponse update(@RequestBody @Validated Teacher teacher){
        ServerResponse serverResponse=ServerResponse.success();
        System.out.println(teacher.getName());
        try {
            teacherMapper.updateTeacher(teacher);
            serverResponse.setMsg("修改成功");
        }catch (Exception e){
            serverResponse.setMsg(e.getMessage());
        }
        return serverResponse;
    }
    @RequestMapping("/add")
    public String add(){
        return "/updateTeacher";
    }
    @RequestMapping("/go_add")
    @ResponseBody
    public ServerResponse go_add(@RequestBody @Validated Teacher teacher){
        ServerResponse serverResponse=ServerResponse.success();
        try {
            teacherMapper.addTeacher(teacher);
            serverResponse.setMsg("添加成功");
        }catch (Exception e){
            serverResponse.setMsg(e.getMessage());
        }
        return serverResponse;
    }
    @RequestMapping("/search")
    @ResponseBody
    public ServerResponse search(@RequestParam Integer search,@RequestParam String type){
        List<Teacher> list=teacherMapper.findByIdLike("%"+search+"%");
        return ServerResponse.layui(list,(long)list.size());
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse delete(@RequestParam(value = "id")Integer id){
        ServerResponse serverResponse=ServerResponse.success();
        try {
            teacherMapper.deleteTeacher(id);
            serverResponse.setMsg("删除成功");
        }catch (Exception e)
        {
            serverResponse.setMsg(e.getMessage());
        }
        return serverResponse;
    }
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id")Integer id){
        ModelAndView modelAndView=new ModelAndView();
        Teacher teacher=teacherMapper.findById(id);
        modelAndView.addObject("teacher",teacher);
        modelAndView.setViewName("/updateTeacher");
        return modelAndView;
    }
}
