package com.niit.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.niit.dao.impl.ManagerDao;
import com.niit.entity.Manager;

public class ManagerMain extends JFrame
{
	private ManagerDao managerDao;
	private Manager manager;
	private JToolBar toolBar;
//	private Login login;
	private ManagerMain managerMain;
	private JButton showAllUserBtn,showAllHouseBtn,updateBtn,addUserBtn,showRepairBtn,showFeeBtn,managerEmployeeBtn,massageBtn,cancleBtn;
	private JPanel pnl;
	public ManagerMain(String userName)
	{
		managerDao=new ManagerDao();
		this.manager=managerDao.findManagerByManagername(userName);
		managerMain=this;
//		this.login=login;
//		this.setBounds(200, 100, 800, 500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("管理员:"+manager.getManagername());
		
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Image image=tool.getImage("image//administrator.jpg");
		this.setIconImage(image);
		
//		this.setLayout(null);
		
		toolBar=new JToolBar();
//		toolBar.setBounds(0, 0, 800, 40);
		showAllUserBtn=new JButton("查看所有业主");
		showAllHouseBtn=new JButton("查看所有房屋");
		updateBtn=new JButton("修改我的信息");
		addUserBtn=new JButton("增添新业主");
		showFeeBtn=new JButton("查看缴费记录");
		showRepairBtn=new JButton("查看报修记录");
		managerEmployeeBtn=new JButton("管理员工");
		massageBtn=new JButton("短信提醒");
		cancleBtn=new JButton("退出");
		
		toolBar.add(showAllUserBtn);
		toolBar.add(showAllHouseBtn);
		toolBar.add(updateBtn);
		toolBar.add(addUserBtn);
		toolBar.add(showFeeBtn);
		toolBar.add(showRepairBtn);
		toolBar.add(managerEmployeeBtn);
		toolBar.add(massageBtn);
		toolBar.add(cancleBtn);
		toolBar.setFloatable(false);
		
		pnl=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				Image image=Toolkit.getDefaultToolkit().getImage("image//8.jpg");
				g.drawImage(image, 0, 0, managerMain.getWidth(),managerMain.getHeight(),managerMain);
			}
		};
		
		
		
		
		//监听器
		showAllUserBtn.addActionListener(new MyBtnListener());
		showAllHouseBtn.addActionListener(new MyBtnListener());
		updateBtn.addActionListener(new MyBtnListener());
		addUserBtn.addActionListener(new MyBtnListener());
		showFeeBtn.addActionListener(new MyBtnListener());
		showRepairBtn.addActionListener(new MyBtnListener());
		managerEmployeeBtn.addActionListener(new MyBtnListener());
		massageBtn.addActionListener(new MyBtnListener());
		cancleBtn.addActionListener(new MyBtnListener());
		
		this.add(pnl,BorderLayout.CENTER);
		this.add(toolBar,BorderLayout.NORTH);
		this.setVisible(true);
	}
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			Manager manager=login.getManagerDao().findManagerByManagername(login.getName());
			
			if(btn==showAllUserBtn)
			{
				//显示所有用户信息
				new ShowAllUsers();
			}
			else if(btn==showAllHouseBtn)
			{
				//显示所有房屋信息
				new ShowAllHouse();
			}
			else if(btn==updateBtn)
			{
				//修改我的信息
				//只传一个managerid过去
				new UpdateManagerInfo(manager.getManagerid());
				managerMain.dispose();
			}
			else if(btn==addUserBtn)
			{
				//增添新业主
				new AddNewUser();
			}
			else if(btn==showFeeBtn)
			{
				//查看缴费记录
				new ShowFeeRecord();
			}
			else if(btn==showRepairBtn)
			{
				//查看报修记录
				new ShowRepairRecord();
			}
			else if(btn==managerEmployeeBtn)
			{
				//管理员工
				new ShowAllEmployee();
			}
			else if(btn==massageBtn)
			{
				//短信提醒
				new NoteMain();
			}
			else if(btn==cancleBtn)
			{
				System.exit(0);
			}
				
			
		}
		
		
	}
}
