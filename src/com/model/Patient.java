package com.model;

public class Patient {

	private String patientId;
	private String patientName;
	private int patientAge;
	private long patientContactNo;
	private String SpecializationRequirement;

	public Patient(String patientId, String patientName, int patientAge, long patientContactNo,
			String specializationRequirement) {

		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientContactNo = patientContactNo;
		SpecializationRequirement = specializationRequirement;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientContactNo() {
		return patientContactNo;
	}

	public void setPatientContactNo(long patientContactNo) {
		this.patientContactNo = patientContactNo;
	}

	public String getSpecializationRequirement() {
		return SpecializationRequirement;
	}

	public void setSpecializationRequirement(String specializationRequirement) {
		SpecializationRequirement = specializationRequirement;
	}

}
