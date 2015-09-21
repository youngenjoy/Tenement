package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.dao.iface.IManagerDao;
import com.niit.entity.Manager;


public class ManagerDao extends BaseDao implements IManagerDao
{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	
	@Override
	public Manager findManagerByManagername(String managername)
	{
		Manager manager=null;
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from manager where managername=?");
				pstmt.setString(1, managername);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					manager=new Manager(rs.getInt(1), rs.getString(2), rs.getString(3));
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
		return manager;
	}
	
	@Override
	public Manager findManagerByManagerid(int managerid)
	{
		Manager manager=null;
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from manager where managerid=?");
				pstmt.setInt(1, managerid);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					manager=new Manager(rs.getInt(1), rs.getString(2), rs.getString(3));
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
		return manager;
	}
	
	@Override
	public boolean modifyManager(Manager manager)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				// 使用预处理器
				pstmt=con.prepareStatement("update manager set managername=?,pwd=? where managerid=?");
				//注入参数
				pstmt.setString(1, manager.getManagername());
				pstmt.setString(2, manager.getPwd());
				pstmt.setInt(3, manager.getManagerid());
				
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



	

	

}
