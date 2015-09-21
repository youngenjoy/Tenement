package com.niit.entity;
/**
 * 业主(users)：业主id（identity），姓名(username)，密码(pwd)，，电话(phone)，余额(balance)
 * @author Administrator
 *
 */
public class Users
{
	private String identity;
	private String username;
	private String pwd;
	private String phone;
	private int balance;
	public Users(String identity, String username, String pwd, String phone,
			int balance)
	{
		super();
		this.identity = identity;
		this.username = username;
		this.pwd = pwd;
		this.phone = phone;
		this.balance = balance;
	}
	public Users()
	{
		super();
	}
	public String getIdentity()
	{
		return identity;
	}
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	
	
}
