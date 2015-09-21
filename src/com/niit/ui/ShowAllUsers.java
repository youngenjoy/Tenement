package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class ShowAllUsers extends JFrame
{
	private UsersDao usersDao;
	
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	
	
	public ShowAllUsers()
	{
		usersDao=new UsersDao();
		this.setBounds(300, 200, 800, 500);
		this.setTitle("所有业主信息");

		
		ArrayList<Users> list=usersDao.findAllUsers();
		int num=list.size();
		data=new Object[num][5];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getIdentity();
			data[i][1]=list.get(i).getUsername();
			data[i][2]=list.get(i).getPwd();
			data[i][3]=list.get(i).getPhone();
			data[i][4]=list.get(i).getBalance();
		}
		columnNames=new String[]{"业主id","姓名","密码","电话","余额"};
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
