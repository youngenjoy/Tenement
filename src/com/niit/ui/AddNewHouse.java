package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.HouseDao;
import com.niit.entity.House;

public class AddNewHouse extends JFrame
{
	private String identity;
	private HouseDao houseDao;
	
	private AddNewHouse addNewHouse;
	
	private JLabel houseIdLabel,areaLabel,adressLabel,priceLabel,identityLabel;
	private JTextField houseIdTextField,areaTextField,adressTextField,priceTextField,identityTextField;
	private JButton submitBtn;
	
	
	public AddNewHouse(String identity)
	{
		addNewHouse=this;
		this.identity=identity;
		this.setBounds(500, 300, 300, 300);
		this.setTitle("新增房屋:"+identity);
		this.setLayout(null);
		
		
		houseIdLabel=new JLabel("房屋id：");
		houseIdLabel.setBounds(20, 20, 50, 20);
		areaLabel=new JLabel("面积：");
		areaLabel.setBounds(20, 50, 50, 20);
		adressLabel=new JLabel("地址：");
		adressLabel.setBounds(20, 80, 50, 20);
		priceLabel=new JLabel("价格");
		priceLabel.setBounds(20, 110, 50, 20);
		identityLabel=new JLabel("业主id：");
		identityLabel.setBounds(20, 140, 50, 20);
		
		houseIdTextField=new JTextField(20);
		houseIdTextField.setBounds(80, 20, 100, 20);
		areaTextField=new JTextField(20);
		areaTextField.setBounds(80, 50, 100, 20);
		adressTextField=new JTextField(20);
		adressTextField.setBounds(80, 80, 100, 20);
		priceTextField=new JTextField(20);
		priceTextField.setBounds(80, 110, 100, 20);
		identityTextField=new JTextField(20);
		identityTextField.setText(identity);
		identityTextField.setEditable(false);
		identityTextField.setBounds(80, 140, 100, 20);
		
		submitBtn=new JButton("提交");
		submitBtn.setBounds(100, 170, 85, 20);
		
		
		
		submitBtn.addActionListener(new MyBtnListener());
		this.add(submitBtn);
		this.add(identityTextField);
		this.add(priceTextField);
		this.add(adressTextField);
		this.add(areaTextField);
		this.add(houseIdTextField);
		this.add(identityLabel);
		this.add(priceLabel);
		this.add(adressLabel);
		this.add(areaLabel);
		this.add(houseIdLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
			houseDao=new HouseDao();
			if(btn==submitBtn)
			{

				House house=new House();
				house.setHouseid(Integer.parseInt(houseIdTextField.getText()));
				house.setArea(Double.parseDouble(areaTextField.getText()));
				house.setAdress(adressTextField.getText());
				house.setPrice(Integer.parseInt(priceTextField.getText()));
				house.setIdentity(identity);
				boolean flag=houseDao.addHouse(house);
				
				if(flag)
				{
					JOptionPane.showMessageDialog(null, "添加房屋成功");
					addNewHouse.dispose();
				}
				
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
