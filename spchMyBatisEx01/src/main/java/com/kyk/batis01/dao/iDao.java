package com.kyk.batis01.dao;

import java.util.ArrayList;

import com.kyk.batis01.dto.ContentDto;
import com.kyk.batis01.dto.TicketDto;

public interface iDao {
	//추상메서드들
	public void writeDao(String mWriter, String mContent);
	public  ArrayList<ContentDto> listDao();
	public void deleteDao(String mId);
	public ContentDto viewDao(String mId);
	public void writeCard(TicketDto dto);
	public void writeTicket(TicketDto dto);
}
