package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.RepairRecordDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.RepairRecord;
import com.niit.entity.Users;

public class ShowMyRepaireRecordInfo extends JFrame
{
	private Users users;
	private UsersDao usersDao;
	
//	private UserMain userMain;
	
	private RepairRecordDao repairRecordDao;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	
	public ShowMyRepaireRecordInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		repairRecordDao=new RepairRecordDao();
		
		this.setBounds(200, 100, 800, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("我的报修记录:"+users.getUsername());
		
		ArrayList<RepairRecord> list=repairRecordDao.findRepairRecordByIdentity(users.getIdentity());
		int num=list.size();//该业主有几条报修记录
		data=new Object[num][7];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getRepairid();
			data[i][1]=list.get(i).getIdentity();
			data[i][2]=list.get(i).getRepairdetail();
			data[i][3]=list.get(i).getRepairtime();
			
			String state="";
			if(list.get(i).getState()==0)
			{
				state="未处理";
			}
			else if(list.get(i).getState()==1)
			{
				state="已处理";
			}
			data[i][4]=state;
			
//			data[i][4]=list.get(i).getState();
			data[i][5]=list.get(i).getDealtime();
			data[i][6]=list.get(i).getEmployeeid();
		}
		columnNames=new String[]{"报修id","业主id","报修内容","报修时间","状态","处理时间","指派员工id"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		//实例化表格
		tab=new JTable(tableModel);
		//实例化滚动面板
		pane=new JScrollPane(tab);
		this.add(pane);
		this.setVisible(true);
	}
}
