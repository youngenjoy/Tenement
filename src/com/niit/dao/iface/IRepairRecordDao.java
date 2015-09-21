package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.RepairRecord;

public interface IRepairRecordDao 
{
	/**
	 * 新增报修记录
	 * @param repairrecord
	 * @return
	 */
	public abstract boolean addRepairRecord(RepairRecord repairrecord);
	
	
	/**
	 * 修改报修记录表
	 * @param repairrecord
	 * @return
	 */
	public abstract boolean modifyRepairRecord(RepairRecord repairrecord);
	
	/**
	 * 查看所有报修记录
	 * @return
	 */
	public abstract ArrayList<RepairRecord> findAllRepairRecord();
	
	
	/**
	 * 根据报修id查找报修
	 * @return
	 */
	public abstract RepairRecord findRepairRecordByRepairid(int repairid);
	
	/**
	 * 根据业主id查找报修记录，可能返回多条记录
	 * @param identity
	 * @return
	 */
	public abstract ArrayList<RepairRecord> findRepairRecordByIdentity(String identity);
	
	/**
	 * 根据状态state查找报修记录
	 * @param state
	 * @return
	 */
	public abstract ArrayList<RepairRecord> findRepairRecordByState(int state);
	
	
}
