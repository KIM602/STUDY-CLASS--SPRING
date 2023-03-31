package com.kyk.batis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kyk.batis01.dto.ContentDto;
import com.kyk.batis01.dto.TicketDto;

public class ContentDao implements iDao {
	private SqlSession sqlSession; //SqlSessionTemplate�� ������ �������̽�

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
		//insert�� sql�� insert�� ó���ϴ� SqlSession�� �޼���
		//ù��° �Ķ���ʹ� �޼����̸�(xml�� id��)�� ���ڿ��� ǥ��
		//�ι�° �Ķ���ʹ� xml�� sql�� �����ϴ� �Ķ���ͷ� object��
		//(���ް��� �Ѱ��� ���� ������ �����ϳ� �ΰ� �̻��� ���� DTO��ü�� ����
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		ArrayList<ContentDto> result = (ArrayList)sqlSession.selectList("listDao");
		//selectList()�޼���� DB���� �ټ����� resultset�� ��ȯ�ϴµ� ���
		//selcetList(�޼����̸�)�� Object�� ��ȯ�ϹǷ� (ArrayList)�� ����ȯ
		return result;
	}

	@Override
	public void deleteDao(String mId) {
		sqlSession.delete("deleteDao", Integer.parseInt(mId));
		//form���� ���� mId�� String�̰� ���̺��� mId�� number�̹Ƿ� ������ ��ȯ
	}

	@Override
	public ContentDto viewDao(String mId) {
		//Batis���̺��� mId�� ��ġ�ϴ� ���ڵ� �����̹Ƿ� �Ѱ��� ���ڵ常 ��ȯ
		ContentDto result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		//seslectOne()�޼���� select�� ����� �ϳ��� ���ڵ��Ͻ� ���(������ ��Ű�� ��)
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
