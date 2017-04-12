package org.yejh.shop.dto;

import java.util.Date;

public class UserInfoDto {
	private int id;
	private String uName;
	private int uNumber;
	private Date uRegisterTime;

	public UserInfoDto() {

	}

	public UserInfoDto(int id, String uName, int uNumber, Date uRegisterTime) {
		this.id = id;
		this.uName = uName;
		this.uNumber = uNumber;
		this.uRegisterTime = uRegisterTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuNumber() {
		return uNumber;
	}

	public void setuNumber(int uNumber) {
		this.uNumber = uNumber;
	}

	public Date getuRegisterTime() {
		return uRegisterTime;
	}

	public void setuRegisterTime(Date uRegisterTime) {
		this.uRegisterTime = uRegisterTime;
	}

	@Override
	public String toString() {
		return "UserInfoDto [id=" + id + ", uName=" + uName + ", uNumber=" + uNumber + ", uRegisterTime="
				+ uRegisterTime + "]";
	}
}
