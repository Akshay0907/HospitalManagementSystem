package com.model;

import java.util.ArrayList;

public class Doctor {

	private String doctorId;
	private String pwd;
	private String name;

	public String specialization;
	public int experience;
	private int age;
	private ArrayList<Slot> slot;

	public Doctor(String pwd, String name, String specialization, int experience, int age, ArrayList<Slot> slot) {

		this.pwd = pwd;
		this.name = name;
		this.specialization = specialization;
		this.experience = experience;
		this.age = age;
		this.slot = slot;
		// slot.add(Slot);

	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Slot> getSlot() {
		return slot;
	}

	public void setSlot(ArrayList<Slot> slot) {
		this.slot = slot;
	}

}
