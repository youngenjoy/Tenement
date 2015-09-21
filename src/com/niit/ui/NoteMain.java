package com.niit.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;
import com.niit.massage.Massage;

public class NoteMain extends JFrame
{
	private UsersDao usersDao;
	
	private JLabel errorLabel;
	private JTextField moneyLeftTextField;
	private JButton searchBtn,massageBtn;
	
	//表格
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//表格模型
	private DefaultTableModel tableModel;
	//滚动面板
	private JScrollPane pane;
	
	private JPanel pnl;
	ArrayList<Users> list;
	
	public NoteMain()
	{
		this.setBounds(300, 200, 800, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("短信提醒");
//		this.setLayout(null);
		
		errorLabel=new JLabel("");
		errorLabel.setBounds(20, 0, 100, 20);
		errorLabel.setForeground(Color.red);
		moneyLeftTextField=new JTextField(20);
		moneyLeftTextField.setBounds(20, 20, 100, 20);
		searchBtn=new JButton("查找");
		searchBtn.setBounds(150, 20, 85, 20);	
		massageBtn=new JButton("发送短信");
		massageBtn.setBounds(500, 20, 100, 20);
		
		columnNames=new String[]{"业主id","姓名","密码","电话","余额"};
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
		pane.setBounds(0, 50, 800,450);
		
		pnl=new JPanel();
		pnl.add(errorLabel);
		pnl.add(moneyLeftTextField);
		pnl.add(searchBtn);
		pnl.add(massageBtn);
		
		
		
		searchBtn.addActionListener(new MyBtnListener());
		massageBtn.addActionListener(new MyBtnListener());
		moneyLeftTextField.addKeyListener(new MyKeyListener());
		this.add(pane,BorderLayout.CENTER);
		this.add(pnl,BorderLayout.NORTH);
//		this.add(searchBtn);
//		this.add(massageBtn);
//		this.add(moneyLeftTextField);
//		this.add(errorLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
			usersDao=new UsersDao();
			if(btn==searchBtn)
			{
				if(!(moneyLeftTextField.getText().equals("")))
				{
					if(!errorLabel.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "输入有误，请重新输入");
						return;
					}
					
					int moneyLeft=0;
					moneyLeft=Integer.parseInt(moneyLeftTextField.getText());
					list=usersDao.findUsersByBalance(moneyLeft);
					
					
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
					tableModel.setDataVector(data, columnNames);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "请输入查找的金额限度");
				}
				
			}
			else if(btn==massageBtn)
			{
				if(list!=null)
				{
					for(Users u:list)
					{
						try
						{
							new Massage(u.getPhone(), "小主，您给的物业费快花完 啦，麻烦再来赏点呗！【天朝物业】");
						} catch (Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "请先查找");
				}
				
			}
		}
		
	}
	
	/**
	 * 非法字符
	 * @author Administrator
	 *
	 */
	private class MyKeyListener implements KeyListener
	{
		/**
		 * 松开的时候
		 * 
		 */
		@Override
		public void keyReleased(KeyEvent e)
		{
			String myTxt=moneyLeftTextField.getText();
			errorLabel.setText("");
			if(myTxt.length()!=0)
			{	
				for(int i=0;i<myTxt.length();i++)
				{
					char ch=myTxt.charAt(i);
					if(!((ch>='0'&&ch<='9')||ch=='.'))
					{
						errorLabel.setText("输入的金额有误");
					}
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e)
		{
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	}
	
//	public static void main(String[] args)
//	{
//		new MassageMain();
//	}
	
}
