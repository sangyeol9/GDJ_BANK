package com.winter.app.product;

import java.util.List;

public class ProductDTO {
	private Long productnum;
	private String productname;
	private String productcontents;
	private Double productrate;
	private Double productjumsu;
	private List<ProductFileDTO> fileDTOs;
	
	

	public List<ProductFileDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<ProductFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public Long getProductnum() {
		return productnum;
	}
	public Double getProductjumsu() {
		return productjumsu;
	}
	public void setProductjumsu(Double productjumsu) {
		this.productjumsu = productjumsu;
	}
	public void setProductnum(Long productnum) {
		this.productnum = productnum;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcontents() {
		return productcontents;
	}
	public void setProductcontents(String productcontents) {
		this.productcontents = productcontents;
	}
	public Double getProductrate() {
		return productrate;
	}
	public void setProductrate(Double productrate) {
		this.productrate = productrate;
	}

	
}
