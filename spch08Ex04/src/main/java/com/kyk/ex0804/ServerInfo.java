package com.kyk.ex0804;

public class ServerInfo {
	private String ipNum;
	private String portNum;
	
	public ServerInfo() {
		super();
	}

	public ServerInfo(String ipNum, String portNum) {
		super();
		this.ipNum = ipNum;
		this.portNum = portNum;
	}

	public String getIpNum() {
		return ipNum;
	}

	public String getPortNum() {
		return portNum;
	}

	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}

	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	
}
