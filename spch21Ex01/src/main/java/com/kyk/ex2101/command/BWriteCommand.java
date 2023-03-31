package com.kyk.ex2101.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kyk.ex2101.dao.BDao;
import com.kyk.ex2101.dto.WriteFormDto;

public class BWriteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, Model model) {
		Map<String, Object> map = model.asMap();
		//속성이름은 보통 문자열이므로 String값은 어떤거나 가능하게 하기위해 Object를 사용하는 Map
		//Model의 asMap()메서드는 Model객체만의 값들을 Map형태로 반환
		WriteFormDto dto = (WriteFormDto)map.get("wdto"); //map의 키값으로 값을 반환
		
		String bName = dto.getbName();
		String bTitle = dto.getbTitle();
		String bContent = dto.getbContent();
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
