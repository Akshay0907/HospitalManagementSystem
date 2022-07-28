package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.model.Medicine;

public class MedicineService extends AppointmentService {
	Scanner sc = new Scanner(System.in);
	public static HashMap<Integer, Medicine> storeMedicine = new HashMap<>();
	public static HashMap<Integer, Medicine> medicineBill = new HashMap<>();

	public int billNo() {

		billNo = billNo + 1;
		return billNo;

	}

	public void medicineDataStore() {
		storeMedicine.put(120, new Medicine("HYDROCODONE", 50, 67.66, "2023-07-12"));
		storeMedicine.put(121, new Medicine("Calcium", 25, 50, "2023-06-15"));
		storeMedicine.put(122, new Medicine("Crocine", 50, 67.66, "2023-07-12"));
	}

	public void addMedicine() {
		System.out.println("Adding medicine\n" + "Enter medicine code: ");
		int medCode = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter medicine Name: ");
		String medName = sc.nextLine();
		System.out.println("Enter quantity: ");
		int medQuantity = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter medicine Price: ");
		double medPrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter expiry date(YYYY-MM-DD): ");
		String medExpiry = sc.nextLine();

		storeMedicine.put(medCode, new Medicine(medName, medQuantity, medPrice, medExpiry));
		System.out.println("Medicine Stored successfully");

	}

	public void removeMedicine() {
		System.out.println("Removing medicine\n" + "Enter medicine code: ");
		int RemoveMedCode = sc.nextInt();
		sc.nextLine();

		if (storeMedicine.containsKey(RemoveMedCode)) {
			storeMedicine.remove(RemoveMedCode);
			System.out.println("Medicine with " + RemoveMedCode + " Id removed successfully");
		} else {
			System.out.println("Invalid Id, Do you want to try again(Y/N)");
			B: while (true) {
				String choice = sc.nextLine();
				if (choice.equalsIgnoreCase("Y")) {
					removeMedicine();
				} else if (choice.equalsIgnoreCase("N")) {
					System.out.println("No Medicine Removed");
					break;
				} else
					System.out.println("Invalid response, try again(Y/N)");
				continue B;
			}

		}

	}

	public void medicineList() {
		for (Entry<Integer, Medicine> dlist : storeMedicine.entrySet()) {
			Integer key = dlist.getKey();
			Medicine d = dlist.getValue();

			System.out.println(key + "  " + d.getMedicineName() + "  " + d.getMedicineQuantity() + "  "
					+ d.getMedicinePrice() + " " + d.getExpiryDate());

		}
	}

	int mediQuantity;
	double price;
	static int billNo = 1;
	ArrayList<Medicine> temproryList = new ArrayList<>();

	public void billMedicine() {

		System.out.println("Enter your name: ");
		String patientName = sc.nextLine();
		// medicineBill.put(1, new Medicine("fgsgsg",new ArrayList<Medicine>()));
		// medicineBill.get(1).getMedList().add(new Medicine("grsgg",5,5,"rsgg"));
		Label: while (true) {

			Label1: while (true) {
				System.out.println("Enter the medicine name: ");
				String mediName = sc.nextLine();
				int checker = 0;
				for (Entry<Integer, Medicine> dlist2 : storeMedicine.entrySet()) {
					Integer key = dlist2.getKey();
					Medicine medicine = dlist2.getValue();

					// System.out.println(medicine.getMedicineName());
					if (medicine.getMedicineName().equalsIgnoreCase(mediName)) {
						checker++;
						System.out.println("Enter the quantity of the medicine: ");
						int mediQuantity = sc.nextInt();
						sc.nextLine();
						// System.out.println(medicine.getMedicineName());
						if (medicine.getMedicineQuantity() >= mediQuantity) {
							medicine.setMedicineQuantity(medicine.getMedicineQuantity() - mediQuantity);
							price = medicine.getMedicinePrice() * mediQuantity;

							temproryList.add(new Medicine(mediName, mediQuantity, price, medicine.getExpiryDate()));
							// medicineBill.put(billNo, new Medicine(patientName,new
							// ArrayList<Medicine>()));
							// medicineBill.get(billNo).getMedList().add(new
							// Medicine(mediName,mediQuantity,price,medicine.getExpiryDate()));

							// //medicineBillPrint(patientName,billNo,medicineBill.get(1).getMedList());
						} else {
							System.out.println("available quantity is: " + medicine.getMedicineQuantity()
									+ " if you want to take enter(Y/N)");
							String choice = sc.nextLine();
							if (choice.equalsIgnoreCase("Y")) {
								mediQuantity = medicine.getMedicineQuantity();
								medicine.setMedicineQuantity(0);
								price = medicine.getMedicinePrice() * mediQuantity;

								temproryList.add(new Medicine(mediName, mediQuantity, price, medicine.getExpiryDate()));
								// medicineBill.put(billNo, new Medicine(patientName,new
								// ArrayList<Medicine>()));
								// medicineBill.get(billNo).getMedList().add(new
								// Medicine(mediName,mediQuantity,price,medicine.getExpiryDate()));;
								// medicineBillPrint(patientName,billNo,medicineBill.get(1).getMedList());
							} else {
								System.out.println("chal chal aage badh");

							}
						}
					}
				}
				if (checker == 0) {
					System.out.println("Medicine not available");

				}
				System.out.println("do you want to take more medicine:(Y/N)");
				String userChoice = sc.nextLine();
				if (userChoice.equalsIgnoreCase("Y")) {

					continue Label1;
				} else if (userChoice.equalsIgnoreCase("N")) {
					medicineBill.put(billNo, new Medicine(patientName, new ArrayList<Medicine>()));
					medicineBill.get(billNo).getMedList().addAll(temproryList);
					medicineBillPrint(patientName, billNo, medicineBill.get(billNo).getMedList());

					temproryList.clear();
					billNo = billNo();
					System.out.println(billNo);
					System.out.println("Thank you");
					break;
				} else {
					System.out.println("Invalid response, try again");
					continue Label;
				}
			}
			break;
		}

	}

	// double totalPrice=0;
	public void medicineBillPrint(String patientName, int billNo, ArrayList<Medicine> mediList) {

		System.out.printf("%10s\n%10s%72s",
				"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++BILL RECEIPT++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n",
				"Name of the Medical Institution:THOUGHTPEARL HOSPITAL", "\t Bill no.:" + billNo);
		System.out.printf("\n%10s%112s", " ", " \t Date:" + String.valueOf(LocalDate.now()));
		System.out.println("\nPatient Name: " + patientName);
		double totalPrice = 0;
		for (Entry<Integer, Medicine> dlist2 : medicineBill.entrySet()) {
			Integer key = dlist2.getKey();
			Medicine medicine = dlist2.getValue();
			// System.out.println(key);
			if (key.equals(billNo)) {
				for (int i = 0; i < medicineBill.get(key).getMedList().size(); i++) {

					System.out.print("\n\nMedicine Name: " + medicine.getMedList().get(i).getMedicineName());
					System.out.print("\t\t\tMedicine Quantity: " + medicine.getMedList().get(i).getMedicineQuantity());
					System.out.println("\t\t\tMedicine Price: " + medicine.getMedList().get(i).getMedicinePrice()
							+ "\t\t\tExpiry Date: " + medicine.getMedList().get(i).getExpiryDate());
					totalPrice = totalPrice + (medicine.getMedList().get(i).getMedicinePrice());
				}
			}
		}
		System.out.printf("Total Price: %.2f\n", totalPrice);
	}

	public void showRecordBil() {
		System.out.println(medicineBill.size());

		for (Entry<Integer, Medicine> dlist : medicineBill.entrySet()) {
			Integer key = dlist.getKey();
			Medicine medicine = dlist.getValue();
			double totalPrice = 0;
			System.out.println();
			System.out
					.println("\t\t\t\t\t\t\t\t\t\t\tBillNo: " + key + "\nPatient Name:  " + medicine.getPatientName());
			for (int i = 0; i < medicineBill.get(key).getMedList().size(); i++) {

				System.out.print("\nMedicine Name: " + medicine.getMedList().get(i).getMedicineName());
				System.out.print("\t\t\tMedicine Quantity: " + medicine.getMedList().get(i).getMedicineQuantity());
				System.out.println("\t\t\tMedicine Price: " + medicine.getMedList().get(i).getMedicinePrice()
						+ "\t\t\tExpiry Date: " + medicine.getMedList().get(i).getExpiryDate());

				totalPrice = totalPrice + (medicine.getMedList().get(i).getMedicinePrice());
			}
			System.out.printf("Total Price: %.2f", totalPrice);
		} // System.out.println(medicineBill.get(key).getMedList().size());System.out.println(medicineBill.size());e

	}

	public void receptOfBillusingbillno() {
		System.out.println("Enter the Bill no: ");
		int choice = sc.nextInt();
		int counter = 0;
		for (Entry<Integer, Medicine> dlist2 : medicineBill.entrySet()) {
			Integer key = dlist2.getKey();
			Medicine medicine = dlist2.getValue();
			if (medicineBill.containsKey(choice)) {
				medicineBillPrint(medicine.getPatientName(), key, medicine.getMedList());
			} else
				counter++;
			System.out.println("Bill no doesnt exist");

		}
		if (counter == 0) {
			System.out.println("Bill no doesnt exist");
		}
	}

}
