package com.example.service;

import com.example.pojo.Staff;
import com.example.util.Result;

public interface StaffService {

    Result getStaffsList(int start, int limit);

    Staff getStaffById(Integer id);

    Result addStaff(Staff staff);

    Result saveStaff(Staff staff);

}
