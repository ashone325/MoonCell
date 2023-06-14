
package com.example.service;

import com.example.dao.DepartmentMapper;
import com.example.pojo.Department;
import com.example.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DepartmentServicempl implements DepartmentService{
    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public Result getDepartmentList(int start, int limit) {
        List<Department> departmentList = departmentMapper.findDepartmentList(start,
                limit);
        int totalDepartments = departmentMapper.getTotalDepartments();
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalDepartments);
        result.setData(departmentList);
        return result;
    }
    @Override
    public Result getDepartmentListByname(String dname,int start, int limit) {
        List<Department> departmentList = departmentMapper.findDepartmentListByname(dname,start,
                limit);
        int totalDepartments = departmentMapper.getTotalDepartmentsByname(dname);
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalDepartments);
        result.setData(departmentList);
        return result;
    }

    @Override
    public Result addDepartment(Department department) {
        Result result = new Result();
        if(departmentMapper.insertSelective(department)){
            result.setCode(0);
            result.setMsg("添加成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("添加失败！");
        }
        return result;

    }

    @Override
    public Result deleteDepartment(int id) {
        Result result = new Result();
        if (departmentMapper.deleteByPrimaryKey(id)){
            result.setCode(0);
            result.setMsg("删除成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("删除失败！");
        }
        return result;
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result saveDepartment(Department department) {
        Result result = new Result();
        if (departmentMapper.updateByPrimaryKeySelective(department)){
            result.setCode(0);
            result.setMsg("修改成功！");
        }
        else {
            result.setCode(1);
            result.setMsg("修改失败！");
        }
        return result;
    }
}

