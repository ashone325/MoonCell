
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
}

