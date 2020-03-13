package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.bo.SourceBO;
import com.demo.exception.PassengerNotFoundException;
import com.demo.exception.SourceManagementException;
import com.demo.exception.SourceNotFoundException;
import com.demo.response.PassengerResponseObject;
import com.demo.response.SourceResponseObject;
import com.demo.vo.PassengerDetailsVO;
import com.demo.vo.SourceVO;

public class SourceService {

		SourceBO bo = new SourceBO();
		SourceResponseObject obj = new SourceResponseObject();

		public SourceResponseObject addSource(SourceVO vo) throws SourceManagementException {
			boolean flag;
			try {
				flag = bo.addSource(vo);
				if (flag)
					obj.setSuccessmessage("Source Added Successfully");
				else
					obj.setFailuremessage("Error When Adding Source Details, Reach out Administrator");

			} catch (SourceManagementException e) {
				obj.setFailuremessage("Error When Adding The Source Details" + e.getMessage());
			}
			return obj;
		}
		
		public SourceResponseObject fetchSourceById(int Source_id) throws SourceNotFoundException {

			try {
				SourceVO vo;
				vo = bo.fetchSourceById(Source_id);
				obj.setSourceVO(vo);
			} catch (SourceNotFoundException e) {
				obj.setFailuremessage("Fetch Source is not in the List" + e.getMessage());
			}

			return obj;
		}
		
		public SourceResponseObject fetchSourceByName(String Source_name) throws SourceNotFoundException {

			try {
					Map<String,SourceVO> map;
					map = bo.fetchSourceByName(Source_name);
					obj.setSourceVOMap(map);

				} catch (SourceNotFoundException e) {
					obj.setFailuremessage("Error When Fetching The SourceName Details" + e.getMessage());
				}

				return obj;
		}
public SourceResponseObject updateSource(SourceVO vo) throws SourceManagementException {
	boolean flag;
	try {
		flag = bo.updateSource(vo);
		if (flag)
			obj.setSuccessmessage("Source Added Successfully");
		else
			obj.setFailuremessage("Error When Adding Source Details, Reach out Administrator");

	} catch (SourceManagementException e) {
		obj.setFailuremessage("Error When Adding The Source Details" + e.getMessage());
	}
	return obj;
}
}