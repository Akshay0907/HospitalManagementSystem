package com.model;

public class MedicineToPatient {
	private Integer BillNo;

	private Patient patient;

	/**
	 * @param billNo
	 * @param patient
	 */
	public MedicineToPatient(Integer billNo, Patient patient) {
		super();
		BillNo = billNo;
		this.patient = patient;
	}

	public Integer getBillNo() {
		return BillNo;
	}

	public void setBillNo(Integer billNo) {
		BillNo = billNo;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
