package com.service;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.model.*;

//import database.Admin;
//import database.Appointment;
//import database.Patient;

public class AdminService {
	public static HashMap<String, Admin> storemap = new HashMap<>();

	public static HashMap<String, Patient> storePatient = new HashMap<>();

	public static HashMap<Integer, Appointment> list1 = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	public void adminDataStored() {
		storemap.put("Anush123", new Admin("anush123", "Anush Jain", 24));
		storemap.put("Ankit123", new Admin("ankit123", "Ankit Jain", 28));
		storemap.put("Akshay123", new Admin("akshay123", "Akshay Jain", 32));
	}

	public void patientList() {
		for (Entry<String, Patient> dlist : storePatient.entrySet()) {
			String key = dlist.getKey();
			Patient d = dlist.getValue();

			System.out.println(key + "  " + d.getPatientName() + "  " + d.getPatientId() + "  " + d.getPatientAge()
					+ " " + d.getPatientContactNo() + " " + d.getSpecializationRequirement());

		}
	}

	public void allotCheckForPatient() {
		System.out.println("Enter Patient name to check appointment: ");
		String patientNameA = sc.nextLine();
		// System.out.println(list1.get(1).getPatient().getPatientName());
		for (Entry<Integer, Appointment> dlist2 : list1.entrySet()) {
			Integer key = dlist2.getKey();
			Appointment doctor = dlist2.getValue();
			if (doctor.getPatient().getPatientName().equalsIgnoreCase(patientNameA)) {

				System.out.println(key + "  " + doctor.getPatient().getPatientName() + "  "
						+ doctor.getDoctor().getName() + "  " + doctor.getSlot().getStartTime() + "-"
						+ doctor.getSlot().getEndTime() + doctor.getDate() + " ");

				// list1.
			}

		}
	}

}
