package com.niit.entity;

public class Employee
{
	private int employeeid;
	private String employeename;
	private String job;
	private String phone;
	public Employee(int employeeid, String employeename, String job,
			String phone)
	{
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.job = job;
		this.phone = phone;
	}
	public Employee()
	{
		super();
	}
	public int getEmployeeid()
	{
		return employeeid;
	}
	public void setEmployeeid(int employeeid)
	{
		this.employeeid = employeeid;
	}
	public String getEmployeename()
	{
		return employeename;
	}
	public void setEmployeename(String employeename)
	{
		this.employeename = employeename;
	}
	public String getJob()
	{
		return job;
	}
	public void setJob(String job)
	{
		this.job = job;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	
	
	
}
