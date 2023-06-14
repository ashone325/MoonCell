
package com.example.controller;
import java.util.Map;

import com.example.service.DepartmentService;
import com.example.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class DepartmentController {

  @Resource
    DepartmentService departmentService;
    @GetMapping("/department")
    public String list(){
        return "admin/department-list";
    }
    @GetMapping("/department/listall")
    @ResponseBody
    public Result listall(@RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return departmentService.getDepartmentList(start,limit);//
    }
@GetMapping("/department/listbyname")
@ResponseBody
    public Result listByName(@RequestParam("dname")String dname, @RequestParam Map<String,Object> paramas){
        int page= Integer.parseInt(paramas.get("page").toString());
        int limit= Integer.parseInt(paramas.get("limit").toString());
        int start=(page-1)*limit;
        return departmentService.getDepartmentListByname(dname,start,limit);//
    }

    @GetMapping("/department/add")
    public String gotodepartmentadd(){
        return "admin/department-add";
    }
}


