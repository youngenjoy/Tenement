package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmployeeDao
{
	/**
	 * 新增员工
	 */
	public abstract boolean addEmployee(Employee employee);
	/**
	 * 根据员工编号删除员工
	 */
	public abstract boolean deleteEmployee(int employeeid);
	/**
	 * 修改员工信息
	 */
	public abstract boolean modifyEmployee(Employee employee);
	/**
	 * 查找所有员工
	 * @return
	 */
	public abstract ArrayList<Employee> findAllEmployee();
	/**
	 * 根据员工编号查找员工
	 */
	public abstract Employee findEmployeeByEmployeeid(int employeeid);
	/**
	 * 根据员工姓名查找员工
	 */
	public abstract Employee findEmployeeByEmployeename(String employeename);
	/**
	 * 根据员工工作类型查找员工，可能返回多个员工
	 */
	public abstract ArrayList<Employee> findEmployeeByJob(String job);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
