package com.kyk.ex2101.dto;

//클라이언트 writeForm.jsp의 form과 매핑되는 DTO클래스
public class WriteFormDto {
	private String bName;
	private String bTitle;
	private String bContent;
	
	public WriteFormDto() {
		super();
	}
	
	public WriteFormDto(String bName, String bTitle, String bContent) {
		super();
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}
	
	public String getbName() {
		return bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
}
