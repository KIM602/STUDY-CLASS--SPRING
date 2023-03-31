package com.kyk.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.kyk.ex2201.dto.TicketDto;

//bean에 등록하여 사용하므로 setter가 있어야 함
public class TRTicketDao {
	private JdbcTemplate template;
	private PlatformTransactionManager transactionManager;
	//servlet-context.xml bean에는 클래스가 DataSourceTransactionManager인데 이는 PlatformTransactionManager구현한 클래스이므로 다형성에 의해 무방
	//생성자
	public TRTicketDao() {
		super();
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void trbuyTicket(final TicketDto dto) {
		System.out.println("trbuyTicket()");
		System.out.println("getConsumerId : " + dto.getConsumerId());
		System.out.println("Amount : " + dto.getAmount());
		
		TransactionDefinition definition = new DefaultTransactionDefinition();
		//트랜잭션의 종류 설정(여기서는 기본값으로 설정 : 트랜잭션이 있으면 참여하고 없으면 트랜잭션 새로 시작)
		TransactionStatus status = transactionManager.getTransaction(definition);
		//DB에 insert시 String을 number에 넣어줘도 무방
		try {
			template.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String query = "INSERT INTO CARD (CONSUMERID, AMOUNT) VALUES (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
			
			template.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String query = "INSERT INTO TICKET (CONSUMERID, COUNTNUM) VALUES (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setString(2, dto.getAmount());
					
					return pstmt;
				}
			});
			//에러 미발생시 commit처리
			transactionManager.commit(status);
		}
		catch(Exception e) {
			e.getMessage();
			transactionManager.rollback(status); //예외발생시 rollback
		}
	}
}
