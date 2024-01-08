package com.winter.app.product;

public class ProductPager {
	private int start_num;
	private int last_num;
	private int page;
	private int pager;
	
	public void getNum() {
		this.last_num = this.getPage()*this.getPager();
		this.start_num = this.last_num - this.getPager() + 1;
	}
	
	public int getStart_num() {
		return start_num;
	}
	public void setStart_num(int start_num) {
		this.start_num = start_num;
	}
	public int getLast_num() {
		return last_num;
	}
	public void setLast_num(int last_num) {
		this.last_num = last_num;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	
	
}
