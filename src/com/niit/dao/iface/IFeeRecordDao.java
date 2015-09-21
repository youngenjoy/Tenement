package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.FeeRecord;

public interface IFeeRecordDao
{
	/**
	 * 新增缴费记录
	 */
	public abstract boolean addFeeRecord(FeeRecord feerecord);
	
	/**
	 * 修改缴费记录,只能修改状态state和通过时间examtime
	 * @param feeid
	 * @return
	 */
	public abstract boolean modifyFeeRecord(FeeRecord feerecord);
	
	/**
	 * 查找所有缴费记录
	 * @return
	 */
	public abstract ArrayList<FeeRecord> findAllFeeRecord();
	
	/**
	 * 根据编号查找缴费记录
	 */
	public abstract FeeRecord findFeeRecordByFeeid(int feeid);
	
	/**
	 * 根据identity查找缴费记录，返回多条记录
	 */
	public abstract ArrayList<FeeRecord> findFeeRecordByIdentity(String identity);
	
	/**
	 * 根据pass查找
	 */
	public abstract ArrayList<FeeRecord> findFeeRecordByPass(int pass);
	
	
	
}
