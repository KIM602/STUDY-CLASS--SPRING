package com.kyk.batis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kyk.batis01.dto.ContentDto;
import com.kyk.batis01.dto.TicketDto;

public class ContentDao implements iDao {
	private SqlSession sqlSession; //SqlSessionTemplate가 구현한 인터페이스

	public ContentDao() {
		super();
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDto dto = new ContentDto(0, mWriter, mContent);
		sqlSession.insert("writeDao",dto);
		//insert는 sql문 insert를 처리하는 SqlSession의 메서드
		//첫번째 파라메터는 메서드이름(xml의 id값)을 문자열로 표시
		//두번째 파라메터는 xml의 sql로 전달하는 파라메터로 object형
		//(전달값이 한개일 때는 값으로 전달하나 두개 이상일 때는 DTO객체로 전달
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		ArrayList<ContentDto> result = (ArrayList)sqlSession.selectList("listDao");
		//selectList()메서드는 DB에서 다수개의 resultset을 반환하는데 사용
		//selcetList(메서드이름)은 Object를 반환하므로 (ArrayList)로 형변환
		return result;
	}

	@Override
	public void deleteDao(String mId) {
		sqlSession.delete("deleteDao", Integer.parseInt(mId));
		//form에서 받은 mId는 String이고 테이블의 mId는 number이므로 정수로 변환
	}

	@Override
	public ContentDto viewDao(String mId) {
		//Batis테이블의 mId가 일치하는 레코드 보기이므로 한개의 레코드만 반환
		ContentDto result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		//seslectOne()메서드는 select의 결과가 하나의 레코드일시 사용(조건이 주키일 때)
		return result;
	}

	@Override
	public void writeCard(TicketDto dto) {
		sqlSession.insert("writeCard", dto);
	}

	@Override
	public void writeTicket(TicketDto dto) {
		sqlSession.insert("writeTicket", dto);
	}
}
