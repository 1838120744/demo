package com.yjcloud.chatroom.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjcloud.chatroom.demo.mapper.StudentMapper;
import com.yjcloud.chatroom.demo.model.Student;
import com.yjcloud.chatroom.demo.util.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;
    @ResponseBody
    @RequestMapping("/list")
    public ServerResponse list(@RequestParam(value = "page",required = false)Integer page, @RequestParam(value = "limit",required = false)Integer limit){
        log.info("list");
        PageHelper.startPage(page,limit);//pageNum：当前页数   pageSize：当前页需要显示的数量
        List<Student> list=studentMapper.findAll();//PageHelper后面必须紧跟查询
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return ServerResponse.layui(pageInfo.getList(),pageInfo.getTotal());
    }
    @RequestMapping("/go_update")
    @ResponseBody
    public ServerResponse update(@RequestBody @Validated Student student){
        ServerResponse serverResponse=ServerResponse.success();
        System.out.println(student.getName());
        try {
            studentMapper.updateStudent(student);
            serverResponse.setMsg("修改成功");
        }catch (Exception e){
            serverResponse.setMsg(e.getMessage());
        }
        return serverResponse;
    }
    @RequestMapping("/add")
    public String add(){
        return "/updateStudent";
    }
    @RequestMapping("/search")
    @ResponseBody
    public ServerResponse search(@RequestParam Integer search,@RequestParam String type){
        List<Student> list=studentMapper.findByIdLike("%"+search+"%");
        log.info(String.valueOf(list.size()));
        return ServerResponse.layui(list,(long)list.size());
    }
    @RequestMapping("/go_add")
    @ResponseBody
    public ServerResponse go_add(@RequestBody @Validated Student student){
        ServerResponse serverResponse=ServerResponse.success();
        try {
            studentMapper.addStudent(student);
            serverResponse.setMsg("添加成功");
        }catch (Exception e){
            serverResponse.setMsg(e.getMessage());
        }
        return serverResponse;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public ServerResponse delete(@RequestParam(value = "id")Integer id){
        ServerResponse serverResponse=ServerResponse.success();
        try {
            studentMapper.deleteStudentById(id);
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
        System.out.println("edit:"+id);
            Student student=studentMapper.findById(id);
            modelAndView.addObject("student",student);
            modelAndView.setViewName("/updateStudent");
        return modelAndView;
    }
}
