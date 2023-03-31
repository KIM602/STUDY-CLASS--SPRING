package com.osm.ajax06;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// DTO클래스
public class AjaxFile {
	public AjaxFile(List<MultipartFile> images, String writer) {
		super();
		this.images = images;
		this.writer = writer;
	}
	public List<MultipartFile> getImages() {
		return images;
	}
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public AjaxFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	private List<MultipartFile> images;
	private String writer;
	
	
}
