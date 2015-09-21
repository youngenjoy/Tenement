package com.niit.entity;

import java.sql.Timestamp;

public class FeeRecord
{
	private int feeid;
	private String identity;
	private int fee;
	private int pass;
	private Timestamp feetime;
	private Timestamp examtime;
	public FeeRecord(int feeid, String identity, int fee, int pass,
			Timestamp feetime, Timestamp examtime)
	{
		super();
		this.feeid = feeid;
		this.identity = identity;
		this.fee = fee;
		this.pass = pass;
		this.feetime = feetime;
		this.examtime = examtime;
	}
	public FeeRecord()
	{
		super();
	}
	public int getFeeid()
	{
		return feeid;
	}
	public void setFeeid(int feeid)
	{
		this.feeid = feeid;
	}
	public String getIdentity()
	{
		return identity;
	}
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}
	public int getFee()
	{
		return fee;
	}
	public void setFee(int fee)
	{
		this.fee = fee;
	}
	public int getPass()
	{
		return pass;
	}
	public void setPass(int pass)
	{
		this.pass = pass;
	}
	public Timestamp getFeetime()
	{
		return feetime;
	}
	public void setFeetime(Timestamp feetime)
	{
		this.feetime = feetime;
	}
	public Timestamp getExamtime()
	{
		return examtime;
	}
	public void setExamtime(Timestamp examtime)
	{
		this.examtime = examtime;
	}
	
	
}
