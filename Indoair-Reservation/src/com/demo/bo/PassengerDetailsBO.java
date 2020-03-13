package com.demo.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.dao.PassengerDetailsDAO;
import com.demo.exception.PassengerManagementException;
import com.demo.exception.PassengerNotFoundException;
import com.demo.vo.PassengerDetailsVO;
public class PassengerDetailsBO {
	PassengerDetailsDAO dao=new PassengerDetailsDAO();
	public boolean addPassengerDetail(PassengerDetailsVO vo) throws PassengerManagementException
	{
		try{
		boolean flag;
		flag=dao.addPassengerDetail(vo);
		return flag;
		}
		catch(PassengerManagementException e)
		{
			throw new PassengerManagementException("Error when adding Passenger Details,Reach out Administrator" + e.getMessage());
		}
		
	}	
	public PassengerDetailsVO fetchPassengerById(int Passenger_id) throws PassengerNotFoundException
	{
	PassengerDetailsVO vo=new PassengerDetailsVO();
	vo=dao.fetchPassengerById(Passenger_id);
	return vo;
	}
		
	public Map<String,PassengerDetailsVO> fetchPassengerByAddress(String Address) throws PassengerNotFoundException
	{
		
		Map<String,PassengerDetailsVO> map=new HashMap<String,PassengerDetailsVO>();
		map=dao.fetchPassengerByAddress(Address);
		return map;
	}
	

	public boolean updatePassengerDetail(PassengerDetailsVO vo) throws PassengerManagementException
	{
		try{
		boolean flag;
		flag=dao.updatePassengerDetail(vo);
		return flag;
	}
	catch(PassengerManagementException e)
	{
		throw new PassengerManagementException("Error when Updating Passenger Details,Reach out Administrator" + e.getMessage());
	}
}
}