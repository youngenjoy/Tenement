package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IRepairRecordDao;
import com.niit.entity.RepairRecord;

public class RepairRecordDao extends BaseDao implements IRepairRecordDao 
{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	@Override
	public boolean addRepairRecord(RepairRecord repairrecord) 
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				//使用预处理器
				pstmt=con.prepareStatement("insert into repairrecord values(repairid.nextval,?,?,?,?,?,?)");
				//注入参数
				pstmt.setString(1, repairrecord.getIdentity());
				pstmt.setString(2, repairrecord.getRepairdetail());
				pstmt.setTimestamp(3, repairrecord.getRepairtime());
				pstmt.setInt(4, repairrecord.getState());
				pstmt.setTimestamp(5, repairrecord.getDealtime());
				pstmt.setInt(6, repairrecord.getEmployeeid());
				
				//执行SQL语句
				int count=pstmt.executeUpdate();
				if(count==1)
				{
					flag=true;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	@Override
	public ArrayList<RepairRecord> findAllRepairRecord() 
	{
		ArrayList<RepairRecord> list=new ArrayList<RepairRecord>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from repairrecord");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					RepairRecord repairRecord=new RepairRecord();
					repairRecord.setRepairid(rs.getInt(1));
					repairRecord.setIdentity(rs.getString(2));
					repairRecord.setRepairdetail(rs.getString(3));
					repairRecord.setRepairtime(rs.getTimestamp(4));
					repairRecord.setState(rs.getInt(5));
					repairRecord.setDealtime(rs.getTimestamp(6));
					repairRecord.setEmployeeid(rs.getInt(7));
					list.add(repairRecord);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public ArrayList<RepairRecord> findRepairRecordByIdentity(String identity) 
	{
		ArrayList<RepairRecord> list=new ArrayList<RepairRecord>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from repairrecord where identity=?");
				//注入参数
				pstmt.setString(1, identity);
				//执行
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					RepairRecord repairRecord=new RepairRecord();
					repairRecord.setRepairid(rs.getInt(1));
					repairRecord.setIdentity(rs.getString(2));
					repairRecord.setRepairdetail(rs.getString(3));
					repairRecord.setRepairtime(rs.getTimestamp(4));
					repairRecord.setState(rs.getInt(5));
					repairRecord.setDealtime(rs.getTimestamp(6));
					repairRecord.setEmployeeid(rs.getInt(7));
					list.add(repairRecord);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public RepairRecord findRepairRecordByRepairid(int repairid) 
	{
		RepairRecord repairRecord=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from repairrecord where repairid=?");
				pstmt.setInt(1, repairid);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					repairRecord=new RepairRecord(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getTimestamp(6), rs.getInt(7));
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return repairRecord;
	}

	@Override
	public ArrayList<RepairRecord> findRepairRecordByState(int state) 
	{
		ArrayList<RepairRecord> list=new ArrayList<RepairRecord>();
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from repairrecord where state=?");
				//注入参数
				pstmt.setInt(1, state);
				//执行
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					RepairRecord repairRecord=new RepairRecord();
					repairRecord.setRepairid(rs.getInt(1));
					repairRecord.setIdentity(rs.getString(2));
					repairRecord.setRepairdetail(rs.getString(3));
					repairRecord.setRepairtime(rs.getTimestamp(4));
					repairRecord.setState(rs.getInt(5));
					repairRecord.setDealtime(rs.getTimestamp(6));
					repairRecord.setEmployeeid(rs.getInt(7));
					list.add(repairRecord);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public boolean modifyRepairRecord(RepairRecord repairrecord) 
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				// 使用预处理器
				pstmt=con.prepareStatement("update repairrecord set state=?,dealtime=?,employeeid=? where repairid=?");
				//注入参数
				pstmt.setInt(1, repairrecord.getState());
				pstmt.setTimestamp(2, repairrecord.getDealtime());
				pstmt.setInt(3, repairrecord.getEmployeeid());
				pstmt.setInt(4, repairrecord.getRepairid());
				//执行SQL语句
				int count=pstmt.executeUpdate();
				if(count==1)
				{
					flag=true;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

}
