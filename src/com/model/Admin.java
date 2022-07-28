package com.model;

public class Admin {
	private String adminId;
	private String pwd;
	private String name;
	private int age;

	public Admin(String pwd, String name, int age) {

		this.pwd = pwd;
		this.name = name;
		this.age = age;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}