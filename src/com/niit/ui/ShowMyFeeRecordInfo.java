package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.FeeRecordDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.FeeRecord;
import com.niit.entity.Users;

public class ShowMyFeeRecordInfo extends JFrame 
{
	private Users users;
	private UsersDao usersDao;
//	private UserMain userMain;
	private FeeRecordDao feeRecordDao;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	
	public ShowMyFeeRecordInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		
		
		feeRecordDao=new FeeRecordDao();
		
		this.setBounds(200, 100, 800, 500);
		this.setTitle("我的交费记录");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<FeeRecord> list=feeRecordDao.findFeeRecordByIdentity(users.getIdentity());
		int num=list.size();//该业主有几条记录
		data=new Object[num][6];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getFeeid();
			data[i][1]=list.get(i).getIdentity();
			data[i][2]=list.get(i).getFee();
			
			String pass="";
			if(list.get(i).getPass()==0)
			{
				pass="未通过";
			}
			else if(list.get(i).getPass()==1)
			{
				pass="通过";
			}
			data[i][3]=pass;
			
//			data[i][3]=list.get(i).getPass();
			data[i][4]=list.get(i).getFeetime();
			data[i][5]=list.get(i).getExamtime();
		}
		columnNames=new String[]{"缴费id","业主id","缴费金额","是否通过","缴费时间","审核时间"};
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
