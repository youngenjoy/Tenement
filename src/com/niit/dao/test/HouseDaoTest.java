package com.niit.dao.test;

import java.util.ArrayList;

import com.niit.dao.impl.HouseDao;
import com.niit.entity.House;

public class HouseDaoTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HouseDao houseDao=new HouseDao();
		/**
		 * 查询所有房屋
		 */
//		ArrayList<House> list=houseDao.findAllHouse();
//		for(House h:list)
//		{
//			System.out.println(h.getHouseid()+"\t"+h.getArea()+"\t"+h.getAdress()+"\t"+h.getPrice()+"\t"+h.getIdentity());
//		}
		
		/**
		 * 新增房屋
		 */
//		House house=new House();
//		house.setHouseid(7001);
//		house.setArea(700);
//		house.setAdress("苏州城区");
//		house.setPrice(7000000);
//		house.setIdentity("101");
//		boolean flag=houseDao.addHouse(house);
//		System.out.println(flag?"新增房屋成功":"新增房屋失败");
		
		/**
		 * 根据房屋id查找房屋
		 */
//		House house=houseDao.findHouseByHouseid(5001);
//		if(house==null)
//		{
//			System.out.println("不存在该房屋");
//		}
//		else
//		{
//			System.out.println(house.getHouseid()+"\t"+house.getArea()+"\t"+house.getAdress()+"\t"+house.getPrice()+"\t"+house.getIdentity());
//		}
		
		/**
		 * 修改房屋信息，只限于修改户主id
		 */
//		House house1=houseDao.findHouseByHouseid(6001);
//		House house=new House();
//		house.setHouseid(house1.getHouseid());
//		house.setArea(house1.getArea());
//		house.setAdress(house1.getAdress());
//		house.setPrice(house1.getPrice());
//		house.setIdentity("106");
//		
//		boolean flag=houseDao.modifyHouse(house);
//		System.out.println(flag?"修改房屋信息成功":"修改房屋信息失败");
		
		/**
		 * 根据identity查找房屋，可能返回多个值
		 */
//		ArrayList<House> list=houseDao.findHouseByIdentity("101");
//		for(House h:list)
//		{
//			System.out.println(h.getHouseid()+"\t"+h.getArea()+"\t"+h.getAdress()+"\t"+h.getPrice()+"\t"+h.getIdentity());
//		}
		
		
		

	}

}
