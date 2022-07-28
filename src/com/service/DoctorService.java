package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.model.*;
//import database.Admin;
//import database.Doctor;
//import database.Medicine;
//import database.Slot;

//import database.Appointment;
//import database.Slot;

public class DoctorService extends AdminService {

	public static HashMap<String, Doctor> storemapdoc = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	static int ReceiptNo = 999;

	int receipt() {
		ReceiptNo++;
		return ReceiptNo;
	}

	public void doctorDataStored() {

		storemapdoc.put("Shiv123",
				new Doctor("shiv123", "Shiv Sharma", "Cardio".toUpperCase(), 45, 15, new ArrayList<Slot>()));
		storemapdoc.get("Shiv123").getSlot().add(new Slot("2", "4"));
		storemapdoc.get("Shiv123").getSlot().add(new Slot("5", "7"));

		storemapdoc.put("Ram123",
				new Doctor("ram123", "Ram Sharma", "gynaco".toUpperCase(), 45, 10, new ArrayList<Slot>()));
		storemapdoc.get("Ram123").getSlot().add(new Slot("2", "4"));
		storemapdoc.get("Ram123").getSlot().add(new Slot("5", "7"));

		storemapdoc.put("Ravi123",
				new Doctor("ravi123", "Ravi Sharma", "Neuro".toUpperCase(), 45, 5, new ArrayList<Slot>()));
		storemapdoc.get("Ravi123").getSlot().add(new Slot("2", "4"));
		storemapdoc.get("Ravi123").getSlot().add(new Slot("5", "7"));

	}

	public void addDoctor() {
		System.out.println("Enter Doctor ID: ");
		String docId = sc.nextLine();
		System.out.println("Enter Doctor password: ");
		String docPwd = sc.nextLine();
		System.out.println("Enter Doctor Name: ");
		String docName = sc.nextLine();
		System.out.println("Enter Doctor Age: ");
		int docAge = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Doctor Specialization: ");
		String docSpecialization = sc.nextLine();
		System.out.println("Enter Doctor Experience: ");
		int docExperience = sc.nextInt();
		sc.nextLine();
		storemapdoc.put(docId, new Doctor(docPwd, docName, docSpecialization.toUpperCase(), docExperience, docAge,
				new ArrayList<Slot>()));
		Label: while (true) {
			System.out.println("Enter the Slot : \nStart time:");
			String startTime = sc.nextLine();
			System.out.println("End time: ");
			String endTime = sc.nextLine();
			storemapdoc.get(docId).getSlot().add(new Slot(startTime, endTime));
			System.out.println("do you want to add more slot:(Y/N)");
			String slotChoice = sc.nextLine();
			if (slotChoice.equalsIgnoreCase("Y")) {
				continue Label;
			} else if (slotChoice.equalsIgnoreCase("N")) {
				System.out.println("No Slot Added");
				break;
			} else
				System.out.println("Invalid response, try again(Y/N)");
			continue Label;
		}
	}

	public void removeDoctor() {
		System.out.println("Enter doctor Id to remove: ");
		String removeDoc = sc.nextLine();
		if (storemapdoc.containsKey(removeDoc)) {
			storemapdoc.remove(removeDoc);
			System.out.println("Doctor with " + removeDoc + " Id removed successfully");
		} else {
			System.out.println("Invalid Id, Do you want to try again(Y/N)");
			A: while (true) {
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("Y")) {
					removeDoctor();
				} else if (choice.equalsIgnoreCase("N")) {
					System.out.println("No Doctor Removed");
					break;
				} else
					System.out.println("Invalid response, try again(Y/N)");
				continue A;
			}

		}

	}

	public void doctorList() {
		for (Entry<String, Doctor> dlist : storemapdoc.entrySet()) {
			String key = dlist.getKey();
			Doctor doctor = dlist.getValue();

			System.out.println(key + "  " + doctor.getName() + "  " + doctor.getAge() + "  " + doctor.specialization
					+ " " + doctor.experience + " ");

			for (int i = 0; i < storemapdoc.get(key).getSlot().size(); i++) {
				System.out.println(storemapdoc.get(key).getSlot().get(i).getStartTime() + "-"
						+ storemapdoc.get(key).getSlot().get(i).getEndTime());
				// storemapdoc.get(key).getSlot().get(i).getStartTime();
			}

			// storemapdoc.get(key).getSlot().iterator();
			// for(Slot slotList:slot) {
			//
			// }

		}
	}

	public void doctorSlotAdd() {
		// doctorList();
		System.out.println("Enter the id of doctor to add slot:");
		String doctorId = sc.nextLine();
		if (storemapdoc.containsKey(doctorId)) {
			Label: while (true) {

				System.out.println("Enter the Slot : \nStart time:");
				String startTime = sc.nextLine();
				System.out.println("End time: ");
				String endTime = sc.nextLine();
				storemapdoc.get(doctorId).getSlot().add(new Slot(startTime, endTime));

				System.out.println("do you want to add more slot:(Y/N)");
				String slotChoice = sc.nextLine();
				if (slotChoice.equalsIgnoreCase("Y")) {
					continue Label;
				} else if (slotChoice.equalsIgnoreCase("N")) {
					System.out.println("No Slot Added");
					break;
				} else
					System.out.println("Invalid response, try again(Y/N)");
				continue Label;
			}
		} else {
			System.out.println("Docotr's id doent exist");
		}

	}

	public void doctorSlotRemove() {
		// doctorList();
		System.out.println("Enter the id of doctor to remove slot:");
		String doctorId = sc.nextLine();
		int incrementer = 1;
		for (int i = 0; i < storemapdoc.get(doctorId).getSlot().size(); i++) {

			System.out.println(incrementer + ". " + storemapdoc.get(doctorId).getSlot().get(i).getStartTime() + "-"
					+ storemapdoc.get(doctorId).getSlot().get(i).getEndTime());
			incrementer++;

		}

		System.out.println("Enter the input to remove the slot: ");
		int slotchoose = sc.nextInt() - 1;
		sc.nextLine();

		storemapdoc.get(doctorId).getSlot().remove(slotchoose);

		System.out.println("Slot removed successfully----");

	}

	void doctorReceipt(String patientName, int patientAge, long patientContact, String doctorName, String slot,
			int appointmentNo) {
		System.out.printf("%10s\n%10s%72s",
				"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++BILL RECEIPT++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n",
				"Name of the Medical Institution:THOUGHTPEARL HOSPITAL", "\t Receipt no.:" + String.valueOf(receipt()));
		System.out.printf("\n%10s%112s", " ", " \t Date:" + String.valueOf(LocalDate.now()));
		System.out.println("\n\nPatient Name: " + patientName + "\t\t\t\t\t\t\t\t\t\t\t\t Doctor Name: " + doctorName);
		System.out.println("\nPatient Age: " + String.valueOf(patientAge) + "\t\t\t\t\t\t\t\t\t\t\t\t Slot: " + slot);
		System.out.println("\nPatient Contact no.: " + String.valueOf(patientContact) + "\n\nAppointment NO.: "
				+ String.valueOf(appointmentNo));

		// " "," \t Date:" + String.valueOf(LocalDate.now()) + "\nPatient Name: " +
		// patientName + "Doctor Name: " + doctorName
		// + "\nPatient Age: " + String.valueOf(patientAge)+ "Slot: " + slot +
		// "\nPatient Contact no.: " + String.valueOf(patientContact)
		// + "Appointment NO.: " + String.valueOf(appointmentNo));
		System.out.println();
		System.out.println();

	}

	public void allotCheckForDoctor() {
		System.out.println("Enter doctor name to check appointment: ");
		String docNameA = sc.nextLine();
		// System.out.println(list1.get(1).getPatient().getPatientName());
		int counter = 0;
		for (Entry<Integer, Appointment> dlist2 : list1.entrySet()) {
			Integer key = dlist2.getKey();
			Appointment doctor = dlist2.getValue();

			if (doctor.getDoctor().getName().equalsIgnoreCase(docNameA)) {
				counter++;
				System.out.println(key + "  " + doctor.getPatient().getPatientName() + "  "
						+ doctor.getDoctor().getName() + "  " + doctor.getSlot().getStartTime() + "-"
						+ doctor.getSlot().getEndTime() + doctor.getDate() + " ");

				// list1.
			}
		}
		// list1.get(1).getPatient().getPatientName();
		// list1.get(1).getPatient().getPatientId();
		// list1.get(1).getPatient().getPatientContactNo();

		if (counter == 0) {
			System.out.println("This name doesnt exist");

		}
	}

}
