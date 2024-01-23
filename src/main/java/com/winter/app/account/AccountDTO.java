package com.winter.app.account;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.product.ProductDTO;
import com.winter.app.util.Paser;

public class AccountDTO {

	private Long account_num;
	private String account_pw;
	private Date account_date;
	private Long account_balance;
	private String userName;
	private Long productNum;
	
	
	private Paser pager;
	
	
	

	public Paser getPager() {
		return pager;
	}
	public void setPager(Paser pager) {
		this.pager = pager;
	}
	public Long getAccount_num() {
		return account_num;
	}
	public void setAccount_num(Long account_num) {
		this.account_num = account_num;
	}

	public String getAccount_pw() {
		return account_pw;
	}
	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}
	public Date getAccount_date() {
		return account_date;
	}
	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}
	public Long getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(Long account_balance) {
		this.account_balance = account_balance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	@Override
	public String toString() {
		return "AccountDTO [account_num=" + account_num + ", account_pw=" + account_pw + ", account_date="
				+ account_date + ", account_balance=" + account_balance + ", userName=" + userName + ", productNum="
				+ productNum + ", pager=" + pager + "]";
	}
	
	
}
