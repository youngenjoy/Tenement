package com.niit.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.EmployeeDao;
import com.niit.entity.Employee;

public class ShowAllEmployee extends JFrame
{
	private EmployeeDao employeeDao;
	//下拉列表框
	private JComboBox jobBox;
	//模型
	private DefaultComboBoxModel jobBoxModel;
	//btn
	private JButton  jobBtn,addEmployeeBtn;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane,testPane;
	//表格模型
	private DefaultTableModel tableModel;
	//右键快捷菜单
	private JPopupMenu pop;
	private JMenuItem deleteItem,modifyItem;
	
	private JPanel pnl;
	
	ArrayList<Employee> list;
	public ShowAllEmployee()
	{
		employeeDao=new EmployeeDao();
		this.setBounds(300, 200, 800, 500);
		this.setTitle("员工信息");
//		this.setLayout(null);
		
		String[] values={"查询所有员工","水","电","煤","其他"};
		jobBoxModel=new DefaultComboBoxModel(values);
		jobBox=new JComboBox(jobBoxModel);
		jobBox.setBounds(20, 20, 120, 20);
		
		jobBtn=new JButton("根据工作类型查找");
		jobBtn.setBounds(150, 20, 185, 20);
		addEmployeeBtn=new JButton("新增员工");
		addEmployeeBtn.setBounds(550, 20, 120, 20);
		
		columnNames=new String[]{"员工id","员工姓名","工作","电话"};
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
		pane.setBounds(0, 50, 800, 500);
		
		pnl=new JPanel();
		pnl.add(jobBox);
		pnl.add(jobBtn);
		pnl.add(addEmployeeBtn);
		
		
		
		
		
		
		
		
		
		//右键快捷菜单
		pop=new JPopupMenu();
		deleteItem=new JMenuItem("删除");
		modifyItem=new JMenuItem("修改");
		pop.add(deleteItem);
		pop.add(modifyItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		jobBtn.addActionListener(new MyBtnListener());
		addEmployeeBtn.addActionListener(new MyBtnListener());
		deleteItem.addActionListener(new MyItmListener());
		modifyItem.addActionListener(new MyItmListener());
		this.add(pane,BorderLayout.CENTER);
		this.add(pnl,BorderLayout.NORTH);
//		this.add(addEmployeeBtn);
//		this.add(jobBtn);
//		this.add(jobBox);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			employeeDao=new EmployeeDao();
			if(btn==jobBtn)
			{
				//根据工作类型超找员工
				String select=jobBox.getSelectedItem().toString();
				if(select.equals("查询所有员工"))
				{
					list=employeeDao.findAllEmployee();
				}
				else if(select.equals("水"))
				{
					list=employeeDao.findEmployeeByJob("水");
				}
				else if(select.equals("电"))
				{
					list=employeeDao.findEmployeeByJob("电");
				}
				else if(select.equals("煤"))
				{
					list=employeeDao.findEmployeeByJob("煤");
				}
				else if(select.equals("其他"))
				{
					list=employeeDao.findEmployeeByJob("其他");
				}
				int num=list.size();
				data=new Object[num][4];
				for(int i=0;i<num;i++)
				{
					data[i][0]=list.get(i).getEmployeeid();
					data[i][1]=list.get(i).getEmployeename();
					data[i][2]=list.get(i).getJob();
					data[i][3]=list.get(i).getPhone();
				}
				tableModel.setDataVector(data, columnNames);
			}
			else if(btn==addEmployeeBtn)
			{
				//增加员工的时候
				new AddNewEmployee();
			}
			
		}
		
	}
	
	public class MyItmListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			employeeDao=new EmployeeDao();
			//获取选中的员工id，根据id删掉该员工
			int row=tab.getSelectedRow();
			Employee employee=list.get(row);
			int employeeId=employee.getEmployeeid();
			if(itm==deleteItem)
			{
				boolean flag=employeeDao.deleteEmployee(employeeId);
				JOptionPane.showMessageDialog(null, flag?"删除员工成功":"删除员工失败");
			}
			else if(itm==modifyItem)
			{
				new ModifyEmployee(employeeId);
			}
				
			
		}
		
	}
	
	
	
	
}
