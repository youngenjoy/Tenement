package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.RepairRecordDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.FeeRecord;
import com.niit.entity.House;
import com.niit.entity.RepairRecord;
import com.niit.entity.Users;

public class Repair extends JFrame
{
	private Users users;
	private UsersDao usersDao;
//	private UserMain userMain;
	private Repair repair;
	
	
	private RepairRecordDao repairRecordDao;
	private HouseDao houseDao;
	private JLabel typeLabel,detailLabel,houseLabel;
	//下拉列表框
	private JComboBox typeBox,houseBox;
	//模型
	private DefaultComboBoxModel typeBoxModel,houseBoxModel;
//	private JTextField detailTextField;
	private JTextArea area;
	private JScrollPane pane;
	private JButton submitBtn;
	
	public Repair(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		repair=this;
		repairRecordDao=new RepairRecordDao();
		houseDao=new HouseDao();
		
		this.setBounds(500, 200, 300, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("报修:"+users.getUsername());
		this.setLayout(null);
		houseLabel=new JLabel("报修的房屋：");
		houseLabel.setBounds(20, 20, 120, 20);
		typeLabel=new JLabel("类别：");
		typeLabel.setBounds(20, 70, 50, 20);
		detailLabel=new JLabel("细节");
		detailLabel.setBounds(20, 130, 50, 20);
		
		//选择报修哪个房屋
		//根据用用户查找他的房子，可能返回多个房子
		ArrayList<House> list=houseDao.findHouseByIdentity(users.getIdentity());
		int size=list.size();
		//这儿定义数组的时候一定要确定数组的长度，否则会发生数组越界错误
		String[] houseValues;
		houseValues=new String[size];
		for(int i=0;i<size;i++)
		{
			houseValues[i]=list.get(i).getHouseid()+"";
		}
		houseBoxModel=new DefaultComboBoxModel(houseValues);
		houseBox=new JComboBox(houseBoxModel);
		houseBox.setBounds(140, 20, 100, 30);
		
		
		
		
		
		//报修类别
		String[] values={"水","电","煤","其他"};
		typeBoxModel=new DefaultComboBoxModel(values);
		typeBox=new JComboBox(typeBoxModel);
		typeBox.setBounds(140, 70, 100, 30);
		
//		detailTextField=new JTextField(20);
//		detailTextField.setText("请输入报修的详细信息");
//		detailTextField.setBounds(80, 130, 150, 150);
		area=new JTextArea();
		area.setText("请输入报修的详细信息");
		area.setLineWrap(true);
		pane=new JScrollPane();
		pane.getViewport().add(area);
		pane.setBounds(80, 130, 150, 150);
		
		submitBtn=new JButton("提交");
		submitBtn.setBounds(80, 300, 85, 25);
		
		
		//监听器
		submitBtn.addActionListener(new MyBtnListener());
		this.add(submitBtn);
		this.add(detailLabel);
//		this.add(detailTextField);
		this.add(pane);
		this.add(houseBox);
		this.add(typeBox);
		this.add(typeLabel);
		this.add(houseLabel);
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
				String houseid=houseBox.getSelectedItem().toString();
				String type=typeBox.getSelectedItem().toString();
				String detail=area.getText();
				
				RepairRecord repairRecord=new RepairRecord();
				repairRecord.setIdentity(users.getIdentity());
				repairRecord.setRepairdetail(houseid+":"+type+":"+detail);
				//报修时间楔入当前系统时间
				repairRecord.setRepairtime(new Timestamp(new Date().getTime()));
				//state写入未处理0
				repairRecord.setState(0);
				//处理时间写入null
				repairRecord.setDealtime(null);
				//员工写入0
				repairRecord.setEmployeeid(0);
				
				boolean flag=repairRecordDao.addRepairRecord(repairRecord);
				JOptionPane.showMessageDialog(null, flag?"报修成功":"报修失败");
				repair.dispose();
			}
		}
		
	}
	
	
	
	
	
	
	
}
