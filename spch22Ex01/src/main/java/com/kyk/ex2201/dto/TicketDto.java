package com.kyk.ex2201.dto;

//form의 매핑 DTO 클래스
public class TicketDto {
	private String consumerId;
	private String amount;
	
	public TicketDto() {
		super();
	}
	
	public TicketDto(String consumId, String amount) {
		super();
		this.consumerId = consumId;
		this.amount = amount;
	}
	
	public String getConsumerId() {
		return consumerId;
	}
	public String getAmount() {
		return amount;
	}
	public void setConsumerId(String consumId) {
		this.consumerId = consumId;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
