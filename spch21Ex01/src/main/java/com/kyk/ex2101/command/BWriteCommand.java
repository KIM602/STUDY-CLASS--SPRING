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
		//�Ӽ��̸��� ���� ���ڿ��̹Ƿ� String���� ��ų� �����ϰ� �ϱ����� Object�� ����ϴ� Map
		//Model�� asMap()�޼���� Model��ü���� ������ Map���·� ��ȯ
		WriteFormDto dto = (WriteFormDto)map.get("wdto"); //map�� Ű������ ���� ��ȯ
		
		String bName = dto.getbName();
		String bTitle = dto.getbTitle();
		String bContent = dto.getbContent();
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
