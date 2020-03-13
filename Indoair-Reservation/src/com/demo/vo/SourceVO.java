package com.demo.vo;

public class SourceVO {
private int Source_id;
public int getSource_id() {
	return Source_id;
}
@Override
public String toString() {
	return "Source [Source_id=" + Source_id + ", Source_name=" + Source_name + ", getSource_id()=" + getSource_id()
			+ ", getSource_name()=" + getSource_name() + "]";
}
public void setSource_id(int source_id) {
	Source_id = source_id;
}
public String getSource_name() {
	return Source_name;
}
public void setSource_name(String source_name) {
	Source_name = source_name;
}
private String Source_name;
}
