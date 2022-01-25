package com.hotelresevation;

public class HotelReservationSystem {
	private String Name;
	private int RegularRate;
	public void Hotel(String Name ,int RegularRate)
	{
		this.Name = Name;
		this.RegularRate = RegularRate;
	}
	public String getName() 
	{
		return Name;
	}
	public void setName(String Name) 
	{
		this.Name = Name;
		public int getRegularRate() 
		{
		return RegularRate;
		}
		public void setRegularRate(int RegularRate)
		{
			this.RegularRate = RegularRate;
		}
		}
