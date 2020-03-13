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

import com.demo.exception.SourceManagementException;
import com.demo.exception.SourceNotFoundException;
import com.demo.vo.PassengerDetailsVO;
import com.demo.vo.SourceVO;

public class SourceDAO {
	public boolean addSourceDetails(SourceVO vo) throws SourceManagementException
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
			String query="INSERT INTO Source(Source_id,Source_name)VALUES (?,?)";
			stmt= connection.prepareStatement(query);
			stmt.setInt(1, vo.getSource_id());
			stmt.setString(2, vo.getSource_name());
		    stmt.executeUpdate();
		    flag=true;
		}
		catch(SQLException e)
		{
			throw new SourceManagementException("Error when adding Source Details"+e.getMessage());

		}
		finally{
			try{
				stmt.close();
				connection.close();
			}
			catch(SQLException e)
			{
				throw new SourceManagementException("Error when adding Source Details"+e.getMessage());
			}
			}
		return flag;
		}

public SourceVO fetchSourceById(int Source_id) throws SourceNotFoundException 
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/Project2";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	SourceVO vo=new SourceVO();	
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from Source where Source_id=?";
		stmt= connection.prepareStatement(query);
		stmt.setInt(1, Source_id);
		rs = stmt.executeQuery();
		while(rs.next()){
			vo.setSource_id(rs.getInt("Source_id"));
			vo.setSource_name(rs.getString("Source_name"));
		}
	}
	catch(SQLException e)
	{
		throw new SourceNotFoundException("Error when Fetching Source"+e.getMessage());
	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new SourceNotFoundException("Error when Fetching Source"+e.getMessage());
		}
		}
	return vo;
	}
public Map<String,SourceVO> fetchSourceByName(String Source_name) throws SourceNotFoundException
{
	String userName="root";
	String password="root123";
	String url="jdbc:mysql://localhost:3306/Project2";
	Connection connection=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	SourceVO vo=new SourceVO();
	Map<String,SourceVO> map=new HashMap<String,SourceVO>();

	
	try 
	{
		connection = DriverManager.getConnection(url, userName, password);
		String query="select * from Source where Source_name=?";
		stmt= connection.prepareStatement(query);
		stmt.setString(1, Source_name);
		rs=stmt.executeQuery();
		while(rs.next()){
			vo.setSource_id(rs.getInt("Source_id"));
			vo.setSource_name(rs.getString("Source_name"));
			map.put(Source_name, vo);
		}
	}
	catch(SQLException e)
	{
		throw new SourceNotFoundException("Error when Fetching Source"+e.getMessage());
	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new SourceNotFoundException("Error when Fetching Source"+e.getMessage());
		}
		}
	return map;
	}
public boolean updateSourceDetails(SourceVO vo) throws SourceManagementException
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
		String query="UPDATE Source set Source_name=? where Source_id=?";
		stmt= connection.prepareStatement(query);
		stmt.setString(1, vo.getSource_name());
		stmt.setInt(2, vo.getSource_id());
	    stmt.executeUpdate();
		System.out.println("Updated the Source Details Successfully...");
        flag=true;
	}
	catch(SQLException e)
	{
		throw new SourceManagementException("Error when updating Source Details"+e.getMessage());

	}
	finally{
		try{
			stmt.close();
			connection.close();
		}
		catch(SQLException e)
		{
			throw new SourceManagementException("Error when updating Source Details"+e.getMessage());
}
}
	return flag;
}
}