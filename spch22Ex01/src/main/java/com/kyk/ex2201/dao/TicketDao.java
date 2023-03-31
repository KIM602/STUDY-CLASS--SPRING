package com.kyk.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kyk.ex2201.dto.TicketDto;

//TicketDao를 bean으로 사용하려면 최소한 setter메서드가 있어야 한다.
public class TicketDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public TicketDao() {
		super();
	}
	
	public void buyTicket(final TicketDto dto) {
		System.out.println("buyTicket()");
		System.out.println("ComsumerId() : " + dto.getConsumerId());
		System.out.println("Amount() : " + dto.getAmount());
		//card테이블에 insert하므로 template.update()사용
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO CARD(CONSUMERID, AMOUNT) VALUES (?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		//ticket테이블에 카드 결제 처리시 입력 받은 값을 insert ticket테이블은
		//countnum을 체크한다(1~4값을 체크하여 아니면 에러발생)
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO TICKET(CONSUMERID, COUNTNUM) VALUES (?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setString(2, dto.getAmount());
				
				return pstmt;
			}
		});
	}
}
