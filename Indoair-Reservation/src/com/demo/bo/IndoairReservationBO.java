package com.demo.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.dao.IndoairReservationDAO;
import com.demo.exception.RegistrationIdNotFoundException;
import com.demo.exception.ReservationManagementException;
import com.demo.exception.SourceManagementException;
import com.demo.exception.UserNameNotFoundException;
import com.demo.vo.IndoairReservationVO;

public class IndoairReservationBO {
	IndoairReservationDAO dao=new IndoairReservationDAO();
	public boolean addReservation(IndoairReservationVO vo) throws ReservationManagementException
	{
		try{
		boolean flag;
		flag=dao.addReservation(vo);
		return flag;		
	}
		catch(ReservationManagementException e)
		{
			throw new ReservationManagementException("Error when adding Reservation Details,Reach out Administrator" + e.getMessage());
		}
	}	
		public IndoairReservationVO fetchReservationById(int Reg_id) throws RegistrationIdNotFoundException
	{
			try{
		IndoairReservationVO  vo=new IndoairReservationVO();
		vo=dao.fetchReservationById(Reg_id);
		return vo;
	}
			catch(RegistrationIdNotFoundException e)
			{
				throw new RegistrationIdNotFoundException("Error when Fetching Reg_id,Reach out Administrator" + e.getMessage());
			}
	}
	public Map<String,IndoairReservationVO> fetchReservationByName(String User_name) throws UserNameNotFoundException
	{
		try{
		Map<String,IndoairReservationVO> map=new HashMap<String,IndoairReservationVO>();
		map=dao.fetchReservationByName(User_name);
		return map;
	}
		catch(UserNameNotFoundException e)
		{
			throw new UserNameNotFoundException("Error when Fetching User_name,Reach out Administrator" + e.getMessage());
		}
	}	
	public boolean updateReservation(IndoairReservationVO vo) throws ReservationManagementException
	{
		try{
		boolean flag;
		flag=dao.updateReservationDetails(vo);
		return flag;	
	}
	 catch(ReservationManagementException e)
	{
		throw new ReservationManagementException("Error when Updating Reservation Details,Reach out Administrator" + e.getMessage());
	}
}	
}