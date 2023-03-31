package com.kyk.spUpDown;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
//@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
//form�� enctype�� multipart/form-data�� ó���ϴ� ������̼�
//maxFileSize�� �ִ� ���ε� ���� ũ��
//maxRequestSize�� request��ü�� ���� �� �ִ� �ִ� ������� ���� default(-1)�� ���Ѵ�
//location�� ������ġ (���� ���)
//bean���� �����ô� �ʿ����
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "upload";
	}
	
	@RequestMapping("/uploadSingle")
	public String uploadSingle(MultipartHttpServletRequest mtpRequest, Model model) {
		//MultipartHttpServletRequest�� form�� ������Ͱ��� getParameter()�޼���� ��ȯ
		String src = mtpRequest.getParameter("src"); //�ø���� �̸�
		System.out.println("�ø���� : " + src);
		//form�� �ø� ������ getFile("name�Ӽ�")
		MultipartFile mf = mtpRequest.getFile("file");
		//MultipartFile MultipartRequest.getFile(String name) ��, form���� �� ���ϰ�ü�� MultipartFile��ü��
		//������ǥ��, path1�� ������Ʈ ������ġ, path2�� ��Ĺ���� ������ġ
		//��Ŭ�������� ����� �̹����� �ٷ� �Ⱥ��̴� ��찡 �־� ��Ĺ�� ���� ����(���� ���񽺽ô� path2�� �ʿ����)
		String path1 = "D:/KYK/workspace/spUpDown/src/main/webapp/resources/upImage/";
		String path2 = "D:/KYK/util/apache-tomcat-9.0.63/wtpwebapps/spUpDown/resources/upImage/";
		
		//form���� ���� ���ϸ�
		String originFileName = mf.getOriginalFilename();
		//���� ������ ���� ������(long�� ����Ʈ ����)
		long fileSize = mf.getSize();
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);
		
		//���ε�� ���ϵ��� ������ �̸��� ���� ��찡 �����Ƿ� ������ �̸����� �����Ͽ� �����ؾ� ��
		//���� �����ڷ� System.currentTimeMillis()�� ���ϸ� �տ� ����
		long pfix = System.currentTimeMillis();
		String safeFile1 = path1 + pfix + originFileName; //pfix + originFileName�� ����Ǵ� ���� �̸�
 		String safeFile2 = path2 + pfix + originFileName;
		
 		String dfile = pfix + originFileName; //�ٿ�ε� �׽�Ʈ�� ���� �̸�
 		try {
 			//MultipartFile�� transferTo(File dest) throws IOException, IllegalStateException
 			//�޼���� �Ķ������ ���� ��ü�� ����
 			mf.transferTo(new File(safeFile1));
 			mf.transferTo(new File(safeFile2));
 			
 		}
 		catch(Exception e) {
 			e.printStackTrace();
 		}
 		
 		model.addAttribute("author", src);
 		model.addAttribute("fileName", dfile);
 		model.addAttribute("fileSize", fileSize);
		return "download";
	}
	
	@RequestMapping("/uploadMulti")
	public String uploadMulti(MultipartHttpServletRequest mtpRequest, Model model) {
		List<MultipartFile> fileList = mtpRequest.getFiles("file");
		//List<MultipartFile> MultipartRequest.getFiles(String name)
		String src = mtpRequest.getParameter("src");
		System.out.println("�ø���� : " + src);
				
		String path1 = "D:/KYK/workspace/spUpDown/src/main/webapp/resources/upImage/";
		String path2 = "D:/KYK/util/apache-tomcat-9.0.63/wtpwebapps/spUpDown/resources/upImage/";
		
		//���ε��� ���� ������ŭ �ݺ�
		for(MultipartFile mf : fileList) {
			String originFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			System.out.println("originFileName : " + originFileName);
			System.out.println("fileSize : " + fileSize);
			
			long pfix = System.currentTimeMillis();
			String safeFile1 = path1 + pfix + originFileName;
			String safeFile2 = path2 + pfix + originFileName;
			
			String dfile = pfix + originFileName;
			
			try { 
				mf.transferTo(new File(safeFile1));
	 			mf.transferTo(new File(safeFile2));
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return "complete";
	}
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("download");
		//<a href="download?file_name="></a> ���� ��û�� ���� parameter�� ��ȯ
		String fileName = request.getParameter("file_name");
		String sDownloadPath = "D:/KYK/workspace/spUpDown/src/main/webapp/resources/upImage/";
		String sFilePath = sDownloadPath + fileName;
		
		byte b[] = new byte[4096];
		//������ �о�� ����Ʈ�� �����ϴ� �迭(�̹��� ���� �ؽ�Ʈ�δ� ���޾Ƽ� stream���� ����)
		//���Ϸκ��� �о���� InputStream(byte���·� �о��)
		FileInputStream fileInputStream = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		//������ ���¸� ��Ÿ���� MimeType�� ����. type/subtype���� �����Ǹ� type�� ī�װ� subtype�� ������ Ÿ��
		//text/plain, text/html, image/jpeg
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		//fileName���� UTF-8���·� �� byte���� 8859-1�� ���ڵ��Ͽ� ��ȯ
		//���Ͽ��� �о�� ����Ʈ��Ʈ���� ���� ���ڵ� ����� response��ü�� ����
		response.setHeader("Content-Disposition",	"attachment; filename =" + sEncoding);
		//�о�� ����Ʈ��Ʈ���� ��� ��Ʈ���� ���ָ� client�� ����
		ServletOutputStream servletOutStream = response.getOutputStream();
		int numRead;
		while((numRead = fileInputStream.read(b, 0, b.length)) != -1) {
			//read(�������Ʈ�迭, ���ۻ��ι�ȣ, �ִ� ����)�� ������ǲ��Ʈ������ �� ���� ����Ʈ ������ ��ȯ
			//-1�� ���� ���� ����[-1���� EOF(������ ���� ��Ÿ���� ����)�ε� �̰��� ���ö����� �ݺ��ض�]
			servletOutStream.write(b, 0, numRead);
		}
		servletOutStream.flush(); //buffer clear
		
		servletOutStream.close();
		fileInputStream.close();
	}
}
