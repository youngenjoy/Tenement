package com.niit.dao.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


import com.niit.dao.impl.FeeRecordDao;
import com.niit.entity.FeeRecord;

public class FeeRecordDaoTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		FeeRecordDao feeRecordDao=new FeeRecordDao();
		
		/**
		 * 新增缴费记录
		 */
//		FeeRecord feeRecord=new FeeRecord();
//		feeRecord.setIdentity("101");
//		feeRecord.setFee(200);
//		feeRecord.setPass(0);
//		feeRecord.setFeetime(new Timestamp(new Date().getTime()));
//		feeRecord.setExamtime(new Timestamp(new Date().getTime()));
//		
//		boolean flag=feeRecordDao.addFeeRecord(feeRecord);
//		System.out.println(flag?"新增缴费记录成功":"新增缴费记录失败");
		
		/**
		 * 查找所有缴费记录
		 */
//		ArrayList<FeeRecord> list=feeRecordDao.findAllFeeRecord();
//		for(FeeRecord f:list)
//		{
//			System.out.println(f.getFeeid()+"\t"+f.getIdentity()+"\t"+f.getFee()+"\t"+f.getPass()+"\t"+f.getFeetime()+"\t"+f.getExamtime());
//		}
		
		/**
		 * 根据feeid查找缴费记录
		 */
//		FeeRecord feeRecord=feeRecordDao.findFeeRecordByFeeid(2);
//		if(feeRecord==null)
//		{
//			System.out.println("不存在该缴费记录");
//		}
//		else
//		{
//			System.out.println(feeRecord.getFeeid()+"\t"+feeRecord.getIdentity()+"\t"+feeRecord.getFee()+"\t"+feeRecord.getPass()+"\t"+feeRecord.getFeetime()+"\t"+feeRecord.getExamtime());
//		}
		
		/**
		 * 根据identity查找缴费记录，可能返回多条数据
		 */
//		ArrayList<FeeRecord> list=feeRecordDao.findFeeRecordByIdentity("101");
//		for(FeeRecord f:list)
//		{
//			System.out.println(f.getFeeid()+"\t"+f.getIdentity()+"\t"+f.getFee()+"\t"+f.getPass()+"\t"+f.getFeetime()+"\t"+f.getExamtime());
//		}
		
		/**
		 * 根据是否通过查找pass
		 */
//		ArrayList<FeeRecord> list=feeRecordDao.findFeeRecordByPass(1);
//		for(FeeRecord f:list)
//		{
//			System.out.println(f.getFeeid()+"\t"+f.getIdentity()+"\t"+f.getFee()+"\t"+f.getPass()+"\t"+f.getFeetime()+"\t"+f.getExamtime());
//		}
		
		/**
		 * 修改缴费记录
		 */
//		FeeRecord feeRecord1=feeRecordDao.findFeeRecordByFeeid(1);
//		FeeRecord feeRecord=new FeeRecord();
//		feeRecord.setFeeid(feeRecord1.getFeeid());
//		feeRecord.setIdentity(feeRecord1.getIdentity());
//		feeRecord.setFee(feeRecord1.getFee());
//		feeRecord.setPass(1);
//		feeRecord.setFeetime(feeRecord1.getFeetime());
//		feeRecord.setExamtime(new Timestamp(new Date().getTime()));
//		
//		boolean flag=feeRecordDao.modifyFeeRecord(feeRecord);
//		System.out.println(flag?"修改缴费记录成功":"修改缴费记录失败");
		
		
		
		

	}

}
