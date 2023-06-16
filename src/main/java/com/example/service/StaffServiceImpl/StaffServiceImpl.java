/*
package com.example.service.StaffServiceImpl;

import com.example.dao.GameMapper;
import com.example.dao.StaffMapper;
import com.example.pojo.Game;
import com.example.pojo.Staff;
import com.example.service.StaffService;
import com.example.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;
    @Resource
    private GameMapper GameMapper;

    @Override
    public Result getStaffsList(int start, int limit) {  //分页查询员工信息
        List<Staff> staffList = staffMapper.findStaffList(start, limit);  //查找到对应页的员工信息列表
        for (Staff s : staffList) {
            //根据每个员工的部门号确定对应的部门
            Game Game = GameMapper.selectByPrimaryKey(s.getDepartId());
            s.setDepartname(Game.getDname());  //把该部门的部门名设置到该员工的部门名属性
        }
        int totalStaffs = staffMapper.getTotalStaffs();
        Result result = new Result();
        result.setCode(0);
        result.setMsg("查找成功！");
        result.setCount(totalStaffs);
        result.setData(staffList);
        return result;
    }

    @Override
    public Staff getStaffById(Integer id) {
        return staffMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result addStaff(Staff staff) {
        Result result = new Result();
        if (staffMapper.insertSelective(staff)) {
            result.setCode(0);
            result.setMsg("新建成功！");
        } else {
            result.setCode(1);
            result.setMsg("新建失败！");
        }
        return result;
    }

    @Override
    public Result saveStaff(Staff staff) {
        Result result = new Result();
        if (staffMapper.updateByPrimaryKeySelective(staff)) {
            result.setCode(0);
            result.setMsg("修改成功！");
        } else {
            result.setCode(1);
            result.setMsg("修改失败！");
        }
        return result;
    }

}
*/
