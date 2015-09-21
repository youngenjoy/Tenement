package com.niit.entity;
/**
 * 房屋id(houseid)，面积(area)，地址(adress)，总价(price)，业主identity
 * @author Administrator
 *
 */
public class House
{
	private int houseid;
	private double area;
	private String adress;
	private double price;
	private String identity;
	public House(int houseid, double area, String adress, double price,
			String identity)
	{
		super();
		this.houseid = houseid;
		this.area = area;
		this.adress = adress;
		this.price = price;
		this.identity = identity;
	}
	public House()
	{
		super();
	}
	public int getHouseid()
	{
		return houseid;
	}
	public void setHouseid(int houseid)
	{
		this.houseid = houseid;
	}
	public double getArea()
	{
		return area;
	}
	public void setArea(double area)
	{
		this.area = area;
	}
	public String getAdress()
	{
		return adress;
	}
	public void setAdress(String adress)
	{
		this.adress = adress;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public String getIdentity()
	{
		return identity;
	}
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}
	
	
}
