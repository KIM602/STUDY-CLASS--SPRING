package com.osm.sec.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.osm.sec.dto.JoinDto;

public class SecDao implements ISecDao {

	
	@Autowired
	private SqlSession sqlSession;
	//field autowired 방식 ( 주로 bean에 속성이 없을시)
	//SqlSession은 bean의 SqlSessionTemplate의 상위 인터페이스
	
	@Override
	public String join(JoinDto dto) {
		String result = null;
		
		try {
			int res = sqlSession.insert("join",dto);
			System.out.println(res);
			
			if(res > 0) {
				result = "success";
			}
			else {
				result = "fail";
			}
		}
		catch (Exception e) {
			e.getMessage();
			result = "failed";
		}
		return result;
	}
	@Override
	public JoinDto login(String sId) {
		System.out.println(sId);
		JoinDto result = sqlSession.selectOne("login",sId);
		return result;
	}
	

}
