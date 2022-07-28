package com.service;

import java.time.LocalDate;
import java.util.Map.Entry;
import java.util.Scanner;

import com.model.*;
//import database.Appointment;
//import database.Doctor;
//import database.Patient;
//import database.Slot;

public class AppointmentService extends DoctorService {
	String patientReq = null;
	Scanner sc = new Scanner(System.in);

	public Patient patientDetails() {
		System.out.println("Enter the patient details\n Enter the patient name: ");
		String patientName = sc.nextLine();
		System.out.println("Enter the patient id: ");
		String patientId = sc.nextLine();
		System.out.println("Enter the patient age: ");
		int patientAge = sc.nextInt();
		sc.nextLine();
		long patientContact = 0;
		Label: while (true) {
			System.out.println("Enter the patient contact no.: ");
			patientContact = sc.nextLong();
			sc.nextLine();
			if (String.valueOf(patientContact).matches("^[0-9]{10}$")) {

				System.out.println("Enter the specialization requirement: ");

				patientReq = sc.nextLine().toUpperCase();
				break;
			} else {
				System.out.println("Invalid contact no, try again");
				continue Label;

			}
		}

		return new Patient(patientId, patientName, patientAge, patientContact, patientReq);
		// return patientReq;

	}

	public int specializationCheck(String patientReq) {
		int returnvalue = 0;
		int counter = 0;
		// System.out.println(patientReq);
		// System.out.println(storemapdoc.values().contains(patientReq.toUpperCase()));
		for (Entry<String, Doctor> dlist : storemapdoc.entrySet()) {
			String key = dlist.getKey();
			Doctor doctor = dlist.getValue();

			if (doctor.getSpecialization().equalsIgnoreCase(patientReq)) {

				System.out.println(key + "  " + doctor.getName() + "  " + doctor.getAge() + "  " + doctor.specialization
						+ " " + doctor.experience + " ");
				returnvalue = 0;
				for (int i = 0; i < storemapdoc.get(key).getSlot().size(); i++) {
					System.out.println(storemapdoc.get(key).getSlot().get(i).getStartTime() + "-"
							+ storemapdoc.get(key).getSlot().get(i).getEndTime());
					counter++;
				}

			}
		}
		if (counter == 0) {
			System.out.println("No such specialization is present");
			returnvalue = 1;

		}

		return returnvalue;
	}

	String docId = null;

	public Doctor doctorSelect() {
		System.out.println("Enter Doctor Id to select the doctor: ");
		docId = sc.nextLine();

		return storemapdoc.get(docId);
	}

	public Slot slotSelect() {

		int optionIncre = 1;
		// System.out.println(storemapdoc.get(docId));
		for (int i = 0; i < storemapdoc.get(docId).getSlot().size(); i++) {

			System.out.println(optionIncre + ". " + storemapdoc.get(docId).getSlot().get(i).getStartTime() + "-"
					+ storemapdoc.get(docId).getSlot().get(i).getEndTime());
			optionIncre++;

		}

		System.out.println("Enter the input to select the slot: ");
		int slotchoose = sc.nextInt() - 1;
		sc.nextLine();
		return storemapdoc.get(docId).getSlot().get(slotchoose);
	}

	public void AppointmentGenerator() {
		Appointment appointmentNo = new Appointment();
		appointmentNo.setAppointmentNo(1);
		// appointmentNo.setIncreAppointmentNo();
	}

	static int appNo = 1000;

	public int appointmentNoGenerator() {
		appNo = appNo + 1;
		return appNo;

	}

	public void allotSlot() {
		int counter = 0;

		Patient patient = patientDetails();

		int schoice = specializationCheck(patient.getSpecializationRequirement());

		if (schoice == 0) {
			Patient patientObject = new Patient(patient.getPatientId(), patient.getPatientName(),
					patient.getPatientAge(), patient.getPatientContactNo(), patient.getSpecializationRequirement());
			storePatient.put(patient.getPatientId(), patientObject);

			// for (Entry<Integer, Appointment> dlist2 : list1.entrySet()) {
			// Integer key = dlist2.getKey();
			// Appointment doctor = dlist2.getValue();

			int appointmentNoo = appointmentNoGenerator();
			Appointment appointment = new Appointment(appointmentNoo, patient, doctorSelect(), slotSelect(),
					LocalDate.now());
			list1.put(appointmentNoo, appointment);
			// System.out.println(list1.size());

			doctorReceipt(appointment.getPatient().getPatientName(), appointment.getPatient().getPatientAge(),
					appointment.getPatient().getPatientContactNo(), appointment.getDoctor().getName(),
					appointment.getSlot().getStartTime() + "-" + appointment.getSlot().getEndTime(),
					appointment.getAppointmentNo());
			// System.out.println("DOCTOR BILL");
			System.out.println("DOCTOR AMOUNT IS 100Rs.");
		}

		// list1.get(1).getPatient().getPatientName();
		// list1.get(1).getPatient().getPatientId();
		// list1.get(1).getPatient().getPatientContactNo();

		if (counter == 0) {
			System.out.println("This name doesnt exist");

		}
	}
}