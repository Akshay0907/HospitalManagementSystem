package com.model;

import java.util.ArrayList;
import com.model.*;
//import billing.Billing;

public class Medicine {
	private int medicineCode;
	private String medicineName;
	private int medicineQuantity;

	private double medicinePrice;
	private String patientName;

	private Billing bill;

	public Billing getBill() {
		return bill;
	}

	public void setBill(Billing bill) {
		this.bill = bill;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	private ArrayList<Medicine> medList;
	private String expiryDate;

	// SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"),
	// expirydate = formatter1;

	public int getMedicineCode() {
		return medicineCode;
	}

	/**
	 * @param medicineName
	 * @param medicineQuantity
	 * @param medicinePrice
	 * @param expiryDate
	 */

	public Medicine(String medicineName, int medicineQuantity, double medicinePrice, String patientName,
			String expiryDate) {

		this.medicineName = medicineName;
		this.medicineQuantity = medicineQuantity;
		this.medicinePrice = medicinePrice;
		this.patientName = patientName;

		this.expiryDate = expiryDate;
	}

	/**
	 * @param medicineName
	 * @param medicineQuantity
	 * @param medicinePrice
	 * @param medList
	 * @param expiryDate
	 */
	public Medicine(String patientName, ArrayList<Medicine> medList) {

		this.patientName = patientName;
		this.medList = medList;

	}

	public ArrayList<Medicine> getMedList() {
		return medList;
	}

	public void setMedList(ArrayList<Medicine> medList) {
		this.medList = medList;
	}

	public Medicine(String medicineName, int medicineQuantity, double medicinePrice, String expiryDate) {

		this.medicineName = medicineName;
		this.medicineQuantity = medicineQuantity;
		this.medicinePrice = medicinePrice;
		this.expiryDate = expiryDate;
	}

	public void setMedicineCode(int medicineCode) {
		this.medicineCode = medicineCode;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getMedicineQuantity() {
		return medicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
