package com.kyk.ex2101.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.kyk.ex2101.dto.BDto;
import com.kyk.ex2101.util.Constant;

public class BDao {
	JdbcTemplate template;
	//bean�� �����ϴ� ������̼� @Autowired�� ����Ͽ� bean ����
	//AbstractApplicationContext������ ��ü�� ���� getBean()�޼���� �������� �ʰ� @Autowired���
	//@Autowired�� ������, �ʵ�, set�޼���� ������ ����
	
	public BDao() {
		template = Constant.template;
	}
	
	public ArrayList<BDto> list() {
		String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC";
		ArrayList<BDto> dtos = (ArrayList<BDto>)template.query(query,new BeanPropertyRowMapper<BDto>(BDto.class));
		//jdbcTemplate�� query�޼��带 �̿��ϸ� resultSet�� ���Ե� ��ü�� ��ȯ�ϹǷ� �̸� ArrayList<BDto>�� ����ȯ
		//select�ô� template.query�� ���
		//jdbcTemplate�� insert, update, delete���� template.update()�޼��带 �̿�
		return dtos;
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {
		//final�� ����� ������ java���� ����Ŭ������ ���� fianl�� ����
		//write�޼���� �ۼ��� �Խ��� ������ insert�ϹǷ� template�� update()�޼��带 ���
		//PreparedStatementCreator�� PreparedStatementSetter �ݹ� �������̽��� ����ϴ� ����� ����
		//�������̽��� �͸��� Ŭ���� ���� ������� ����(�������̽��� �߻�޼��带 ���� ����)
		template.update(new PreparedStatementCreator() {
			//PreparedStatementCreator�������̽��� �ݹ� �߻� �޼��带 ����
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO MVC_BOARD(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)" 
												+ "VALUES(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
	}
}
