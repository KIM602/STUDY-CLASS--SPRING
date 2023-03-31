package com.kyk.ex0802;

public class AdminConnection {
	private String adminId;
	private String adminPw;
	private String sub_adminId;
	private String sub_adminPw;
	
	public AdminConnection() {
		super();
	}
	
	public AdminConnection(String adminId, String adminPw, String sub_adminId, String sub_adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.sub_adminId = sub_adminId;
		this.sub_adminPw = sub_adminPw;
	}
	
	public String getAdminId() {
		return adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public String getSub_adminId() {
		return sub_adminId;
	}

	public String getSub_adminPw() {
		return sub_adminPw;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public void setSub_adminId(String sub_adminId) {
		this.sub_adminId = sub_adminId;
	}

	public void setSub_adminPw(String sub_adminPw) {
		this.sub_adminPw = sub_adminPw;
	}
}
