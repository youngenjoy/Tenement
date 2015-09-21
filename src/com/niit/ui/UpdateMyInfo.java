package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class UpdateMyInfo extends JFrame 
{
	private Users users;
	private UsersDao usersDao;
//	private ShowMyInfo showMyInfo;
	private UpdateMyInfo updateMyInfo;
	private JLabel identityLabel,nameLabel,pwdLabel,phoneLabel,balanceLabel;
	private JTextField identityTextField,nameTextField,pwdTextField,phoneTextField,balanceTextField;
	private JButton submitBtn;
	
	public UpdateMyInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.showMyInfo=showMyInfo;
		updateMyInfo=this;
		this.setBounds(500, 200, 300, 300);
		this.setTitle("修改我的信息:"+users.getUsername());
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
		
		identityTextField=new JTextField(20);
		identityTextField.setBounds(80, 20, 100, 25);
		identityTextField.setText(users.getIdentity());
		//设置身份证不可编辑
		identityTextField.setEditable(false);
		nameTextField=new JTextField(20);
		nameTextField.setBounds(80, 50, 100, 25);
		nameTextField.setText(users.getUsername());
		pwdTextField=new JTextField(20);
		pwdTextField.setBounds(80, 80, 100, 25);
		pwdTextField.setText(users.getPwd());
		phoneTextField=new JTextField(20);
		phoneTextField.setBounds(80, 110, 100, 25);
		phoneTextField.setText(users.getPhone());
		balanceTextField=new JTextField(20);
		balanceTextField.setBounds(80, 140, 100, 25);
		balanceTextField.setText(users.getBalance()+"");
		//设置余额不可编辑
		balanceTextField.setEditable(false);
		
		submitBtn=new JButton("确认修改");
		submitBtn.setBounds(100, 180, 120, 30);
		// 监听器
		submitBtn.addActionListener(new MyBtnListener());
		
		this.add(submitBtn);
		this.add(balanceTextField);
		this.add(phoneTextField);
		this.add(pwdTextField);
		this.add(nameTextField);
		this.add(identityTextField);
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
			if(btn==submitBtn)
			{
				UsersDao usersDao=new UsersDao();
				Users user1=usersDao.findUsersByIdentity(identityTextField.getText());
				Users user=new Users();
				user.setIdentity(user1.getIdentity());
				user.setUsername(nameTextField.getText());
				user.setPwd(pwdTextField.getText());
				user.setPhone(phoneTextField.getText());
				user.setBalance(Integer.parseInt(balanceTextField.getText()));
				
				boolean flag=usersDao.modifyUsers(user);
				if(flag)
				{
					JOptionPane.showMessageDialog(null, "修改成功");
					//把更新界面关掉
					updateMyInfo.dispose();
					//？？？？？如何把usermain关掉
//					Login login=new Login();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "修改失败");
					updateMyInfo.dispose();
				}
				
				
			}
			
		}
	}
	
}
