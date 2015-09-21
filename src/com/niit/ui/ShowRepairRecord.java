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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.RepairRecordDao;
import com.niit.entity.RepairRecord;

public class ShowRepairRecord extends JFrame
{
	private RepairRecordDao repairRecordDao;
	//下拉列表框
	private JComboBox passBox;
	//模型
	private DefaultComboBoxModel passBoxModel;
	
	private JButton passBtn,identityBtn;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//滚动面板
	private JScrollPane pane;
	//表格模型
	private DefaultTableModel tableModel;
	private JPanel pnl;
	private JTextField identityTextField;
	private ArrayList<RepairRecord> list;
	
	//右键快捷菜单
	private JPopupMenu pop;
	private JMenuItem waterItem,eleItem,gasItem,otherItem;
	
	public ShowRepairRecord()
	{
		this.setBounds(300, 200, 800, 500);
		this.setTitle("报修记录");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(null);
		
		String[] values={"所有报修记录","已处理","未处理"};
		passBoxModel=new DefaultComboBoxModel(values);
		passBox=new JComboBox(passBoxModel);
//		passBox.setBounds(20, 20, 120, 20);
		
		identityTextField=new JTextField(20);
//		identityTextField.setBounds(450, 20, 100, 20);
		
		passBtn=new JButton("根据处理状态查找");
//		passBtn.setBounds(150, 20, 185, 20);
		identityBtn=new JButton("根据业主id查找");
//		identityBtn.setBounds(560, 20, 185, 20);
		
		columnNames=new String[]{"报修id","业主id","报修详情","报修时间","状态","处理时间","指派员工id"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			//创建模型的时候重写一个方法
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		tab=new JTable(tableModel);
		tab.getTableHeader().setReorderingAllowed(false);
		pane=new JScrollPane(tab);
//		pane.setBounds(0, 50, 800, 450);
		
		pnl=new JPanel();
		pnl.add(passBox);
		pnl.add(passBtn);
		pnl.add(identityTextField);
		pnl.add(identityBtn);
		
		
		
		//右键快捷菜单
		pop=new JPopupMenu();
		waterItem=new JMenuItem("水");
		eleItem=new JMenuItem("电");
		gasItem=new JMenuItem("煤");
		otherItem=new JMenuItem("其他");
		pop.add(waterItem);
		pop.add(eleItem);
		pop.add(gasItem);
		pop.add(otherItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		passBtn.addActionListener(new MyBtnListener());
		identityBtn.addActionListener(new MyBtnListener());
		waterItem.addActionListener(new MyItemListener());
		eleItem.addActionListener(new MyItemListener());
		gasItem.addActionListener(new MyItemListener());
		otherItem.addActionListener(new MyItemListener());
		
		this.add(pane,BorderLayout.CENTER);
		this.add(pnl,BorderLayout.NORTH);
//		this.add(identityBtn);
//		this.add(identityTextField);
//		this.add(passBtn);
//		this.add(passBox);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
			repairRecordDao=new RepairRecordDao();
			if(btn==passBtn)
			{
				int pass=0;
				String select=passBox.getSelectedItem().toString();
				if(select.equals("已处理"))
				{
					pass=1;
					list=repairRecordDao.findRepairRecordByState(pass);
				}
				else if(select.equals("未处理"))
				{
					pass=0;
					list=repairRecordDao.findRepairRecordByState(pass);
				}
				else if(select.equals("所有报修记录"))
				{
					list=repairRecordDao.findAllRepairRecord();
				}
				
				
			}
			else if(btn==identityBtn)
			{
				String identity=identityTextField.getText();
				list=repairRecordDao.findRepairRecordByIdentity(identity);
			}
			int num=list.size();
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
//				data[i][4]=list.get(i).getState();
				data[i][5]=list.get(i).getDealtime();
				data[i][6]=list.get(i).getEmployeeid();
			}
			tableModel.setDataVector(data, columnNames);	
			
			
		}
		
	}
	
	//右键快捷方式的监听器
	public class MyItemListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			
			
			//获取选中的报修id，方便后面修改
			int row=tab.getSelectedRow();
			RepairRecord repairRecord=list.get(row);
			int repairId=repairRecord.getRepairid();
			
			if(itm==waterItem)
			{
				new ShowEmployeeByJob(repairId,"水");
			}
			else if(itm==eleItem)
			{
				new ShowEmployeeByJob(repairId,"电");
			}
			else if(itm==gasItem)
			{
				new ShowEmployeeByJob(repairId,"煤");
			}
			else if(itm==otherItem)
			{
				new ShowEmployeeByJob(repairId,"其他");
			}
		}
		
	}
//	public static void main(String[] args)
//	{
//		new ShowRepairRecord();
//	}
}
