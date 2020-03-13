package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.bo.PassengerDetailsBO;
import com.demo.exception.PassengerManagementException;
import com.demo.exception.PassengerNotFoundException;
import com.demo.response.PassengerResponseObject;
import com.demo.vo.PassengerDetailsVO;
public class PassengerService
{
		PassengerDetailsBO bo = new PassengerDetailsBO();
		PassengerResponseObject obj = new PassengerResponseObject();
		public PassengerResponseObject addPassengerDetail(PassengerDetailsVO vo) throws PassengerManagementException
		{
			boolean flag;
			try 
			{
				flag = bo.addPassengerDetail(vo);
				if (flag)
					obj.setSuccessMessage("Passenger Added Successfully...");
				else
					obj.setFailureMessage("Error When Adding Passenger Details, Reach out Administrator");
			}
			catch (PassengerManagementException e) {
				obj.setFailureMessage("Error When Adding The Passenger Details,Reach out Administrator" + e.getMessage());
			}
			return obj;
		}
		public PassengerResponseObject fetchPassengerById(int Passenger_id) throws PassengerNotFoundException {

			try {
				PassengerDetailsVO vo;
				vo = bo.fetchPassengerById(Passenger_id);
				obj.setPassengerVo(vo);
			}
			catch (PassengerNotFoundException e) {
				obj.setFailureMessage("Fetch Passenger is not in the List" + e.getMessage());
			}

			return obj;
		}
		public PassengerResponseObject fetchPassengerByAddress(String Address) throws PassengerNotFoundException {
	try {
			Map<String, PassengerDetailsVO>map;
			map = bo.fetchPassengerByAddress(Address);
			
			obj.setPassengerDetailsMap(map);
		} catch (PassengerNotFoundException e) {
			obj.setFailureMessage("Error When Fetching The Passenger Address" + e.getMessage());
		}

		return obj;
	}

public PassengerResponseObject updatePassengerDetail(PassengerDetailsVO vo) throws PassengerManagementException
{
	boolean flag;
	try 
	{
		flag = bo.updatePassengerDetail(vo);
		if (flag)
			obj.setSuccessMessage("Updated Passenger Successfully...");
		else
			obj.setFailureMessage("Error When Updating Passenger Details, Reach out Administrator");
	}
	catch (PassengerManagementException e) {
		obj.setFailureMessage("Error When Updating The Passenger Details,Reach out Administrator" + e.getMessage());
	}
	return obj;
}
}