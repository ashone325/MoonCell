package com.example.service;

import com.example.pojo.Department;
import com.example.util.Result;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public interface DepartmentService {
    Result getDepartmentList(int page, int limit);
    Result getDepartmentListByname(String dname,int page, int limit);
    Result addDepartment(Department department);
Result deleteDepartment(int id);
Department getDepartmentById(int id);
Result saveDepartment(Department department);
}
