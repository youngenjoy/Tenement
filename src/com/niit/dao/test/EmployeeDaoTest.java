package com.niit.dao.test;

import java.util.ArrayList;

import com.niit.dao.impl.EmployeeDao;
import com.niit.entity.Employee;

public class EmployeeDaoTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		EmployeeDao employeeDao=new EmployeeDao();
		
		/**
		 * 新增员工
		 */
//		Employee employee=new Employee();
//		employee.setEmployeeid(4);
//		employee.setEmployeename("A");
//		employee.setJob("水");
//		employee.setPhone("12345678932");
//		boolean flag=employeeDao.addEmployee(employee);
//		if(flag)
//		{
//			System.out.println("新增员工成功");
//		}
//		else
//		{
//			System.out.println("新增员工失败");
//		}
		/**
		 * 删除员工
		 */
//		boolean flag=employeeDao.deleteEmployee(4);
//		System.out.println(flag?"删除员工成功":"删除员工失败");
		
		/**
		 * 修改员工信息
		 * 修改2003的信息
		 * 想要修改的修改编后面括号里的值，不想修改就用employee1.*放入原来的值
		 */
//		Employee employee1=employeeDao.findEmployeeByEmployeeid(2003);
//		Employee employee=new Employee();
//		employee.setEmployeeid(employee1.getEmployeeid());
//		employee.setEmployeename("jack");
//		employee.setJob(employee1.getJob());
//		employee.setPhone(employee1.getPhone());
//		boolean flag=employeeDao.modifyEmployee(employee);
//		System.out.println(flag?"修改员工成功":"修改员工失败");
		
		
		/**
		 * 根据员工id查找员工
		 */
//		Employee employee=employeeDao.findEmployeeByEmployeeid(2001);
//		if(employee==null)
//		{
//			System.out.println("不存在员工");
//		}
//		else
//		{
//			System.out.println(employee.getEmployeeid()+"\t"+employee.getEmployeename()+"\t"+employee.getJob()+"\t"+employee.getPhone());
//		}
		/**
		 * 根据员工姓名查找
		 */
//		Employee employee=employeeDao.findEmployeeByEmployeename("jack");
//		if(employee==null)
//		{
//			System.out.println("不存在员工");
//		}
//		else
//		{
//			System.out.println(employee.getEmployeeid()+"\t"+employee.getEmployeename()+"\t"+employee.getJob()+"\t"+employee.getPhone());
//		}
		/**
		 * 根据工作查询员工，可能返回多个值
		 */
//		ArrayList<Employee> list=employeeDao.findEmployeeByJob("水");
//		for(Employee e:list)
//		{
//			System.out.println(e.getEmployeeid()+"\t"+e.getEmployeename()+"\t"+e.getJob()+"\t"+e.getPhone());
//		}
		
		/**
		 * 查询所有员工
		 */
//		ArrayList<Employee> list=employeeDao.findAllEmployee();
//		for(Employee e:list)
//		{
//			System.out.println(e.getEmployeeid()+"\t"+e.getEmployeename()+"\t"+e.getJob()+"\t"+e.getPhone());
//		}
		

	}

}
