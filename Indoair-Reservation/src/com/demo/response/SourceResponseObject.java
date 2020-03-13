package com.demo.response;

import java.util.Map;

import com.demo.vo.SourceVO;

public class SourceResponseObject {
String successmessage;
public String getSuccessmessage() {
	return successmessage;
}
public void setSuccessmessage(String successmessage) {
	this.successmessage = successmessage;
}
public String getFailuremessage() {
	return failuremessage;
}
public void setFailuremessage(String failuremessage) {
	this.failuremessage = failuremessage;
}
public Map<String, SourceVO> getSourceVOMap() {
	return SourceVOMap;
}
public void setSourceVOMap(Map<String, SourceVO> sourceVOMap) {
	SourceVOMap = sourceVOMap;
}
public SourceVO getSourceVO() {
	return sourceVO;
}
public void setSourceVO(SourceVO sourceVO) {
	this.sourceVO = sourceVO;
}
String failuremessage;
Map<String,SourceVO>SourceVOMap;
SourceVO sourceVO;

}