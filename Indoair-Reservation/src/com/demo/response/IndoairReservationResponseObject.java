package com.demo.response;

import java.util.List;
import java.util.Map;

import com.demo.vo.IndoairReservationVO;

public class IndoairReservationResponseObject {

public String getSuccessmessage() {
		return Successmessage;
	}
	public void setSuccessmessage(String successmessage) {
		Successmessage = successmessage;
	}
	public String getFailuremessage() {
		return Failuremessage;
	}
	public void setFailuremessage(String failuremessage) {
		Failuremessage = failuremessage;
	}
	public Map<String, IndoairReservationVO> getIndoairReservationVOMap() {
		return indoairReservationVOMap;
	}
	public void setIndoairReservationVOMap(Map<String, IndoairReservationVO> indoairReservationVOMap) {
		this.indoairReservationVOMap = indoairReservationVOMap;
	}
	public IndoairReservationVO getIndoairReservationvo() {
		return indoairReservationvo;
	}
	public void setIndoairReservationvo(IndoairReservationVO indoairReservationvo) {
		this.indoairReservationvo = indoairReservationvo;
	}
String Successmessage;
String Failuremessage;
Map<String,IndoairReservationVO> indoairReservationVOMap;
IndoairReservationVO indoairReservationvo;

}
