package com.niit.entity;
/**
 * 管理员id(managerid)，姓名(managername)，密码(pwd)
 * @author Administrator
 *
 */
public class Manager
{
	private int managerid;
	private String managername;
	private String pwd;
	public Manager(int managerid, String managername, String pwd)
	{
		super();
		this.managerid = managerid;
		this.managername = managername;
		this.pwd = pwd;
	}
	public Manager()
	{
		super();
	}
	public int getManagerid()
	{
		return managerid;
	}
	public void setManagerid(int managerid)
	{
		this.managerid = managerid;
	}
	public String getManagername()
	{
		return managername;
	}
	public void setManagername(String managername)
	{
		this.managername = managername;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	
	
}
