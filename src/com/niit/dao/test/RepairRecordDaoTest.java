package com.niit.dao.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.niit.dao.impl.RepairRecordDao;
import com.niit.entity.RepairRecord;

public class RepairRecordDaoTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		RepairRecordDao repairRecordDao=new RepairRecordDao();
		/**
		 * 新增报修记录
		 */
//		RepairRecord repairRecord=new RepairRecord();
//		repairRecord.setIdentity("101");
//		repairRecord.setRepairdetail("电");
//		repairRecord.setRepairtime(new Timestamp(new Date().getTime()));
//		repairRecord.setState(0);
//		repairRecord.setDealtime(new Timestamp(new Date().getTime()));
//		repairRecord.setEmployeeid(4);
//		boolean flag=repairRecordDao.addRepairRecord(repairRecord);
//		System.out.println(flag?"新增报修记录成功":"新增报修记录失败");
		
		
		/**
		 * 查询所有报修记录
		 */
//		ArrayList<RepairRecord> list=repairRecordDao.findAllRepairRecord();
//		for(RepairRecord r:list)
//		{
//			System.out.println(r.getRepairid()+"\t"+r.getIdentity()+"\t"+r.getRepairdetail()+"\t"+r.getRepairtime()+"\t"+r.getState()+"\t"+r.getDealtime()+"\t"+r.getEmployeeid());
//		}
		
		/**
		 * 根据报修id查找报修记录
		 */
//		RepairRecord repairRecord=repairRecordDao.findRepairRecordByRepairid(2);
//		if(repairRecord==null)
//		{
//			System.out.println("报修记录不存在");
//		}
//		else
//		{
//			System.out.println(repairRecord.getRepairid()+"\t"+repairRecord.getIdentity()+"\t"+repairRecord.getRepairdetail()+"\t"+repairRecord.getRepairtime()+"\t"+repairRecord.getState()+"\t"+repairRecord.getDealtime()+"\t"+repairRecord.getEmployeeid());
//		}
		
		/**
		 * 根据状态查找报修记录
		 */
//		ArrayList<RepairRecord> list=repairRecordDao.findRepairRecordByState(0);
//		for(RepairRecord r:list)
//		{
//			System.out.println(r.getRepairid()+"\t"+r.getIdentity()+"\t"+r.getRepairdetail()+"\t"+r.getRepairtime()+"\t"+r.getState()+"\t"+r.getDealtime()+"\t"+r.getEmployeeid());
//		}
		
		/**
		 * 修改报修记录表，仅限于修改dealtime处理时间，state状态，employeeid指派员工id
		 */
//		RepairRecord repairRecord1=repairRecordDao.findRepairRecordByRepairid(2);
//		RepairRecord repairRecord=new RepairRecord();
//		repairRecord.setRepairid(repairRecord1.getRepairid());
//		repairRecord.setIdentity(repairRecord1.getIdentity());
//		repairRecord.setRepairdetail(repairRecord1.getRepairdetail());
//		repairRecord.setRepairtime(repairRecord1.getRepairtime());
//		repairRecord.setState(2);
//		repairRecord.setDealtime(repairRecord1.getDealtime());
//		repairRecord.setEmployeeid(2003);
//		
//		boolean flag=repairRecordDao.modifyRepairRecord(repairRecord);
//		System.out.println(flag?"修改报修记录表成功":"修改报修记录表失败");
		
		/**
		 * 根据业主id（identity）查找
		 */
//		ArrayList<RepairRecord> list=repairRecordDao.findRepairRecordByIdentity("101");
//		for(RepairRecord r:list)
//		{
//			System.out.println(r.getRepairid()+"\t"+r.getIdentity()+"\t"+r.getRepairdetail()+"\t"+r.getRepairtime()+"\t"+r.getState()+"\t"+r.getDealtime()+"\t"+r.getEmployeeid());
//		}
		
	}

}
