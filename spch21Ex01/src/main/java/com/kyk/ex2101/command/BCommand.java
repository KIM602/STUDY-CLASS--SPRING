package com.kyk.ex2101.command;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public interface BCommand {
	//�߻�޼���
	public void excute(HttpServletRequest request, Model model);
	
	//request��ü�� Ŭ���̾�Ʈ�κ��� �� �����Ͱ��� ���� ���
	//model��ü�� ��ȯ�� jsp�� ���� ���
	//asMap()���� ����� �����͸� ������ �� �־� �Ķ���� ��ü�� ���
}
