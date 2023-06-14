
package com.example.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import com.example.pojo.Department;
import com.example.service.DepartmentService;
import com.example.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    @PostMapping("/department/add")
    @ResponseBody
    public Result addDepartment(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description") String description){//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等
        Department department = new Department();
        department.setDname(dname);
        department.setDtel(dtel);
        department.setDescription(description);
        department.setEstablishmentdate(new Timestamp(new Date().getTime()) );
        return departmentService.addDepartment(department);
    }
    @PostMapping("/department/delete")
    @ResponseBody
    public Result deleteDepartment(@RequestParam("id") int id ) {//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等

        return departmentService.deleteDepartment(id);
    }
    //1.先显示被改部门的信息 get
    @GetMapping("/department/edit")
    public String gotodepartmentedit(@RequestParam("id") int id, Model model){
        Department department =  departmentService.getDepartmentById(id);
        //对应id 信息送到前端
        model.addAttribute("departmentInfo",department);
        return "admin/department-edit";
    }
    //2.修改部门信息post
@PostMapping("/department/edit")
@ResponseBody
    public Result saveDepartment(@RequestParam("id") int id,@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description") String description){//还可以把(@RequestParam("dname") String dname ,@RequestParam("dtel") String dtel,@RequestParam("description")，改为@RequestParam Map<String,Object> paramas,下面的set也修改为paramas.get("dname").toString()等
       Department department =  departmentService.getDepartmentById(id);
        department.setDname(dname);
        department.setDtel(dtel);
        department.setDescription(description);
        return departmentService.saveDepartment(department);
    }
@ResponseBody
    @GetMapping("/reload")
    public boolean reload(HttpSession session){
        String name = session.getAttribute("name").toString();
        return  name != null;
    }
}


