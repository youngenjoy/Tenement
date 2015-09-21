package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.House;
import com.niit.entity.Users;

public class ShowMyHouseInfo extends JFrame 
{
	private Users users;
	private UsersDao usersDao;
//	private UserMain userMain;
	private HouseDao houseDao;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	
	
	public ShowMyHouseInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		
		houseDao=new HouseDao();
		
		this.setBounds(200, 100, 800, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("我的房屋信息:"+users.getUsername());
		
		ArrayList<House> list=houseDao.findHouseByIdentity(users.getIdentity());
		int num=list.size();//该业主有几套房子
		data=new Object[num][5];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getHouseid();
			data[i][1]=list.get(i).getArea();
			data[i][2]=list.get(i).getAdress();
			data[i][3]=list.get(i).getPrice();
			data[i][4]=list.get(i).getIdentity();
		}
		columnNames=new String[]{"房屋id","面积","地址","总价","户主id"};
		tableModel=new DefaultTableModel(data, columnNames)
		{
			//创建模型的时候重写一个方法
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		//实例化表格
		tab=new JTable(tableModel);
		//创建滚动面板
		pane=new JScrollPane(tab);
		
		this.add(pane);
		this.setVisible(true);
	}
	
}
