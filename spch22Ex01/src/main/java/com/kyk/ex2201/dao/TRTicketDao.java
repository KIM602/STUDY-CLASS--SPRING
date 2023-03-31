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

//bean�� ����Ͽ� ����ϹǷ� setter�� �־�� ��
public class TRTicketDao {
	private JdbcTemplate template;
	private PlatformTransactionManager transactionManager;
	//servlet-context.xml bean���� Ŭ������ DataSourceTransactionManager�ε� �̴� PlatformTransactionManager������ Ŭ�����̹Ƿ� �������� ���� ����
	//������
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
		//Ʈ������� ���� ����(���⼭�� �⺻������ ���� : Ʈ������� ������ �����ϰ� ������ Ʈ����� ���� ����)
		TransactionStatus status = transactionManager.getTransaction(definition);
		//DB�� insert�� String�� number�� �־��൵ ����
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
			//���� �̹߻��� commitó��
			transactionManager.commit(status);
		}
		catch(Exception e) {
			e.getMessage();
			transactionManager.rollback(status); //���ܹ߻��� rollback
		}
	}
}
