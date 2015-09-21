package com.niit.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

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

import com.niit.dao.impl.FeeRecordDao;
import com.niit.entity.FeeRecord;

public class ShowFeeRecord extends JFrame
{
	private FeeRecordDao feeRecordDao;
	
	
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
	//文本框
	private JTextField identityTextField;
	//右键快捷菜单
	private JPopupMenu pop;
	private JMenuItem yesItem;
	
	//
	private JPanel pnl;
	
	private ArrayList<FeeRecord> list;
	
	public ShowFeeRecord()
	{
		feeRecordDao=new FeeRecordDao();
		this.setBounds(300, 200, 800, 500);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("缴费记录");
//		this.setLayout(null);
		
		String[] values={"所有缴费记录","已通过审核","未通过审核"};
		passBoxModel=new DefaultComboBoxModel(values);
		passBox=new JComboBox(passBoxModel);
//		passBox.setBounds(20, 20, 120, 20);
		
		identityTextField=new JTextField(20);
//		identityTextField.setBounds(450, 20, 100, 20);
		
		passBtn=new JButton("根据审核状态查找");
//		passBtn.setBounds(150, 20, 185, 20);
		identityBtn=new JButton("根据业主id查找");
//		identityBtn.setBounds(560, 20, 185, 20);
		columnNames=new String[]{"缴费id","业主id","缴费金额","是否通过","缴费时间","审核时间"};
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
		yesItem=new JMenuItem("通过");
		pop.add(yesItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		identityBtn.addActionListener(new MyBtnListener());
		passBtn.addActionListener(new MyBtnListener());
		tab.addMouseListener(new MyMouseListener());
		yesItem.addActionListener(new MyItemListener());
		
		
		this.add(pane,BorderLayout.CENTER);
//		this.add(pane,BorderLayout.SOUTH);
//		this.getContentPane().add(pane);
		
//		this.add(identityTextField);
//		this.add(identityBtn);
//		this.add(passBtn);
//		this.add(passBox);
		this.add(pnl,BorderLayout.NORTH);
		
		
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			feeRecordDao=new FeeRecordDao();
			if(btn==passBtn)
			{
				int pass=0;
				String select=passBox.getSelectedItem().toString();
				if(select.equals("已通过审核"))
				{
					pass=1;
					list=feeRecordDao.findFeeRecordByPass(pass);
					
				}
				else if(select.equals("未通过审核"))
				{
					pass=0;
					list=feeRecordDao.findFeeRecordByPass(pass);
				}
				else if(select.equals("所有缴费记录"))
				{
					list=feeRecordDao.findAllFeeRecord();
					
				}
				
				
			}
			else if(btn==identityBtn)
			{
				String identity=identityTextField.getText();
				list=feeRecordDao.findFeeRecordByIdentity(identity);
			}
		
			
			
			int num=list.size();
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
				
				
//				data[i][3]=list.get(i).getPass();
				data[i][4]=list.get(i).getFeetime();
				data[i][5]=list.get(i).getExamtime();
			}
			tableModel.setDataVector(data, columnNames);
			
			
			
		}
		
	}
	
	//鼠标双击时的监听器
	public class MyMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			int count=e.getClickCount();
			if(count==2)
			{
				int row=tab.getSelectedRow();
				FeeRecord feeRecord=list.get(row);
				JOptionPane.showMessageDialog(null, feeRecord.getFeeid());
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
	
	//右键快捷的监听器
	public class MyItemListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			feeRecordDao=new FeeRecordDao();
			
			
			if(itm==yesItem)
			{
				//通过，修改缴费记录里的pass为1
				
				//获得选中的缴费记录 的feeid
				//错误写法
//				int row=tab.getSelectedRow();
//				ArrayList<FeeRecord> list=feeRecordDao.findAllFeeRecord();
//				int id=list.get(row).getFeeid();
				
				//正确写法
				int row=tab.getSelectedRow();
				FeeRecord feeRecord=list.get(row);
				int feeid=feeRecord.getFeeid();

				FeeRecord feeRecord1=feeRecordDao.findFeeRecordByFeeid(feeid);
				FeeRecord feeRecord2=new FeeRecord();//new一个修改之后的feerecord
				feeRecord2.setFeeid(feeRecord1.getFeeid());
				feeRecord2.setIdentity(feeRecord1.getIdentity());
				feeRecord2.setFee(feeRecord1.getFee());
				feeRecord2.setPass(1);
				feeRecord2.setFeetime(feeRecord1.getFeetime());
				feeRecord2.setExamtime(new Timestamp(new Date().getTime()));
				
				boolean flag=feeRecordDao.modifyFeeRecord(feeRecord2);
				JOptionPane.showMessageDialog(null, flag?"修改缴费记录成功":"修改缴费记录失败");
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args)
//	{
//		new ShowFeeRecord();
//	}
}
