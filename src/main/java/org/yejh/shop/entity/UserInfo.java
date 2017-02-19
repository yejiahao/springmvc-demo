package org.yejh.shop.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class UserInfo implements RowMapper<UserInfo>, Serializable {
	private static final long serialVersionUID = 692184968611957877L;
	private Integer id;
	private String uName;
	private Integer uNumber;
	private Date uRegisterTime;

	public UserInfo() {
	}

	public UserInfo(String uName, Integer uNumber, Date uRegisterTime) {
		this.uName = uName;
		this.uNumber = uNumber;
		this.uRegisterTime = uRegisterTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public Integer getuNumber() {
		return uNumber;
	}

	public void setuNumber(Integer uNumber) {
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
		return "UserInfo [id=" + id + ", uName=" + uName + ", uNumber=" + uNumber + ", uRegisterTime=" + uRegisterTime
				+ "]";
	}

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(rs.getInt("id"));
		userInfo.setuName(rs.getString("uname"));
		userInfo.setuNumber(rs.getInt("unumber"));
		userInfo.setuRegisterTime(rs.getDate("uregister_time"));
		return userInfo;
	}

}
