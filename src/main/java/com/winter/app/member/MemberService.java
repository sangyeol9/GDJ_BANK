package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	@Autowired
	private FileManager manager;
	public int setJoin(MemberDTO dto,MultipartFile attach) throws Exception {
		int result = dao.setJoin(dto);
		String path = "/resources/upload/member";
		
		String fileName = manager.fileSave(path, attach);
		
		if(!attach.isEmpty()) {
		MemberFileDTO fileDTO = new MemberFileDTO();
		fileDTO.setFileName(fileName);
		fileDTO.setUserName(dto.getUserName());
		fileDTO.setOriName(attach.getOriginalFilename());
		result = dao.setFileJoin(fileDTO);
		}
		
		return result;
	}
	
}
