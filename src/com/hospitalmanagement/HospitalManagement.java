package com.hospitalmanagement;

import java.util.Scanner;

import com.service.MedicineService;

public class HospitalManagement extends MedicineService {
	static HospitalManagement hospitalManagementObject=new HospitalManagement();
static Scanner mainScanner = new Scanner(System.in);

  
	
	
	
	public void options() {
		//try{
	System.out.println("\n\n======================================================================WELCOME TO THE AIIMS HOSPITAL======================================================================");
	System.out.printf("%10s%110s","","Software By: THOUGHTPEARL SOFTWARE PRIVATE LIMITED");
	System.out.println("\nChoose your option: \n1. Admin login\n2. Doctor \n3. Medical store \n4. End of the Program ");
	System.out.println("Enter your input: ");
	int choice=mainScanner.nextInt();
		
	switch(choice){
	case 1:System.out.println("WELCOME TO THE ADMIN PANEL");
	System.out.println("Choose the options: \n1. Add doctor \n2. Remove doctor\n3. Doctor list\n4. Patient list\n5. Patient appointment\n6. BILL ACCORDING TO BILL NO\n7. MAIN MENU");
	
	
	switch(mainScanner.nextInt()) {
	case 1:System.out.println(" ADDING DOCTOR");
	hospitalManagementObject.addDoctor();
	options();
	
	break;
	case 2: System.out.println("REMOVING DOCTOR");
	hospitalManagementObject.removeDoctor();options();
	break;
	case 3:System.out.println("DOCTORS LIST: ");
	hospitalManagementObject.doctorList();options();
	break;
	case 4:System.out.println("PATIENTS LIST: ");
	hospitalManagementObject.patientList();options();
	break;
	case 5:System.out.println("PATIENTS APPOINTMENT: ");
	hospitalManagementObject.allotSlot();options();
	break;
	case 6:System.out.println("BILL: ");
	hospitalManagementObject.receptOfBillusingbillno();options();
	break;
	case 7:System.out.println("MAIN MENU");
	options();
	break;
	default: System.out.println("NOT A VALID INPUT");
	options();
	break;
	}
	break;
	case 2:System.out.println("WELCOME TO DOCTOR PANEL:\n1. TO CHECK THE APPOINTMENT DETAILS\n2. ADD SLOT\n3. REMOVE SLOT\n4. MAIN MENU");
	switch(mainScanner.nextInt()) {
	case 1:System.out.println("APPOINTMENT LIST");
	hospitalManagementObject.allotCheckForDoctor();options();
	break;
	case 2:System.out.println("SLOT ADDING");
	hospitalManagementObject.doctorSlotAdd();options();
	break;
	case 3:System.out.println("SLOT REMOVING");
	
	hospitalManagementObject.doctorSlotRemove();options();
	break;
	case 4:System.out.println("MAIN MENU");
	options();
	break;
	
	
	
	
	
	
	
	}
	break;
	
	case 3:System.out.println("WELCOME TO MEDICAL STORE: \n1. ADD MEDICINE\n2. REMOVE MEDICINE\n3. MEDICINE LIST \n4. MEDICINE STORE\n5. MEDICINES SOLD\n6. MAIN MENU" );
	switch(mainScanner.nextInt()) {
	case 1:System.out.println("ADDING MEDICINE: ");
	hospitalManagementObject.addMedicine();options();
	break;
	case 2:System.out.println("REMOVING MEDICINE: ");
	hospitalManagementObject.removeMedicine();options();
		break;
	case 3:System.out.println("MEDICINE LIST: ");
	hospitalManagementObject.medicineList();options();
	break; 
	case 4:System.out.println("Medicine STORE");
	hospitalManagementObject.billMedicine();options();
	
	break;
	case 5:System.out.println(" MEDICINES SOLD");
	hospitalManagementObject.showRecordBil();options();
	break;
	case 6:System.out.println("MAIN MENU");
	options();
	break;
	
	}
	
	
	case 4:System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++THANKS FOR USING OUR SOFTWARE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.exit(0); 
	break;
	default:System.out.println("NOT A VALID INPUT");
	options();
	
	}
	//}
	
//		catch(Exception e) {
//			
//			System.out.println("invalid input ");
//			options();
//			
//			
//		}
	
	
	}
	
	
	
		
		
		
	
	
}
