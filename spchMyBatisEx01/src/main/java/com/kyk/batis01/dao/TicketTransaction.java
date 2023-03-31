package com.kyk.batis01.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyk.batis01.dto.TicketDto;

@Service
@Transactional
public class TicketTransaction {
	public boolean transAction(ContentDao dao, TicketDto dto) throws Exception {
		/*
		//card처리 dao의 메서드
		dao.writeCard(dto);
		//ticket처리 메서드
		dao.writeTicket(dto);
		
		return true;
		}
		 */
		
		try {
			dao.writeCard(dto);
			dao.writeTicket(dto);
		}
		catch(Exception e) {
			throw new Exception();
		}
		return true;
	}
}
