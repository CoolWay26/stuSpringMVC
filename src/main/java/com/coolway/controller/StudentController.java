package com.coolway.controller;

import com.coolway.entity.Student;
import com.coolway.mapper.StudentMapper;
import javafx.scene.chart.ValueAxis;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentMapper studentMapper;

    //访问student列表页面
    @RequestMapping(value = "toStudentPage")
    public ModelAndView toStudentList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/studentList");
        modelAndView.addObject(new Student());
        return modelAndView;
    }

    //查找所有Student
    @RequestMapping(value = "autoShowAllStudent")
    public void autoShowAllStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Student> studentList = studentMapper.getAllStudent();
        JSONArray data = JSONArray.fromObject(studentList);
        //接下来发送数据
        /*设置编码，防止出现乱码问题*/
        response.setCharacterEncoding("utf-8");
        /*得到输出流*/
        PrintWriter respWritter = response.getWriter();
        /*将JSON格式的对象toString()后发送*/
        respWritter.append(data.toString());
    }

    //根据name或者clazz检索Student
    @RequestMapping(value = "showStudentByNameOrClazz")
    public void showStudentByNameOrClazz(String nameOrClazz, HttpServletResponse response) throws IOException {
        if (nameOrClazz != null && nameOrClazz != "") {
            List<Student> studentList = studentMapper.getStudentByNameOrClazz(nameOrClazz);

            if (studentList.size() > 0) {
                JSONArray data = JSONArray.fromObject(studentList);
                /*设置编码，防止出现乱码问题*/
                response.setCharacterEncoding("utf-8");
                /*得到输出流*/
                PrintWriter respWritter = response.getWriter();
                /*将JSON格式的对象toString()后发送*/
                respWritter.append(data.toString());
            }
        }


    }


    @RequestMapping(value = "/autoShowStudentList.action")
    public void showStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setId("0001");
        student.setName("张三");
        student.setClazz("1班");
        student.setSex("男");
        student.setAge(20);
        studentList.add(student);
        JSONArray data = JSONArray.fromObject(studentList);
        //接下来发送数据
        /*设置编码，防止出现乱码问题*/
        response.setCharacterEncoding("utf-8");
        /*得到输出流*/
        PrintWriter respWritter = response.getWriter();
        /*将JSON格式的对象toString()后发送*/
        respWritter.append(data.toString());
    }


    @RequestMapping(value = "toStudents.action")
    public ModelAndView toStudents() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        Student student2 = new Student();
        student.setId("0001");
        student.setName("张三");
        student.setClazz("1班");
        student.setSex("男");
        student.setAge(20);
        student2.setName("zz");
        studentList.add(student);
        studentList.add(student2);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("/students");
        return modelAndView;
    }

}


