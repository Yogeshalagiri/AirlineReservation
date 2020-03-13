package com.demo.vo;

import java.sql.Date;

public class PassengerDetailsVO {
private int Passenger_id;
public int getPassenger_id() {
	return Passenger_id;
}
public void setPassenger_id(int passenger_id) {
	Passenger_id = passenger_id;
}
@Override
public String toString() {
	return "PassengerDetails [Passenger_id=" + Passenger_id + ", Passport_no=" + Passport_no + ", Reg_id=" + Reg_id
			+ ", First_name=" + First_name + ", Last_name=" + Last_name + ", Address=" + Address + ", Contact_no="
			+ Contact_no + ", Nationality=" + Nationality + ", Dob=" + Dob + ", getPassenger_id()=" + getPassenger_id()
			+ ", getPassport_no()=" + getPassport_no() + ", getReg_id()=" + getReg_id() + ", getFirst_name()="
			+ getFirst_name() + ", getLast_name()=" + getLast_name() + ", getAddress()=" + getAddress()
			+ ", getContact_no()=" + getContact_no() + ", getNationality()=" + getNationality() + ", getDob()="
			+ getDob() + "]";
}
public String getPassport_no() {
	return Passport_no;
}
public void setPassport_no(String passport_no) {
	Passport_no = passport_no;
}
public int getReg_id() {
	return Reg_id;
}
public void setReg_id(int reg_id) {
	Reg_id = reg_id;
}
public String getFirst_name() {
	return First_name;
}
public void setFirst_name(String first_name) {
	First_name = first_name;
}
public String getLast_name() {
	return Last_name;
}
public void setLast_name(String last_name) {
	Last_name = last_name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public Long getContact_no() {
	return Contact_no;
}
public void setContact_no(Long contact_no) {
	Contact_no = contact_no;
}
public String getNationality() {
	return Nationality;
}
public void setNationality(String nationality) {
	Nationality = nationality;
}
public Date getDob() {
	return Dob;
}
public void setDob(Date dob) {
	Dob = dob;
}
private String Passport_no;
private int Reg_id ;
private String First_name ;
private String Last_name ;
private String Address ;
private Long Contact_no;
private String Nationality ;
private Date Dob; 

}
