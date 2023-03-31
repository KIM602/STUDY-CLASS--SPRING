package com.kyk.ex2201.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.kyk.ex2201.dto.TicketDto;

public class TPTicketDao {
	private JdbcTemplate template;
	private TransactionTemplate transactionTemplate;
	
	public TPTicketDao() {
		super();
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public void tpbuyTicket(final TicketDto dto) {
		System.out.println("tpbuyTicket()");
		System.out.println("CounsumerId : " + dto.getConsumerId());
		System.out.println("Amount : " + dto.getAmount());
		//transactionTemplate��ü�� transaction������ execute()�޼��带 ���
		//commit�̳� rollback�� �˾Ƽ� ó��
		//execute�� �Ķ���ͷδ� TransactionCallbackWithoutResult�������̽��� �͸��� Ŭ������ ���
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String query = "INSERT INTO CARD (CONSUMERID, AMOUNT) VALUES (?,?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						return pstmt;
					}
				});
				
				template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String query = "INSERT INTO TICKET (CONSUMERID, COUNTNUM) VALUES (?,?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setString(2, dto.getAmount());
						return pstmt;
					}
				});
			}
		});
	}
}