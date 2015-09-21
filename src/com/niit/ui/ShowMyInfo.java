package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class ShowMyInfo extends JFrame
{
	private UsersDao usersDao;
	
	private ShowMyInfo showMyInfo;
//	private UserMain userMain;
	private Users users;
	private JLabel identityLabel,nameLabel,pwdLabel,phoneLabel,balanceLabel,identity,name,pwd,phone,balance;
	private JButton updateMyInfo;
	
	
//	private String loginIdentity;
	
	public ShowMyInfo(String loginIdentity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(loginIdentity);
//		this.userMain=userMain;
		showMyInfo=this;
		
		
		this.setBounds(500, 200, 300, 300);
		this.setTitle("我的信息");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		identityLabel=new JLabel("身份证:");
		identityLabel.setBounds(20, 20, 50, 25);
		nameLabel=new JLabel("姓名:");
		nameLabel.setBounds(20, 50, 50, 25);
		pwdLabel=new JLabel("密码：");
		pwdLabel.setBounds(20, 80, 50, 25);
		phoneLabel=new JLabel("电话：");
		phoneLabel.setBounds(20, 110, 50, 25);
		balanceLabel=new JLabel("余额");
		balanceLabel.setBounds(20, 140, 50, 25);
		
		identity=new JLabel();
//		identity.setText(userMain.getUsers().getIdentity());
		identity.setText(users.getIdentity());
		identity.setBounds(80, 20, 100, 25);
		name=new JLabel();
		name.setText(users.getUsername());
		name.setBounds(80, 50, 100, 25);
		pwd=new JLabel();
		pwd.setText(users.getPwd());
		pwd.setBounds(80, 80, 100, 25);
		phone=new JLabel();
		phone.setText(users.getPhone());
		phone.setBounds(80, 110, 100, 25);
		balance=new JLabel();
		balance.setText(users.getBalance()+"");
		balance.setBounds(80, 140,100, 25);
		
		updateMyInfo=new JButton("修改我的信息");
		updateMyInfo.setBounds(50, 180, 120, 25);
		//监听器
		updateMyInfo.addActionListener(new MyBtnListener());
		this.add(updateMyInfo);
		this.add(balance);
		this.add(phone);
		this.add(pwd);
		this.add(name);
		this.add(identity);
		this.add(balanceLabel);
		this.add(phoneLabel);
		this.add(pwdLabel);
		this.add(nameLabel);
		this.add(identityLabel);
		this.setVisible(true);
		
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton btn=(JButton)e.getSource();
			
			if(btn==updateMyInfo)
			{
				//修改我的信息
//				users=userMain.getUsers();
				
				
				new UpdateMyInfo(users.getIdentity());
				showMyInfo.dispose();
				
				
			}
			
		}
		
	}

//	public Users getUsers() {
//		return users;
//	}
//
//	public void setUsers(Users users) {
//		this.users = users;
//	}
	
	
	

}
