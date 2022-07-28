package com.model;

import java.time.LocalDate;

public class Appointment {

	private static Integer increAppointmentNo = 1;

	private Integer appointmentNo;
	private Doctor doctor;
	private Patient patient;
	private Slot slot;
	private LocalDate date;

	public static Integer getIncreAppointmentNo() {
		return increAppointmentNo;
	}

	public static void setIncreAppointmentNo(Integer increAppointmentNo) {
		Appointment.increAppointmentNo = increAppointmentNo;
	}

	public Integer getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(Integer appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Appointment(Integer appointmentNo, Patient patient, Doctor doctor, Slot slot, LocalDate date) {

		this.appointmentNo = appointmentNo;
		this.doctor = doctor;
		this.patient = patient;
		this.slot = slot;
		this.date = date;
	}

	public Appointment() {
		
	}

}
