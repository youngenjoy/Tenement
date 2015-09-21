package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Users;

public interface IUsersDao
{
	/**
	 * 查找所有业主
	 * @return
	 */
	public abstract ArrayList<Users> findAllUsers();
	
	/**
	 * 根据业主姓名查找
	 * @param username
	 * @return
	 */
	public abstract Users findUsersByUsername(String username);
	
	/**
	 * 通过业主身份证查找
	 * @param identity
	 * @return
	 */
	public abstract Users findUsersByIdentity(String identity);
	
	/**
	 * 通过balance查找业主
	 */
	public abstract ArrayList<Users> findUsersByBalance(int balance);
	
	/**
	 * 新增业主
	 * @param user
	 * @return
	 */
	public abstract boolean addUsers(Users user);
	
	/**
	 * 修改业主
	 * @param user
	 * @return
	 */
	public abstract boolean modifyUsers(Users user);
	
	/**
	 * 删除业主
	 * @param identity
	 * @return
	 */
	public abstract boolean deleteUsers(String identity);
	
	
	
	
	
	
	
}
