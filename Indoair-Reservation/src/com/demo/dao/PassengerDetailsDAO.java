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

import com.demo.exception.PassengerManagementException;
import com.demo.exception.PassengerNotFoundException;
import com.demo.vo.PassengerDetailsVO;

public class PassengerDetailsDAO {
	public boolean addPassengerDetail(PassengerDetailsVO vo) throws PassengerManagementException{
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/Project2";
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean flag;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO PassengerDetail(Passenger_id,Passport_no,Reg_id ,First_name, Last_name , Address , Contact_no , Nationality , Dob)VALUES (?,?,?,?,?,?,?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getPassenger_id());
			stmt.setString(2, vo.getPassport_no());
			stmt.setInt(3, vo.getReg_id());
			stmt.setString(4, vo.getFirst_name());
			stmt.setString(5, vo.getLast_name());
			stmt.setString(6, vo.getAddress());
			stmt.setLong(7, vo.getContact_no());
			stmt.setString(8, vo.getNationality());
			stmt.setDate(9, vo.getDob());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new PassengerManagementException("Error when adding Passenger Details,Reach out Administrator" + e.getMessage());
		} 
		finally 
		{
			try {
				stmt.close();
				connection.close();
			} 
			catch (SQLException e)
			{
				throw new PassengerManagementException("Error when adding Passenger Details,Reach out Administrator" + e.getMessage());
			}
		}
		return flag;
	}
	public PassengerDetailsVO fetchPassengerById(int Passenger_id) throws PassengerNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/Project2";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PassengerDetailsVO vo = new PassengerDetailsVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from PassengerDetail where Passenger_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, Passenger_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setPassenger_id(rs.getInt("Passenger_id"));
				vo.setPassport_no(rs.getString("Passport_no"));
				vo.setReg_id(rs.getInt("Reg_id"));
				vo.setFirst_name(rs.getString("First_name"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setAddress(rs.getString("Address"));
				vo.setContact_no(rs.getLong("Contact_no"));
				vo.setNationality(rs.getString("Nationality"));
				vo.setDob(rs.getDate("Dob"));
			}
		} catch (SQLException e) {
			throw new PassengerNotFoundException("Error while Fetching Passenger" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new PassengerNotFoundException("Error while Fetching Passenger" + e.getMessage());
			}
		}
		return vo;
	}
	public Map<String,PassengerDetailsVO> fetchPassengerByAddress(String Address) throws PassengerNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/Project2";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		Map<String,PassengerDetailsVO> map = new HashMap<String,PassengerDetailsVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from PassengerDetail where Address=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, Address);
			rs = stmt.executeQuery();
			while (rs.next()) {
				PassengerDetailsVO vo = new PassengerDetailsVO();
				
				vo.setPassenger_id(rs.getInt("Passenger_id"));
				vo.setPassport_no(rs.getString("Passport_no"));
				vo.setReg_id(rs.getInt("Reg_id"));
				vo.setFirst_name(rs.getString("First_name"));
				vo.setLast_name(rs.getString("Last_name"));
				vo.setAddress(rs.getString("Address"));
				vo.setContact_no(rs.getLong("Contact_no"));
				vo.setNationality(rs.getString("Nationality"));
				vo.setDob(rs.getDate("Dob"));
				map.put(Address, vo);
			}
		} catch (SQLException e) {
			throw new PassengerNotFoundException("Error when Fetching Passenger By Source" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new PassengerNotFoundException("Error when Fetching Passenger By Source" + e.getMessage());
			}
		}
		return map;
	}
	public boolean updatePassengerDetail(PassengerDetailsVO vo) throws PassengerManagementException {

		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/Project2";
		Connection connection = null;
		PreparedStatement stmt = null;
		boolean flag;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "update PassengerDetail set Passport_no=?,Reg_id=?,First_name=?,Last_name=?,Address=?,Contact_no=?,Nationality=?,Dob=? where Passenger_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, vo.getPassport_no());
			stmt.setInt(2, vo.getReg_id());
			stmt.setString(3, vo.getFirst_name());
			stmt.setString(4, vo.getLast_name());
			stmt.setString(5, vo.getAddress());
			stmt.setLong(6, vo.getContact_no());
			stmt.setString(7, vo.getNationality());
			stmt.setDate(8, vo.getDob());
			stmt.setInt(9, vo.getPassenger_id());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new PassengerManagementException("Error when updating Passenger Details,Reach out Administrator" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new PassengerManagementException("Error when updating Passenger Details,Reach out Administrator" + e.getMessage());
			}
		}
		return flag;
	}
}