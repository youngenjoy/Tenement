package com.niit.ui;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.House;
import com.niit.entity.Users;




public class UserMain extends JFrame
{
	private UsersDao usersDao;
//	private Login login;
	private Users users;
	private UserMain userMain;
	
	
	private JToolBar toolBarUp;
	private JButton myInfoBtn,cancleBtn,myHouseInfoBtn,feeInfoBtn,repairInfoBtn,feeBtn,repairBtn,addmoneyBtn;
	private JPanel pnl;
	
	
	public UserMain(String userName)
	{
		usersDao=new UsersDao();
//		this.login=login;
		userMain=this;
		this.users=usersDao.findUsersByUsername(userName);
//		this.setBounds(200, 100, 800, 500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("业主："+users.getUsername());
//		this.setLayout(null);
		
		toolBarUp=new JToolBar();
//		toolBarUp.setBounds(0, 0, 800, 40);
		myInfoBtn=new JButton("我的信息");
		myHouseInfoBtn=new JButton("我的房屋");
		feeInfoBtn=new JButton("我的缴费信息");
		repairInfoBtn=new JButton("我的报修信息");
		feeBtn=new JButton("缴费 ");
		repairBtn=new JButton("报修");
		addmoneyBtn=new JButton("充值");
		cancleBtn=new JButton("退出");
		
		toolBarUp.add(myInfoBtn);
		toolBarUp.add(myHouseInfoBtn);
		toolBarUp.add(feeInfoBtn);
		toolBarUp.add(repairInfoBtn);
		toolBarUp.add(feeBtn);
		toolBarUp.add(repairBtn);
		toolBarUp.add(addmoneyBtn);
		toolBarUp.add(cancleBtn);
		//设置toolBar不可浮动
		toolBarUp.setFloatable(false);
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Image image=tool.getImage("image//user.jpg");
		this.setIconImage(image);
		
		pnl=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				Image image=Toolkit.getDefaultToolkit().getImage("image//10.jpg");
				g.drawImage(image, 0, 0, userMain.getWidth(),userMain.getHeight(),userMain);
			}
		};
		
		
		
		
		//添加监听器
		myInfoBtn.addActionListener(new MyBtnListener());
		myHouseInfoBtn.addActionListener(new MyBtnListener());
		feeInfoBtn.addActionListener(new MyBtnListener());
		repairInfoBtn.addActionListener(new MyBtnListener());
		feeBtn.addActionListener(new MyBtnListener());
		repairBtn.addActionListener(new MyBtnListener());
		addmoneyBtn.addActionListener(new MyBtnListener());
		cancleBtn.addActionListener(new MyBtnListener());
		
		this.add(pnl,BorderLayout.CENTER);
		this.add(toolBarUp,BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			users=login.getUsersDao().findUsersByUsername(login.getName());//拿到上面写，赋值给当前全局变量users
			if(btn==myInfoBtn)
			{
				//查看我的信息
				new ShowMyInfo(users.getIdentity());
			}
			else if(btn==myHouseInfoBtn)
			{
				//查看我的房屋信息
				new ShowMyHouseInfo(users.getIdentity());
			}
			else if(btn==feeInfoBtn)
			{
				//查看我的缴费信息
				new ShowMyFeeRecordInfo(users.getIdentity());
			}
			else if(btn==repairInfoBtn)
			{
				//查看我的报修信息
				new ShowMyRepaireRecordInfo(users.getIdentity());
			}
			else if(btn==feeBtn)
			{
				//缴费按钮
				new Fee(users.getIdentity());
			}
			else if(btn==repairBtn)
			{
				//报修按钮
				new Repair(users.getIdentity());
			}
			else if(btn==addmoneyBtn)
			{
				//充值按钮
				new AddMoney(users.getIdentity());
			}
			else if(btn==cancleBtn)
			{
				System.exit(0);
			}
		}
		
	}

//	public Users getUsers()
//	{
//		return users;
//	}
//
//	public void setUsers(Users users)
//	{
//		this.users = users;
//	}
	

}
