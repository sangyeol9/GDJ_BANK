package com.winter.app.member;

import javax.servlet.ServletContext;

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
	@Autowired
	private ServletContext context;
	
	public int setJoin(MemberDTO dto,MultipartFile attach) throws Exception {
		int result = dao.setJoin(dto);
		String path = context.getRealPath("/resources/upload/member");
		
		String fileName = manager.fileSave(path, attach);
		System.out.println(path);
		if(!attach.isEmpty()) {
		MemberFileDTO fileDTO = new MemberFileDTO();
		fileDTO.setFileName(fileName);
		fileDTO.setUserName(dto.getUserName());
		fileDTO.setOriName(attach.getOriginalFilename());
		result = dao.setFileJoin(fileDTO);
		}
		
		return result;
	}
	
	public MemberDTO setUpdate(MemberDTO dto) throws Exception{
		int result = dao.setUpdate(dto);
		dto = dao.getDetail(dto);
		return dto;
	}
	public MemberDTO getDetail(MemberDTO dto ) throws Exception{
		return dao.getDetail(dto);
	}
	
	public MemberDTO getLogin (MemberDTO dto ) throws Exception{
		MemberDTO m = dao.getDetail(dto);
		if(m != null) {
			if(m.getPassword().equals(dto.getPassword()))
			{
				return m;
			}
		}
		return null;
	}
	
}
