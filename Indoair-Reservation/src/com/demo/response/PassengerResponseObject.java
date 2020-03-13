package com.demo.response;
import java.util.Map;

import com.demo.vo.PassengerDetailsVO;

public class PassengerResponseObject {
         public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public Map<String, PassengerDetailsVO> getPassengerDetailsMap() {
		return passengerDetailsMap;
	}
	public void setPassengerDetailsMap(Map<String, PassengerDetailsVO> passengerDetailsMap) {
		this.passengerDetailsMap = passengerDetailsMap;
	}
	public PassengerDetailsVO getPassengerVo() {
		return passengerVo;
	}
	public void setPassengerVo(PassengerDetailsVO passengerVo) {
		this.passengerVo = passengerVo;
	}
		String successMessage;
		String failureMessage;
		Map<String,PassengerDetailsVO> passengerDetailsMap;
		PassengerDetailsVO passengerVo;

         

}
