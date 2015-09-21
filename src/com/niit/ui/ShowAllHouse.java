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

public class ShowAllHouse extends JFrame
{
	private HouseDao houseDao;
	private UsersDao usersDao;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	
	public ShowAllHouse()
	{
		houseDao=new HouseDao();
		usersDao=new UsersDao();
		
		this.setBounds(300, 200, 800, 500);
		this.setTitle("所有房屋信息");
		
		ArrayList<House> list=houseDao.findAllHouse();
		int num=list.size();
		data=new Object[num][5];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getHouseid();
			data[i][1]=list.get(i).getArea();
			data[i][2]=list.get(i).getAdress();
			data[i][3]=list.get(i).getPrice();
			data[i][4]=list.get(i).getIdentity();
			//把业主的id换成姓名显示
//			String identity=list.get(i).getIdentity();
//			Users users=usersDao.findUsersByIdentity(identity);
//			String name=users.getUsername();
//			data[i][4]=name;
		}
		columnNames=new String[]{"房屋id","面积","地址","价格","业主id"};
		tableModel=new DefaultTableModel(data,columnNames)
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
