package com.kyk.ex2101.command;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface BCommand {
	//추상메서드
	public void excute(HttpServletRequest request, Model model);
	
	//request객체는 클라이언트로부터 온 데이터값을 위해 사용
	//model객체는 반환할 jsp를 위해 사용
	//asMap()으로 저장된 데이터를 추출할 수 있어 파라메터 객체로 사용
}
