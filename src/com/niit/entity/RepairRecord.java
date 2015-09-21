package com.niit.entity;

import java.sql.Timestamp;

public class RepairRecord
{
	private int repairid;
	private String identity;
	private String repairdetail;
	private Timestamp repairtime;
	private int state;
	private Timestamp dealtime;
	private int employeeid;
	
	public RepairRecord(int repairid, String identity, String repairdetail,
			Timestamp repairtime, int state, Timestamp dealtime, int employeeid) {
		super();
		this.repairid = repairid;
		this.identity = identity;
		this.repairdetail = repairdetail;
		this.repairtime = repairtime;
		this.state = state;
		this.dealtime = dealtime;
		this.employeeid = employeeid;
	}
	public RepairRecord()
	{
		super();
	}

	public int getRepairid() {
		return repairid;
	}
	public void setRepairid(int repairid) {
		this.repairid = repairid;
	}
	public String getIdentity()
	{
		return identity;
	}
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}
	public String getRepairdetail()
	{
		return repairdetail;
	}
	public void setRepairdetail(String repairdetail)
	{
		this.repairdetail = repairdetail;
	}
	public Timestamp getRepairtime()
	{
		return repairtime;
	}
	public void setRepairtime(Timestamp repairtime)
	{
		this.repairtime = repairtime;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}
	public Timestamp getDealtime()
	{
		return dealtime;
	}
	public void setDealtime(Timestamp dealtime)
	{
		this.dealtime = dealtime;
	}
	public int getEmployeeid()
	{
		return employeeid;
	}
	public void setEmployeeid(int employeeid)
	{
		this.employeeid = employeeid;
	}
	
	
}
