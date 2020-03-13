package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.exception.RegistrationIdNotFoundException;
import com.demo.exception.ReservationManagementException;
import com.demo.exception.UserNameNotFoundException;
import com.demo.vo.IndoairReservationVO;


public class IndoairReservationDAO {
	public boolean addReservation(IndoairReservationVO vo) throws ReservationManagementException
	{
		String userName="root";
		String password="root123";
		String url="jdbc:mysql://localhost:3306/Project2";
		Connection connection=null;
		PreparedStatement stmt=null;
		boolean flag;
		try 
		{
			connection = DriverManager.getConnection(url, userName, password);
			String query="INSERT INTO Indoair_Reservation(Reg_id,User_name,Password ,Email)VALUES (?,?,?,?)";
			stmt=connection.prepareStatement(query);
		    stmt.setInt(1, vo.getReg_id());
		    stmt.setString(2, vo.getUser_name());
		    stmt.setString(3, vo.getPassword());
		    stmt.setString(4,vo.getEmail());		    
			stmt.executeUpdate();
			flag=true;
		}
		catch(SQLException e)
		{
			throw new ReservationManagementException("Error when adding Reservation"+e.getMessage());

		}
		finally{
			try{
				stmt.close();
				connection.close();
			}
			catch(SQLException e)
			{
				throw new ReservationManagementException("Error when adding Reservation"+e.getMessage());
			}
			}
		return flag;
		}
public IndoairReservationVO fetchReservationById(int Reg_id) throws RegistrationIdNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/Project2";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	IndoairReservationVO vo=new IndoairReservationVO();
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from Indoair_Reservation where Reg_id=?";
		stmt= connection.prepareStatement(query);
		stmt.setInt(1, Reg_id);
		rs = stmt.executeQuery();
		while(rs.next()){
			vo.setReg_id(rs.getInt("Reg_id"));
			vo.setUser_name(rs.getString("User_name"));
			vo.setPassword(rs.getString("Password"));
			vo.setEmail(rs.getString("Email"));
		}
	}catch(SQLException e)
		{
			throw new RegistrationIdNotFoundException("Error when Fetching Reg_id"+e.getMessage());
		}finally{
			try{
				stmt.close();
				connection.close();
			}catch(SQLException e){
				throw new RegistrationIdNotFoundException("Error when Fetching Reg_id"+e.getMessage());
			}
		}
	return vo;
	}

public Map<String,IndoairReservationVO> fetchReservationByName(String User_name) throws UserNameNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/Project2";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs;
	IndoairReservationVO vo=new IndoairReservationVO();
	Map<String,IndoairReservationVO> map=new HashMap<String,IndoairReservationVO>();
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from Indoair_Reservation where User_name=?";
		stmt= connection.prepareStatement(query);
		stmt.setString(1, User_name);
		rs=stmt.executeQuery();
		while(rs.next()){
			vo.setReg_id(rs.getInt("Reg_id"));
			vo.setUser_name(rs.getString("User_name"));
			vo.setPassword(rs.getString("Password"));
			vo.setEmail(rs.getString("Email"));
			map.put(User_name, vo);
			
			}	
		}
	catch(SQLException e)
	{
		throw new UserNameNotFoundException("Error when Fetching User_name"+e.getMessage());
	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new UserNameNotFoundException("Error when Fetching User_name"+e.getMessage());
		}
		}
	return map;
	}

public boolean updateReservationDetails(IndoairReservationVO vo) throws ReservationManagementException
{
	
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/Project2";
	Connection connection=null;
	PreparedStatement stmt=null;
	boolean flag;
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="update Indoair_Reservation set User_name=?,Password=?,Email=? where Reg_id=?";
		stmt= connection.prepareStatement(query);
		stmt.setString(1, vo.getUser_name());
		stmt.setString(2, vo.getPassword());
		stmt.setString(3, vo.getEmail());
		stmt.setInt(4, vo.getReg_id());
		stmt.executeUpdate();
		System.out.println("Updated the Reservation Details Successfully...");
	flag=true;
	}
	catch(SQLException e)
	{
		throw new ReservationManagementException("Error when updating Reservation"+e.getMessage());
	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new ReservationManagementException("Error when updating Reservation"+e.getMessage());
}
}
	return flag;
}
}