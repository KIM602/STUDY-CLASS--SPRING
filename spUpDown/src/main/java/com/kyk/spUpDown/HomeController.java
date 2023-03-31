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
//form의 enctype이 multipart/form-data를 처리하는 어노테이션
//maxFileSize는 최대 업로딩 파일 크기
//maxRequestSize는 request객체에 실을 수 있는 최대 사이즈로 보통 default(-1)로 무한대
//location은 파일위치 (절대 경로)
//bean에서 설정시는 필요없음
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
		//MultipartHttpServletRequest도 form의 프라메터값은 getParameter()메서드로 반환
		String src = mtpRequest.getParameter("src"); //올린사람 이름
		System.out.println("올린사람 : " + src);
		//form에 올린 파일은 getFile("name속성")
		MultipartFile mf = mtpRequest.getFile("file");
		//MultipartFile MultipartRequest.getFile(String name) 즉, form에서 온 파일객체는 MultipartFile객체임
		//저장경로표시, path1은 프로젝트 저장위치, path2는 톰캣서버 저장위치
		//이클립스에서 실행시 이미지가 바로 안보이는 경우가 있어 톰캣에 같이 저장(실제 서비스시는 path2는 필요없음)
		String path1 = "D:/KYK/workspace/spUpDown/src/main/webapp/resources/upImage/";
		String path2 = "D:/KYK/util/apache-tomcat-9.0.63/wtpwebapps/spUpDown/resources/upImage/";
		
		//form에서 보낸 파일명
		String originFileName = mf.getOriginalFilename();
		//원래 파일의 파일 사이즈(long형 바이트 단위)
		long fileSize = mf.getSize();
		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);
		
		//업로드된 파일들은 동일한 이름을 갖는 경우가 많으므로 유일한 이름으로 변경하여 저장해야 함
		//유일 구분자로 System.currentTimeMillis()를 파일명 앞에 붙임
		long pfix = System.currentTimeMillis();
		String safeFile1 = path1 + pfix + originFileName; //pfix + originFileName이 저장되는 파일 이름
 		String safeFile2 = path2 + pfix + originFileName;
		
 		String dfile = pfix + originFileName; //다운로드 테스트용 파일 이름
 		try {
 			//MultipartFile의 transferTo(File dest) throws IOException, IllegalStateException
 			//메서드는 파라메터의 파일 객체로 저장
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
		System.out.println("올린사람 : " + src);
				
		String path1 = "D:/KYK/workspace/spUpDown/src/main/webapp/resources/upImage/";
		String path2 = "D:/KYK/util/apache-tomcat-9.0.63/wtpwebapps/spUpDown/resources/upImage/";
		
		//업로드한 파일 갯수만큼 반복
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
		//<a href="download?file_name="></a> 으로 요청한 것의 parameter를 반환
		String fileName = request.getParameter("file_name");
		String sDownloadPath = "D:/KYK/workspace/spUpDown/src/main/webapp/resources/upImage/";
		String sFilePath = sDownloadPath + fileName;
		
		byte b[] = new byte[4096];
		//파일을 읽어와 바이트로 저장하는 배열(이미지 등은 텍스트로는 못받아서 stream으로 받음)
		//파일로부터 읽어오는 InputStream(byte형태로 읽어옴)
		FileInputStream fileInputStream = new FileInputStream(sFilePath);
		String sMimeType = request.getServletContext().getMimeType(sFilePath);
		//파일의 형태를 나타내는 MimeType을 구함. type/subtype으로 구성되며 type은 카테고리 subtype은 각각의 타입
		//text/plain, text/html, image/jpeg
		if(sMimeType == null) {
			sMimeType = "application/octet-stream";
		}
		String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		//fileName에서 UTF-8형태로 된 byte값을 8859-1로 인코딩하여 변환
		//파일에서 읽어온 바이트스트림에 대한 인코딩 방식을 response객체에 설정
		response.setHeader("Content-Disposition",	"attachment; filename =" + sEncoding);
		//읽어온 바이트스트림을 출력 스트림에 써주면 client로 전달
		ServletOutputStream servletOutStream = response.getOutputStream();
		int numRead;
		while((numRead = fileInputStream.read(b, 0, b.length)) != -1) {
			//read(저장바이트배열, 시작색인번호, 최대 개수)는 파일인풋스트림에서 총 읽은 바이트 개수를 반환
			//-1은 읽은 값이 없음[-1값은 EOF(파일의 끝을 나타내는 숫자)인데 이것이 나올때까지 반복해라]
			servletOutStream.write(b, 0, numRead);
		}
		servletOutStream.flush(); //buffer clear
		
		servletOutStream.close();
		fileInputStream.close();
	}
}
