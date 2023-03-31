package com.kyk.batis01.dto;

//DB BATIS의 컬럼과 매핑하는 데이터 클래스
public class ContentDto {
	private int mId;
	private String mWriter;
	private String mContent;
	
	public ContentDto() {
		super();
	}
	
	public ContentDto(int mId, String mWriter, String mContent) {
		super();
		this.mId = mId;
		this.mWriter = mWriter;
		this.mContent = mContent;
	}
	
	public int getmId() {
		return mId;
	}
	public String getmWriter() {
		return mWriter;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public void setmWriter(String mWriter) {
		this.mWriter = mWriter;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
}
