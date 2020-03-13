package com.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.demo.bo.IndoairReservationBO;
import com.demo.exception.PassengerNotFoundException;
import com.demo.exception.RegistrationIdNotFoundException;
import com.demo.exception.ReservationManagementException;
import com.demo.exception.SourceNotFoundException;
import com.demo.exception.UserNameNotFoundException;
import com.demo.response.IndoairReservationResponseObject;
import com.demo.response.PassengerResponseObject;
import com.demo.response.SourceResponseObject;
import com.demo.vo.IndoairReservationVO;
import com.demo.vo.PassengerDetailsVO;
import com.demo.vo.SourceVO;

public class IndoairReservationService{
		IndoairReservationBO bo = new IndoairReservationBO();
		IndoairReservationResponseObject obj = new IndoairReservationResponseObject();

		public IndoairReservationResponseObject addReservation(IndoairReservationVO vo) throws ReservationManagementException {
			boolean flag;
			try {
				flag = bo.addReservation(vo);
				if (flag)
					obj.setSuccessmessage("Reservation Added Successfully");
				else
					obj.setFailuremessage("Error When Adding Reservation Details, Reach out Administrator");

			} catch (ReservationManagementException e) {
				obj.setFailuremessage("Error When Adding The Reservation Details" + e.getMessage());
			}

			return obj;

		}
		public IndoairReservationResponseObject fetchReservationById(int Reg_id) throws RegistrationIdNotFoundException {
         try{
			IndoairReservationVO vo;
			vo = bo.fetchReservationById(Reg_id);
			obj.setIndoairReservationvo(vo);
         }
			catch (RegistrationIdNotFoundException e) {
				obj.setFailuremessage("Fetch ReservationId is not in the List" + e.getMessage());
			}
			return obj;
		}
	
	
		public IndoairReservationResponseObject fetchReservationByUser_name(String User_name) throws UserNameNotFoundException {
try{
			Map<String,IndoairReservationVO> map;
			map = bo.fetchReservationByName(User_name);
			obj.setIndoairReservationVOMap(map);
		}	
catch (UserNameNotFoundException e) {
	obj.setFailuremessage("Fetch User_name is not in the List" + e.getMessage());
}
return obj;
}
public IndoairReservationResponseObject updateReservation(IndoairReservationVO vo) throws ReservationManagementException {
	boolean flag;
	try {
		flag = bo.updateReservation(vo);
		if (flag)
			obj.setSuccessmessage("Reservation Updated Successfully");
		else
			obj.setFailuremessage("Error When Adding Reservation Details, Reach out Administrator");

	} catch (ReservationManagementException e) {
		obj.setFailuremessage("Error When Adding The Reservation Details" + e.getMessage());
	}
	return obj;
}
}