package com.demo.main;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import com.demo.exception.PassengerManagementException;
import com.demo.exception.PassengerNotFoundException;
import com.demo.exception.RegistrationIdNotFoundException;
import com.demo.exception.ReservationManagementException;
import com.demo.exception.SourceManagementException;
import com.demo.exception.SourceNotFoundException;
import com.demo.exception.UserNameNotFoundException;
import com.demo.response.IndoairReservationResponseObject;
import com.demo.response.PassengerResponseObject;
import com.demo.response.SourceResponseObject;
import com.demo.service.IndoairReservationService;
import com.demo.service.PassengerService;
import com.demo.service.SourceService;
import com.demo.vo.IndoairReservationVO;
import com.demo.vo.PassengerDetailsVO;
import com.demo.vo.SourceVO;

public class AirRegistrationMain {
		public static void main(String[] args) throws PassengerManagementException,PassengerNotFoundException, SQLException, ReservationManagementException, SourceManagementException, SourceNotFoundException, RegistrationIdNotFoundException, UserNameNotFoundException {
/*
				System.out.println("Please select one of the below options");
				System.out.println("1. Add Passenger");
				System.out.println("2. Fetch Passenger by Passenger_id");
				System.out.println("3. Fetch Passenger by Address");
				System.out.println("4. Update Passenger Details");
				System.out.println("5. Exit");
				Scanner s = new Scanner(System.in);
				int menuSelected = s.nextInt();
				switch (menuSelected) {
				case 1:
					addPassengerDetail();
					break;
				case 2:
					fetchPassengerById();
					break;
				case 3:
					fetchPassengerByAddress();
					break;
				case 4:
					updatePassengerDetail();
					break;
				default:
					System.exit(0);
				}
		}
 */
		  

		System.out.println("Please select one of the below options");
		System.out.println("1. Add Reg_id");
		System.out.println("2. Fetch Passenger by Reg_id");
		System.out.println("3. Fetch Passenger by User_name");
		System.out.println("4. Update Reservation");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addReservation();
			break;
		case 2:
			fetchReservationById();
			break;
		case 3:
			fetchReservationByUser_name();
			break;
		case 4:
			updateReservation();
			break;
		default:
			System.exit(0);
		}
		}
	
	/*
		    System.out.println("Please select one of the below options");
			System.out.println("1. Add Source");
			System.out.println("2. Fetch Source by id");
			System.out.println("3. Fetch Source by name");
			System.out.println("4. Update Source");
			System.out.println("5. Exit");
			Scanner s = new Scanner(System.in);
			int menuSelected = s.nextInt();
			switch (menuSelected) {
			case 1:
				addSource();
				break;
			case 2:
				fetchSourceById();
				break;
			case 3:
				fetchSourceByName();
				break;
			case 4:
				updateSource();
				break;
			default:
				System.exit(0);
			}
			}
	*/

	/*
			private static void addPassengerDetail() throws PassengerManagementException {
				PassengerService passengerService = new PassengerService();
				Scanner s = new Scanner(System.in);
				boolean flag;
				System.out.println("Please Enter The Passenger _id:");
				Integer Passenger_id = Integer.parseInt(s.nextLine());
				System.out.println("Please Enter The Passport_no:");
				String Passport_no = s.nextLine();
				System.out.println("Please Enter The Reg_id:");
				Integer Reg_id = Integer.parseInt(s.nextLine());
				System.out.println("Please Enter The First_name:");
				String First_name = s.nextLine();
				System.out.println("Please Enter The Last_name:");
				String Last_name = s.nextLine();
				System.out.println("Please Enter The Address:");
				String Address = s.nextLine();
				System.out.println("Please Enter The Contact_no:");
				Long Contact_no =Long.parseLong(s.nextLine());
				System.out.println("Please Enter The Nationality:");
				String Nationality = s.nextLine();
				System.out.println("Please Enter The Dob:");
				java.sql.Date Dob = Date.valueOf(s.nextLine());
				PassengerDetailsVO vo = new PassengerDetailsVO();

				vo.setPassenger_id(Passenger_id);
				vo.setPassport_no(Passport_no);
				vo.setReg_id(Reg_id);
				vo.setFirst_name(First_name);
				vo.setLast_name(Last_name);
				vo.setAddress(Address);
				vo.setContact_no(Contact_no);
				vo.setNationality(Nationality);
				vo.setDob(Dob);
				PassengerResponseObject obj = null;
				obj = passengerService.addPassengerDetail(vo);
				if (obj.getSuccessMessage() != null) {
					System.out.println(obj.getSuccessMessage());
				} else {
					System.out.println(obj.getFailureMessage());
				}
			}
		private static void fetchPassengerById() throws PassengerNotFoundException {
				// TODO Auto-generated method stub
         Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Passenger_id:");
		Integer Passenger_id = Integer.parseInt(s.nextLine());

		PassengerService passengerService = new PassengerService();
		PassengerResponseObject obj = passengerService.fetchPassengerById(Passenger_id);
		PassengerDetailsVO vo;
		vo = obj.getPassengerVo();
		if (vo != null) {
			System.out.println(
					"==================================================================================================================================================================================");
			System.out.println("Passenger_id" + '\t' + "Passport_no" + '\t' + "Reg_id" + '\t' + "First_name"+ '\t' + "Last_name"+ '\t' +"Address"+ '\t' +"Contact_no"+ '\t' +"Nationality"+ '\t' +"Dob");
			System.out.println(
					"===================================================================================================================================================================================================================================================");
			System.out.println( vo.getPassenger_id()+"\t\t"+vo.getPassport_no() + "\t\t" +vo.getReg_id()+"\t\t"+vo.getFirst_name() + "\t\t" + vo.getLast_name() + "\t\t" + vo.getAddress()+"\t\t"+vo.getContact_no()+"\t\t"+vo.getNationality() + "\t\t"
					+ vo.getDob());
		} else {
			System.out.println(obj.getFailureMessage());
		}
            
			}
		 private static void fetchPassengerByAddress() throws PassengerNotFoundException {
				// TODO Auto-generated method stub
				  Scanner s = new Scanner(System.in);
					System.out.println("Please Enter The Address:");
					String Address=s.nextLine();
					PassengerService passengerService = new PassengerService();
					PassengerResponseObject obj = passengerService.fetchPassengerByAddress(Address);
					Map<String,PassengerDetailsVO> map = new HashMap<String,PassengerDetailsVO>();
					map = obj.getPassengerDetailsMap();
					if (map!=null)
					{
						System.out.println(
								"==========================================================================================================================================================================================");
						System.out.println("Passenger_id" + '\t' + "Passport_no" + '\t' + "Reg_id" + '\t' + "First_name"+ '\t' + "Last_name"+ '\t' +"Address"+ '\t' +"Contact_no"+ '\t' +"Nationality"+ '\t' +"Dob");
						System.out.println(
								"============================================================================================================================================================================================");
						
						System.out.println(map);
					}
					else {
						{
							System.out.println(obj.getFailureMessage());


						} }
		 }
		 
		 private static void updatePassengerDetail() throws PassengerManagementException {
				PassengerService passengerService = new PassengerService();
				Scanner s = new Scanner(System.in);
				boolean flag;
				System.out.println("Please Enter The Passenger _id:");
				Integer Passenger_id = Integer.parseInt(s.nextLine());
				System.out.println("Please Enter The Passport_no:");
				String Passport_no = s.nextLine();
				System.out.println("Please Enter The Reg_id:");
				Integer Reg_id = Integer.parseInt(s.nextLine());
				System.out.println("Please Enter The First_name:");
				String First_name = s.nextLine();
				System.out.println("Please Enter The Last_name:");
				String Last_name = s.nextLine();
				System.out.println("Please Enter The Address:");
				String Address = s.nextLine();
				System.out.println("Please Enter The Contact_no:");
				Long Contact_no =Long.parseLong(s.nextLine());
				System.out.println("Please Enter The Nationality:");
				String Nationality = s.nextLine();
				System.out.println("Please Enter The Dob:");
				java.sql.Date Dob = Date.valueOf(s.nextLine());
				PassengerDetailsVO vo = new PassengerDetailsVO();

				vo.setPassenger_id(Passenger_id);
				vo.setPassport_no(Passport_no);
				vo.setReg_id(Reg_id);
				vo.setFirst_name(First_name);
				vo.setLast_name(Last_name);
				vo.setAddress(Address);
				vo.setContact_no(Contact_no);
				vo.setNationality(Nationality);
				vo.setDob(Dob);
				PassengerResponseObject obj = null;
				obj = passengerService.updatePassengerDetail(vo);
				if (obj.getSuccessMessage() != null)
				{
					System.out.println(obj.getSuccessMessage());
				}
				else
				{
					System.out.println(obj.getFailureMessage());
				}
			}
}
*/
	
private static void addReservation() throws ReservationManagementException {
	IndoairReservationService ReservationService = new IndoairReservationService();
	Scanner s = new Scanner(System.in);
	boolean flag;
	System.out.println("Please Enter The Reg _id:");
	Integer Reg_id = Integer.parseInt(s.nextLine());
	System.out.println("Please Enter The User_name:");
	String User_name = s.nextLine();
	System.out.println("Please Enter The Password:");
	String Password = s.nextLine();
	System.out.println("Please Enter The Email:");
	String Email = s.nextLine();
	IndoairReservationVO vo = new IndoairReservationVO();

	vo.setReg_id(Reg_id);
	vo.setUser_name(User_name);
	vo.setPassword(Password);
	vo.setEmail(Email);
	IndoairReservationResponseObject obj=null ;
	obj = ReservationService.addReservation(vo);
	if (obj.getSuccessmessage() != null) {
		System.out.println(obj.getSuccessmessage());
	} else {
		System.out.println(obj.getFailuremessage());
	}
}

private static void fetchReservationById() throws RegistrationIdNotFoundException {
			// TODO Auto-generated method stub
			 Scanner s = new Scanner(System.in);
				System.out.println("Please Enter The Reg_id:");
				Integer Reg_id = Integer.parseInt(s.nextLine());
				IndoairReservationService reservationService = new IndoairReservationService();
				IndoairReservationResponseObject obj = reservationService.fetchReservationById(Reg_id);
				IndoairReservationVO vo;
				vo = obj.getIndoairReservationvo();
				if (vo != null) {
					System.out.println(
							"================================================================================================");
					System.out.println("Reg_id" + '\t' + "User_name"+'\t'+"Password"+'\t'+"Email");
					System.out.println(
							"================================================================================================");
					System.out.println( vo.getReg_id()+"\t\t"+vo.getUser_name()+"\t\t"+vo.getPassword()+"\t\t"+vo.getEmail());
				
				} else {
					System.out.println(obj.getFailuremessage());
				}
		           
					}
		
		private static void fetchReservationByUser_name() throws UserNameNotFoundException {
			// TODO Auto-generated method stub
				 Scanner s = new Scanner(System.in);
					System.out.println("Please Enter The User_name:");
					String User_name=s.nextLine();
					IndoairReservationService reservationService = new IndoairReservationService();
					IndoairReservationResponseObject obj = reservationService.fetchReservationByUser_name(User_name);
					Map<String,IndoairReservationVO> map = new HashMap<String,IndoairReservationVO>();
					map = obj.getIndoairReservationVOMap();
					if (map != null) 
					{
						System.out.println(
								"================================================================================================");
						System.out.println("Reg_id" + '\t' + "User_name"+'\t'+"Password"+'\t'+"Email");
						System.out.println(
								"================================================================================================");
					System.out.println(map);
					} else {
						System.out.println(obj.getFailuremessage());
	}
		}	
		private static void updateReservation() throws ReservationManagementException {
			IndoairReservationService ReservationService = new IndoairReservationService();
			Scanner s = new Scanner(System.in);
			boolean flag;
			System.out.println("Please Enter The Reg _id:");
			Integer Reg_id = Integer.parseInt(s.nextLine());
			System.out.println("Please Enter The User_name:");
			String User_name = s.nextLine();
			System.out.println("Please Enter The Password:");
			String Password = s.nextLine();
			System.out.println("Please Enter The Email:");
			String Email = s.nextLine();
			IndoairReservationVO vo = new IndoairReservationVO();

			vo.setReg_id(Reg_id);
			vo.setUser_name(User_name);
			vo.setPassword(Password);
			vo.setEmail(Email);
			IndoairReservationResponseObject obj = null;
			obj = ReservationService.updateReservation(vo);
			if (obj.getSuccessmessage() != null) {
				System.out.println(obj.getSuccessmessage());
			} else {
				System.out.println(obj.getFailuremessage());
			}
		}
}

/*
		private static void addSource() throws SourceManagementException {
		SourceService sourceService = new SourceService();
			Scanner s = new Scanner(System.in);
			boolean flag;
			System.out.println("Please Enter The Source _id:");
			Integer Source_id = Integer.parseInt(s.nextLine());
			System.out.println("Please Enter The Source_name:");
			String Source_name = s.nextLine();
			SourceVO vo = new SourceVO();

			vo.setSource_id(Source_id);
			vo.setSource_name(Source_name);
			SourceResponseObject obj = null;
			obj = sourceService.addSource(vo);
			if (obj.getSuccessmessage() != null) {
				System.out.println(obj.getSuccessmessage());
			} else {
				System.out.println(obj.getFailuremessage());
			}
		}

				private static void fetchSourceById() throws SourceNotFoundException {
					// TODO Auto-generated method stub
					  Scanner s = new Scanner(System.in);
						System.out.println("Please Enter The Source_id:");
						Integer Source_id = Integer.parseInt(s.nextLine());

						SourceService sourceService = new SourceService();
						SourceResponseObject obj = sourceService.fetchSourceById(Source_id);
						SourceVO vo;
						vo = obj.getSourceVO();
						if (vo != null) {
							System.out.println(
									"====================================================");
							System.out.println("Source_id" + '\t' + "Source_name");
							System.out.println(
									"===========================================================");
							System.out.println( vo.getSource_id()+"\t\t"+vo.getSource_name());
						
						} else {
							System.out.println(obj.getFailuremessage());
						}
				          
							}


				private static void fetchSourceByName() throws SourceNotFoundException {
					// TODO Auto-generated method stub
					 Scanner s = new Scanner(System.in);
						System.out.println("Please Enter The Source_name:");
						String Source_name=s.nextLine();
						SourceService sourceService = new SourceService();
						SourceResponseObject obj = sourceService.fetchSourceByName(Source_name);
						Map<String,SourceVO> map = new HashMap<String,SourceVO>();
						map = obj.getSourceVOMap();
						if (map != null) 
						{
							System.out.println(
									"===================================================");
							System.out.println("Source_id" + '\t' + "Source_name");
							System.out.println(
									"============================================================");
						System.out.println(map);
						} else {
							System.out.println(obj.getFailuremessage());
						}
			          
							}

				private static void updateSource() throws SourceManagementException {
					SourceService sourceService = new SourceService();
					Scanner s = new Scanner(System.in);
					boolean flag;
					System.out.println("Please Enter The Source _id:");
					Integer Source_id = Integer.parseInt(s.nextLine());
					System.out.println("Please Enter The Source_name:");
					String Source_name = s.nextLine();
					SourceVO vo = new SourceVO();

					vo.setSource_id(Source_id);
					vo.setSource_name(Source_name);
					SourceResponseObject obj = null;
					obj = sourceService.updateSource(vo);
					if (obj.getSuccessmessage() != null) {
						System.out.println(obj.getSuccessmessage());
					} else {
						System.out.println(obj.getFailuremessage());
					}
				}
		}
*/