package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IEmployeeDao;
import com.niit.entity.Employee;



public class EmployeeDao extends BaseDao implements IEmployeeDao
{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	@Override
	public boolean addEmployee(Employee employee)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				//使用预处理器
				pstmt=con.prepareStatement("insert into employee values(?,?,?,?)");
				//注入参数
				pstmt.setInt(1, employee.getEmployeeid());
				pstmt.setString(2, employee.getEmployeename());
				pstmt.setString(3, employee.getJob());
				pstmt.setString(4, employee.getPhone());
				
				//执行SQL语句
				int count=pstmt.executeUpdate();
				if(count==1)
				{
					flag=true;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	@Override
	public boolean deleteEmployee(int employeeid)
	{
		//默认删除失败
		boolean flag=false;
		
		try
		{
			//获取连接
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("delete from employee where employeeid=?");
				//注入参数
				pstmt.setInt(1, employeeid);
				//执行
				int count=pstmt.executeUpdate();
				flag=count==1?true:false;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	@Override
	public Employee findEmployeeByEmployeeid(int employeeid)
	{
		
		Employee employee=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from employee where employeeid=?");
				pstmt.setInt(1, employeeid);
				
				//执行
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					
					employee=new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return employee;
	}

	@Override
	public Employee findEmployeeByEmployeename(String employeename)
	{
		Employee employee=null;
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from employee where employeename=?");
				pstmt.setString(1, employeename);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					employee=new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}
				
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return employee;
	}

	@Override
	public ArrayList<Employee> findEmployeeByJob(String job)
	{
		ArrayList<Employee> list=new ArrayList<Employee>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from employee where job=?");
				pstmt.setString(1, job);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					Employee employee=new Employee();
					employee.setEmployeeid(rs.getInt(1));
					employee.setEmployeename(rs.getString(2));
					employee.setJob(rs.getString(3));
					employee.setPhone(rs.getString(4));
					list.add(employee);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public boolean modifyEmployee(Employee employee)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				// 使用预处理器
				pstmt=con.prepareStatement("update employee set employeename=?,job=?,phone=? where employeeid=?");
				//注入参数
				pstmt.setString(1, employee.getEmployeename());
				pstmt.setString(2, employee.getJob());
				pstmt.setString(3, employee.getPhone());
				pstmt.setInt(4, employee.getEmployeeid());
				//执行SQL语句
				int count=pstmt.executeUpdate();
				if(count==1)
				{
					flag=true;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	@Override
	public ArrayList<Employee> findAllEmployee() 
	{
		ArrayList<Employee> list=new ArrayList<Employee>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from employee");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					Employee employee=new Employee();
					employee.setEmployeeid(rs.getInt(1));
					employee.setEmployeename(rs.getString(2));
					employee.setJob(rs.getString(3));
					employee.setPhone(rs.getString(4));
					list.add(employee);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

}
