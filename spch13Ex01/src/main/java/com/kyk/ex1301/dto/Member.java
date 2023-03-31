package com.kyk.ex1301.dto;

//Ŭ���̾�Ʈ���� �����ϴ� �Ķ���Ϳ� ���� ��������� ���� DTOŬ����
public class Member {
	private String name;
	private String id;
	private String pw;
	private String email;
	
	public Member() {
		super();
	}

	public Member(String name, String id, String pw, String email) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
