package com.demo.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.dao.SourceDAO;
import com.demo.exception.PassengerManagementException;
import com.demo.exception.SourceManagementException;
import com.demo.exception.SourceNotFoundException;
import com.demo.vo.SourceVO;

public class SourceBO {
		SourceDAO dao=new SourceDAO();
		public boolean addSource(SourceVO vo) throws  SourceManagementException
		{
			try{
			boolean flag;
			flag=dao.addSourceDetails(vo);
			return flag;		
		}
			catch(SourceManagementException e)
			{
				throw new SourceManagementException("Error when adding Source Details,Reach out Administrator" + e.getMessage());
			}
		}	
		
		public SourceVO fetchSourceById(int Source_id) throws SourceNotFoundException
		{
			try{
			SourceVO vo=new SourceVO();
			vo=dao.fetchSourceById(Source_id);
			return vo;
		}
			catch(SourceNotFoundException e)
			{
				throw new SourceNotFoundException("Error when Fetching Source Details,Reach out Administrator" + e.getMessage());
			}
		}	
		public Map<String,SourceVO> fetchSourceByName(String Source_name) throws SourceNotFoundException
		{
			try{
			Map<String,SourceVO> map=new HashMap<String,SourceVO>();
			map=dao.fetchSourceByName(Source_name);
			return map;
		}
			catch(SourceNotFoundException e)
			{
				throw new SourceNotFoundException("Error when Fetching Source Details,Reach out Administrator" + e.getMessage());
			}
		}	
		public boolean updateSource(SourceVO vo) throws SourceManagementException
		{
			try{
			boolean flag;
			flag=dao.updateSourceDetails(vo);
			return flag;
			}
			catch(SourceManagementException e)
			{
				throw new SourceManagementException("Error when updating Source Details,Reach out Administrator" + e.getMessage());
			}
		}	
		
	}