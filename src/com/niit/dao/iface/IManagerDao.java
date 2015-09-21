package com.niit.dao.iface;

import com.niit.entity.Manager;

public interface IManagerDao
{
	/**
	 * 根据管理员姓名查找
	 * @param managername
	 * @return
	 */
	public abstract Manager findManagerByManagername(String managername);
	/**
	 * 根据managerid查找管理员 
	 * @param managerid
	 * @return
	 */
	public abstract Manager findManagerByManagerid(int managerid);
	/**
	 * 管理员修改自身信息
	 * @param manager
	 * @return
	 */
	public abstract boolean modifyManager(Manager manager);
}
