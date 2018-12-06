package com.brms.book;

import com.brms.member.Member;

public class Book {

	private String bNum; // 책 넘버
	private String bTitle; // 이름
	private boolean bCanRental; // 대여 여부
	private Member bMember; // 누가 대여를 했는지?
	
	public Book(String bNum, String bTitle, boolean bCanRental, Member bMember) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bCanRental = bCanRental;
		this.bMember = bMember;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public boolean isbCanRental() {
		return bCanRental;
	}

	public void setbCanRental(boolean bCanRental) {
		this.bCanRental = bCanRental;
	}

	public Member getbMember() {
		return bMember;
	}

	public void setbMember(Member bMember) {
		this.bMember = bMember;
	}
	
}