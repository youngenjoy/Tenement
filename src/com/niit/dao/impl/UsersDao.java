package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IUsersDao;
import com.niit.entity.Users;

public class UsersDao extends BaseDao implements IUsersDao
{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;
	
	@Override
	public boolean addUsers(Users user)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				//使用预处理器
				pstmt=con.prepareStatement("insert into users values(?,?,?,?,?)");
				//注入参数
				pstmt.setString(1, user.getIdentity());
				pstmt.setString(2, user.getUsername());
				pstmt.setString(3, user.getPwd());
				pstmt.setString(4, user.getPhone());
				pstmt.setInt(5, user.getBalance());
				
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
	public ArrayList<Users> findAllUsers()
	{
		ArrayList<Users> list=new ArrayList<Users>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from users");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					Users user=new Users();
					user.setIdentity(rs.getString(1));
					user.setUsername(rs.getString(2));
					user.setPwd(rs.getString(3));
					user.setPhone(rs.getString(4));
					user.setBalance(rs.getInt(5));
					list.add(user);
					
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
	public Users findUsersByIdentity(String identity)
	{
		Users user=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from users where identity=?");
				pstmt.setString(1, identity);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					user=new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
		return user;
	}

	@Override
	public Users findUsersByUsername(String username)
	{
		Users user=null;
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from users where username=?");
				pstmt.setString(1, username);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					user=new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
		return user;
	}

	@Override
	public boolean modifyUsers(Users user)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				// 使用预处理器
				pstmt=con.prepareStatement("update users set username=?,pwd=?,phone=?,balance=? where identity=?");
				//注入参数
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPwd());
				pstmt.setString(3, user.getPhone());
				pstmt.setInt(4, user.getBalance());
				pstmt.setString(5, user.getIdentity());
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
	public ArrayList<Users> findUsersByBalance(int balance)
	{
		ArrayList<Users> list=new ArrayList<Users>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from users where balance<?");
				//注入参数
				pstmt.setInt(1, balance);
				//执行
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					Users user=new Users();
					user.setIdentity(rs.getString(1));
					user.setUsername(rs.getString(2));
					user.setPwd(rs.getString(3));
					user.setPhone(rs.getString(4));
					user.setBalance(rs.getInt(5));
					list.add(user);
					
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
	public boolean deleteUsers(String identity)
	{
		//默认删除失败
		boolean flag=false;
		
		try
		{
			//获取连接
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("delete from users where identity=?");
				//注入参数
				pstmt.setString(1, identity);
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

}
