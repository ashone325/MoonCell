package com.example.dao;

import com.example.pojo.Staff;
import java.util.List;

public interface StaffMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    boolean insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff> findStaffList(int start, int limit);

    int getTotalStaffs();
}