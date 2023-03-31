package com.kyk.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kyk.ex2201.dto.TicketDto;

//TicketDao�� bean���� ����Ϸ��� �ּ��� setter�޼��尡 �־�� �Ѵ�.
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
		//card���̺��� insert�ϹǷ� template.update()���
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
		
		//ticket���̺��� ī�� ���� ó���� �Է� ���� ���� insert ticket���̺���
		//countnum�� üũ�Ѵ�(1~4���� üũ�Ͽ� �ƴϸ� �����߻�)
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