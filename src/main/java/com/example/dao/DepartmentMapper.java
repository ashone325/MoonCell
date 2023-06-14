
package com.example.dao;

import com.example.pojo.Department;
import com.example.pojo.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    boolean deleteByPrimaryKey(Integer id);

    int insert(Department record);

    boolean insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    boolean updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    int getTotalDepartments();//查询总记录数
     List<Department> findDepartmentList(int start,int limit);//分页查询表中记录
    int getTotalDepartmentsByname(String dname);//查询包含dname的总记录数
    List<Department> findDepartmentListByname(String dname,int start,int limit);//按dname分页查询表中记录
    

}
