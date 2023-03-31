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
	//bean을 주입하는 어노테이션 @Autowired를 사용하여 bean 주입
	//AbstractApplicationContext스프링 객체를 구해 getBean()메서드로 주입하지 않고 @Autowired사용
	//@Autowired는 생성자, 필드, set메서드로 설정을 해줌
	
	public BDao() {
		template = Constant.template;
	}
	
	public ArrayList<BDto> list() {
		String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC";
		ArrayList<BDto> dtos = (ArrayList<BDto>)template.query(query,new BeanPropertyRowMapper<BDto>(BDto.class));
		//jdbcTemplate의 query메서드를 이용하면 resultSet이 포함된 객체를 반환하므로 이를 ArrayList<BDto>로 형변환
		//select시는 template.query를 사용
		//jdbcTemplate의 insert, update, delete문은 template.update()메서드를 이용
		return dtos;
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {
		//final을 사용한 이유는 java에서 내부클래스에 사용시 fianl을 붙임
		//write메서드는 작성된 게시판 내용을 insert하므로 template의 update()메서드를 사용
		//PreparedStatementCreator와 PreparedStatementSetter 콜백 인터페이스를 사용하는 방법이 있음
		//인터페이스를 익명의 클래스 선언 방식으로 구현(인터페이스의 추상메서드를 직접 구현)
		template.update(new PreparedStatementCreator() {
			//PreparedStatementCreator인터페이스의 콜백 추상 메서드를 구현
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
