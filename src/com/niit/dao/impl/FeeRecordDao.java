package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IFeeRecordDao;
import com.niit.entity.FeeRecord;

public class FeeRecordDao extends BaseDao implements IFeeRecordDao
{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	@Override
	public boolean addFeeRecord(FeeRecord feerecord)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				//使用预处理器
				pstmt=con.prepareStatement("insert into feerecord values(repairid.nextval,?,?,?,?,?)");
				//注入参数
				pstmt.setString(1, feerecord.getIdentity());
				pstmt.setInt(2, feerecord.getFee());
				pstmt.setInt(3, feerecord.getPass());
				pstmt.setTimestamp(4, feerecord.getFeetime());
				pstmt.setTimestamp(5, feerecord.getExamtime());
				
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
	public ArrayList<FeeRecord> findAllFeeRecord()
	{
		ArrayList<FeeRecord> list=new ArrayList<FeeRecord>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from feerecord");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					FeeRecord feeRecord=new FeeRecord();
					feeRecord.setFeeid(rs.getInt(1));
					feeRecord.setIdentity(rs.getString(2));
					feeRecord.setFee(rs.getInt(3));
					feeRecord.setPass(rs.getInt(4));
					feeRecord.setFeetime(rs.getTimestamp(5));
					feeRecord.setExamtime(rs.getTimestamp(6));
					list.add(feeRecord);
					
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
	public FeeRecord findFeeRecordByFeeid(int feeid)
	{
		FeeRecord feeRecord=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from feerecord where feeid=?");
				pstmt.setInt(1, feeid);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					feeRecord=new FeeRecord(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5), rs.getTimestamp(6));
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
		return feeRecord;
	}

	@Override
	public ArrayList<FeeRecord> findFeeRecordByIdentity(String identity)
	{
		ArrayList<FeeRecord> list=new ArrayList<FeeRecord>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from feerecord where identity=?");
				
				//注入参数
				pstmt.setString(1, identity);
				//执行
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					FeeRecord feeRecord=new FeeRecord();
					feeRecord.setFeeid(rs.getInt(1));
					feeRecord.setIdentity(rs.getString(2));
					feeRecord.setFee(rs.getInt(3));
					feeRecord.setPass(rs.getInt(4));
					feeRecord.setFeetime(rs.getTimestamp(5));
					feeRecord.setExamtime(rs.getTimestamp(6));
					list.add(feeRecord);
					
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
	public boolean modifyFeeRecord(FeeRecord feerecord)
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				// 使用预处理器
				pstmt=con.prepareStatement("update feerecord set pass=?,examtime=? where feeid=?");
				//注入参数
				pstmt.setInt(1, feerecord.getPass());
				pstmt.setTimestamp(2, feerecord.getExamtime());
				pstmt.setInt(3, feerecord.getFeeid());
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
	public ArrayList<FeeRecord> findFeeRecordByPass(int pass)
	{
		ArrayList<FeeRecord> list=new ArrayList<FeeRecord>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from feerecord where pass=?");
				//注入参数
				pstmt.setInt(1, pass);
				//执行
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					FeeRecord feeRecord=new FeeRecord();
					feeRecord.setFeeid(rs.getInt(1));
					feeRecord.setIdentity(rs.getString(2));
					feeRecord.setFee(rs.getInt(3));
					feeRecord.setPass(rs.getInt(4));
					feeRecord.setFeetime(rs.getTimestamp(5));
					feeRecord.setExamtime(rs.getTimestamp(6));
					list.add(feeRecord);
					
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

}
