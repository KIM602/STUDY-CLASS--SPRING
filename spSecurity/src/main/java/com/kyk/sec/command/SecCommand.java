package com.kyk.sec.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface SecCommand {
	//�߻�޼���
	public void execute(HttpServletRequest request, Model model);
}
