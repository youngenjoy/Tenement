package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.EmployeeDao;
import com.niit.entity.Employee;

public class AddNewEmployee extends JFrame
{
	private EmployeeDao employeeDao;
	private JLabel empIdLabel,empNameLabel,jobLabel,phoneLabel;
	private JTextField empIdTextField,empNameTextField,phoneTextField;
	//工作类型用下拉列表框
	private JComboBox jobBox;
	//模型
	private DefaultComboBoxModel jobBoxModel;
	
	private JButton submitBtn;
	
	
	public AddNewEmployee()
	{
		this.setBounds(500, 300, 300, 300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("增加新员工");
		this.setLayout(null);
		
		empIdLabel=new JLabel("员工id：");
		empIdLabel.setBounds(50, 20, 80, 20);
		empNameLabel=new JLabel("员工姓名：");
		empNameLabel.setBounds(35, 50,80, 20);
		jobLabel=new JLabel("工作类型：");
		jobLabel.setBounds(35, 80, 80, 20);
		phoneLabel=new JLabel("电话：");
		phoneLabel.setBounds(60, 110, 80, 20);
		
		empIdTextField=new JTextField(20);
		empIdTextField.setBounds(120, 20, 100, 20);
		empNameTextField=new JTextField(20);
		empNameTextField.setBounds(120, 50, 100, 20);
		
		String[] values={"水","电","煤","其他"};
		jobBoxModel=new DefaultComboBoxModel(values);
		jobBox=new JComboBox(jobBoxModel);
		jobBox.setBounds(120, 80, 100, 20);
		
		phoneTextField=new JTextField(20);
		phoneTextField.setBounds(120, 110, 100, 20);
		
		submitBtn=new JButton("提交");
		submitBtn.setBounds(80, 150, 85, 20);
		
		submitBtn.addActionListener(new MyBtnListener());
		this.add(submitBtn);
		this.add(phoneTextField);
		this.add(jobBox);
		this.add(empNameTextField);
		this.add(empIdTextField);
		this.add(phoneLabel);
		this.add(jobLabel);
		this.add(empNameLabel);
		this.add(empIdLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
			employeeDao=new EmployeeDao();
			if(btn==submitBtn)
			{
				int empId=Integer.parseInt(empIdTextField.getText());
				String empName=empNameTextField.getText();
				String job=jobBox.getSelectedItem().toString();
				String phone=phoneTextField.getText();
				
				Employee employee=new Employee();
				
				employee.setEmployeeid(empId);
				employee.setEmployeename(empName);
				employee.setJob(job);
				employee.setPhone(phone);
				boolean flag=employeeDao.addEmployee(employee);
				JOptionPane.showMessageDialog(null, flag?"新增员工成功":"新增员工失败");
			}
			
		}
		
	}
}
	