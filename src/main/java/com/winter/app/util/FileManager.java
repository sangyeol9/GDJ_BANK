package com.winter.app.util;

import java.io.File;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	public boolean fileDelete(String path,String filename) throws Exception{
		File file = new File(path,filename);
		return file.delete();
		
	}
	
	
	
	
	public String fileSave(String path,MultipartFile  file) throws Exception{
		
		//1. 어디에 저장 ?
				
				
				System.out.println(path);
				
				File f = new File(path);
				if(f.isFile()) throw new Exception();
				
				if(!f.exists())  f.mkdirs();
				
			//2. 어떤 파일명으로 저장?
				Calendar calendar = Calendar.getInstance();
				String filename = calendar.getTimeInMillis()+"_"+file.getOriginalFilename();
			
			
			f = new File(f,filename);
				
			//3.파일 저장   filecopyutils 사용
				//FileCopyUtils.copy(file.getBytes(),f);
			//b multipartfile의 transferto 메서드 사용
				file.transferTo(f);
				return filename;
	}
	
}
