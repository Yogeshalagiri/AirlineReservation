package com.demo.vo;

public class IndoairReservationVO {
private int Reg_id; 
public int getReg_id() {
	return Reg_id;
}
public void setReg_id(int reg_id) {
	Reg_id = reg_id;
}
@Override
public String toString() {
	return "IndoairReservation [Reg_id=" + Reg_id + ", User_name=" + User_name + ", Password=" + Password + ", Email="
			+ Email + ", getReg_id()=" + getReg_id() + ", getUser_name()=" + getUser_name() + ", getPassword()="
			+ getPassword() + ", getEmail()=" + getEmail() + "]";
}
public String getUser_name() {
	return User_name;
}
public void setUser_name(String user_name) {
	User_name = user_name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
private String User_name; 
private String Password; 
private String Email; 
}
