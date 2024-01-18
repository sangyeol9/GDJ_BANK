package com.winter.app.member;

public class MemberDTO {
	
	private String userName;
	private String password;
	private String name;
	private String eMail;
	private String phone;
	private String address;
	private MemberFileDTO fileDTO;
	
	
	
	public MemberFileDTO getFileDTO() {
		return fileDTO;
	}
	public void setFileDTO(MemberFileDTO fileDTO) {
		this.fileDTO = fileDTO;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
