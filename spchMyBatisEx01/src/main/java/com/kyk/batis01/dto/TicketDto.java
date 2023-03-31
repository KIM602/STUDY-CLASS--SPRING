package com.kyk.batis01.dto;

public class TicketDto {
	private String consumerId;
	private String amount;
	
	public TicketDto() {
		super();
	}
	
	public TicketDto(String consumerId, String amount) {
		super();
		this.consumerId = consumerId;
		this.amount = amount;
	
	}
	public String getConsumerId() {
		return consumerId;
	}
	public String getAmount() {
		return amount;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
