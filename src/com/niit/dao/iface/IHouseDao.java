package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.House;

public interface IHouseDao 
{
	/**
	 * 查看所有房屋
	 */
	public abstract ArrayList<House> findAllHouse();
	
	/**
	 * 根据房屋id查找房屋
	 * @param houseid
	 * @return
	 */
	public abstract House findHouseByHouseid(int houseid);
	
	/**
	 * 根据业主id查找房屋
	 */
	public abstract ArrayList<House> findHouseByIdentity(String identity);
	
	/**
	 * 修改房屋信息，只限于修改房屋的户主id
	 * @param house
	 * @return
	 */
	public abstract boolean modifyHouse(House house);
	
	/**
	 * 新增房屋
	 * @param house
	 * @return
	 */
	public abstract boolean addHouse(House house);
	
	
}
