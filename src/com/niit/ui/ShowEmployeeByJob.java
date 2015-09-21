package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.RepairRecordDao;
import com.niit.entity.Employee;
import com.niit.entity.RepairRecord;

public class ShowEmployeeByJob extends JFrame
{
	private EmployeeDao employeeDao;
	private RepairRecordDao repairRecordDao;
	//接收传过来的repairid和job
	private int repairId=0;
	private String job="";
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	//右键快捷方式
	private JPopupMenu pop;
	private JMenuItem sendItem;
	
	
	ArrayList<Employee> list;
	
	public ShowEmployeeByJob(int repairId,String job)
	{
		this.repairId=repairId;
		this.job=job;
		this.setBounds(300, 200, 800, 500);
		this.setTitle("员工信息");
		employeeDao=new EmployeeDao();
		list=employeeDao.findEmployeeByJob(job);
		int num=list.size();//找到几个员工
		data=new Object[num][4];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getEmployeeid();
			data[i][1]=list.get(i).getEmployeename();
			data[i][2]=list.get(i).getJob();
			data[i][3]=list.get(i).getPhone();
		}
		columnNames=new String[]{"员工id","员工姓名","工作类型","电话"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			//创建模型的时候重写一个方法
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		tab=new JTable(tableModel);
		pane=new JScrollPane(tab);
		
		//右键快捷菜单
		pop=new JPopupMenu();
		sendItem=new JMenuItem("指派");
		pop.add(sendItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		
		sendItem.addActionListener(new MyItmListener());
		
		this.add(pane);
		this.setVisible(true);
	}
	//右键快捷菜单的监听器
	public class MyItmListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			repairRecordDao=new RepairRecordDao();
			if(itm==sendItem)
			{
				//获取当前选中的员工
				int row=tab.getSelectedRow();
				Employee employee=list.get(row);
				int employeeId=employee.getEmployeeid();
				//修改报修记录表中的数据
				RepairRecord repairRecord1=repairRecordDao.findRepairRecordByRepairid(repairId);
				RepairRecord repairRecord=new RepairRecord();
				repairRecord.setRepairid(repairRecord1.getRepairid());
				repairRecord.setIdentity(repairRecord1.getIdentity());
				repairRecord.setRepairdetail(repairRecord1.getRepairdetail());
				repairRecord.setRepairtime(repairRecord1.getRepairtime());
				repairRecord.setState(1);
				repairRecord.setDealtime(new Timestamp(new Date().getTime()));
				repairRecord.setEmployeeid(employeeId);
				
				boolean flag=repairRecordDao.modifyRepairRecord(repairRecord);
				JOptionPane.showMessageDialog(null, flag?"指派成功":"指派失败");
				
			}
		}
		
	}
}
