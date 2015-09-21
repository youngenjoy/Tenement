package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.FeeRecordDao;
import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.FeeRecord;
import com.niit.entity.House;
import com.niit.entity.Users;

public class Fee extends JFrame
{
	private Users users;
//	private UserMain userMain;
	private Fee fee;
	private FeeRecordDao feeRecordDao;
	private HouseDao houseDao;
	private UsersDao usersDao;
	
									   //每平米物业费
	private JLabel feeLabel,houseLabel,priceLabel;
	private JTextField feeTextField;
	private JButton submitBtn;
	
	//下拉列表框
	private JComboBox box;
	//模型
	private DefaultComboBoxModel boxModel;
	public Fee(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		fee=this;
		feeRecordDao=new FeeRecordDao();
		houseDao=new HouseDao();
		this.setBounds(300, 200, 300,250);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("缴费:"+users.getUsername());
		this.setLayout(null);
		
		houseLabel=new JLabel("您要缴费的房屋：");
		houseLabel.setBounds(20, 20, 150, 20);
		feeLabel=new JLabel("您当前应缴费的面积：");
		feeLabel.setBounds(20, 60, 200, 20);
		
		//获取当前用户的房子，可能返回多个值
		ArrayList<House> list=houseDao.findHouseByIdentity(users.getIdentity());
		
		int size=list.size();
		//这儿定义数组的时候一定要确定数组的长度，否则会发生数组越界错误
		String[] values;
		values=new String[size];
		for(int i=0;i<size;i++)
		{
			values[i]=list.get(i).getHouseid()+"";
		}
		
		boxModel=new DefaultComboBoxModel(values);
		box=new JComboBox(boxModel);
		box.setBounds(150, 20, 80, 20);
		
//		System.out.println(box.getSelectedItem());
		
		//获取选中的房子
		House house=houseDao.findHouseByHouseid(Integer.parseInt( box.getSelectedItem().toString()));
		//获取房子的面积
		double area=house.getArea();

		
		feeTextField=new JTextField(20);
		feeTextField.setText(area+"");
		feeTextField.setEditable(false);
		feeTextField.setBounds(150, 60, 50, 20);
		priceLabel=new JLabel("平米*1.5元/平米");
		priceLabel.setBounds(200, 60, 100, 20);
		submitBtn=new JButton("确认缴费");
		submitBtn.setBounds(100, 100, 100, 20);
		
		//监听器
		submitBtn.addActionListener(new MyBtnListener());
		box.addItemListener(new MyItemListener());
		this.add(box);
		this.add(submitBtn);
		this.add(feeTextField);
		this.add(feeLabel);
		this.add(priceLabel);
		this.add(houseLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton btn=(JButton)e.getSource();
			usersDao=new UsersDao();
			if(btn==submitBtn)
			{
				//房子的面积
				double myarea=Double.parseDouble(feeTextField.getText());
				//面积乘以价格，暂定1.5元每平方米
				//物业费
				int money=(int)(myarea*1.5);
				if((users.getBalance()>money)&&(users.getBalance()>0))
				{
					FeeRecord feeRecord=new FeeRecord();
					feeRecord.setIdentity(users.getIdentity());
					feeRecord.setFee(money);
					//状态写入0表示未处理
					feeRecord.setPass(0);
					//缴费时间写入当前系统时间
					feeRecord.setFeetime(new Timestamp(new Date().getTime()));
					//处理时间写入null
					feeRecord.setExamtime(null);
					
					boolean flag=feeRecordDao.addFeeRecord(feeRecord);
					JOptionPane.showMessageDialog(null, flag?"缴费成功":"缴费失败");
					
					//缴费成功需要扣除业主相应的费用
					if(flag)
					{
						//修改业主的balance信息
						Users user=new Users();
						user.setIdentity(users.getIdentity());
						user.setUsername(users.getUsername());
						user.setPwd(users.getPwd());
						user.setPhone(users.getPhone());
						user.setBalance(users.getBalance()-money);//扣掉应缴的费用
						//修改操作
						usersDao.modifyUsers(user);
						
					}
					fee.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "余额不足，请充值");
				}
				
				
				
			}
			
		}
		
	}
	
	public class MyItemListener implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				int num=box.getSelectedIndex();
			
				House house=houseDao.findHouseByHouseid(Integer.parseInt( box.getSelectedItem().toString()));
				//获取房子的面积
				double area=house.getArea();
				//把textfile里放入面积
				feeTextField.setText(area+"");
			}
			
		}
		
	}
	
	
	
	
	
}
