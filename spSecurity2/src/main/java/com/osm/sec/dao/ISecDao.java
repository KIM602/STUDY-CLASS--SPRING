package com.osm.sec.dao;

import com.osm.sec.dto.JoinDto;
// mybatis를 사용하기 위해서 추상메서드들을 만듬 
public interface ISecDao {
	//추상메서드들
	public String join(JoinDto dto);
	public JoinDto login(String sId);
}
