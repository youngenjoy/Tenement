package com.niit.dao.test;

import java.util.ArrayList;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class UsersDaoTest
{
	public static void main(String[] args)
	{
		UsersDao usersDao=new UsersDao();
		
		/**
		 * 查找所有业主
		 */
//		ArrayList<Users> list=usersDao.findAllUsers();
//		for(Users u:list)
//		{
//			System.out.println(u.getIdentity()+"\t"+u.getUsername()+"\t"+u.getPwd()+"\t"+u.getPhone()+"\t"+u.getBalance());
//		}
		/**
		 * 根据业主姓名查找
		 */
//		Users user=usersDao.findUsersByUsername("B");
//		if(user==null)
//		{
//			System.out.println("不存在该业主");
//		}
//		else
//		{
//			System.out.println(user.getIdentity()+"\t"+user.getUsername()+"\t"+user.getPwd()+"\t"+user.getPhone()+"\t"+user.getBalance());
//		}
		
		/**
		 * 根据业主身份证查找
		 */
//		Users user=usersDao.findUsersByIdentity("102");
//		if(user==null)
//		{
//			System.out.println("不存在该业主");
//		}
//		else
//		{
//			System.out.println(user.getIdentity()+"\t"+user.getUsername()+"\t"+user.getPwd()+"\t"+user.getPhone()+"\t"+user.getBalance());
//		}
		
		/**
		 * 根据balance查找业主
		 */
//		ArrayList<Users> list=usersDao.findUsersByBalance(10);
//		for(Users u:list)
//		{
//			System.out.println(u.getIdentity()+"\t"+u.getUsername()+"\t"+u.getPwd()+"\t"+u.getPhone()+"\t"+u.getBalance());
//		}
		
		/**
		 * 新增业主
		 */
//		Users user=new Users();
//		user.setIdentity("107");
//		user.setUsername("G");
//		user.setPwd("123456");
//		user.setPhone("1213213355");
//		user.setBalance(0);
//		boolean flag=usersDao.addUsers(user);
//		if(flag)
//		{
//			System.out.println("增加业主成功");
//		}
//		else
//		{
//			System.out.println("新增业主失败");
//		}
		
		/**
		 * 修改业主信息
		 * 修改106的信息
		 * 想要修改的修改编后面括号里的值，不想修改就用user1.*放入原来的值
		 */
//		Users user1=usersDao.findUsersByIdentity("106");
//		Users user=new Users();
//		user.setIdentity(user1.getIdentity());
//		user.setUsername(user1.getUsername());
//		user.setPwd("123456");
//		user.setPhone(user1.getPhone());
//		user.setBalance(user1.getBalance());
//		
//		boolean flag=usersDao.modifyUsers(user);
//		if(flag)
//		{
//			System.out.println("修改成功");
//		}
//		else
//		{
//			System.out.println("修改失败");
//		}
		/**
		 * 删除业主
		 */
//		boolean flag=usersDao.deleteUsers("121212");
//		System.out.println(flag?"删除业主成功":"删除业主失败");
		
		
	}
}
