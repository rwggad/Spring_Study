package com.brms;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.brms.book.Book;
import com.brms.book.service.BookRegisterService;
import com.brms.book.service.BookSearchService;
import com.brms.member.Member;
import com.brms.member.service.MemberRegisterService;
import com.brms.member.service.MemberSearchService;

public class MainClass {
	/**
	 * 생명주기에 대한 간단한 예쩨*/
	public static void main(String[] args) {

		/**
		 * DataBase를 대신하기 위한 임시 데이터들 */
		String[] bNums = { "739", "985", "184", "830", "816" };
		String[] bTitles = { "html", "css", "jQuery", "java", "spring" };
		
		String[] mIds = { "rabbit", "hippo", "raccoon", "elephan", "lion" };
		String[] mPws = { "96539", "94875", "15284", "48765", "28661" };
		String[] mNames = { "agatha", "barbara", "chris", "doris", "elva" };


		/**
		 * 스프링 컨테이너를 생성한다.
		 *
		 * 생명주기1. 스프링 컨테이너가 생성되면서 Bean(객체) 들이 생성된다.
		 * */
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx.xml");

		/**
		 * 책에 관한 임시 데이터를 등록해준다. */
		BookRegisterService bookRegisterService = 
				ctx.getBean("bookRegisterService", BookRegisterService.class);
		for (int i = 0; i < bNums.length; i++) {
			Book book = new Book(bNums[i], bTitles[i], true, null);
			bookRegisterService.register(book);
		}

		/**
		 * 책 목록 출력*/
		BookSearchService bookSearchService = 
				ctx.getBean("bookSearchService", BookSearchService.class);
		System.out.println("\nbNum\tbTitle\tbCanRen\tbLenderId");
		System.out.println("------------------------------------------");
		for (int i = 0; i < bNums.length; i++) {
			Book book = bookSearchService.searchBook(bNums[i]);
			System.out.print(book.getbNum() + "\t");
			System.out.print(book.getbTitle() + "\t");
			System.out.print(book.isbCanRental() + "\t");
			System.out.println(book.getbMember() == null ? null : book.getbMember().getmId());
		}
		
		/**
		 * 회원에 대한 임시 데이터 등록*/
		MemberRegisterService memberRegisterService =
				ctx.getBean("memberRegisterService", MemberRegisterService.class);
		for (int i = 0; i < mIds.length; i++) {
			Member member = new Member(mIds[i], mPws[i], mNames[i]);
			memberRegisterService.register(member);
		}

		/**
		 * 회원 목록 출력*/
		MemberSearchService memberSearchService = 
				ctx.getBean("memberSearchService", MemberSearchService.class);
		System.out.println("\nmId\tmPw\tmName");
		System.out.println("------------------------------------------");
		for (int i = 0; i < mIds.length; i++) {
			Member member = memberSearchService.searchMember(mIds[i]);
			System.out.print(member.getmId() + "\t");
			System.out.print(member.getmPw() + "\t");
			System.out.print(member.getmName() + "\n");
		}

		/**
		 * 현재 대여된 책들의 목록을 등록한다.*/
		bookRegisterService.register(new Book("739", "html", false, memberSearchService.searchMember("elephan")));
		bookRegisterService.register(new Book("184", "jQuery", false, memberSearchService.searchMember("hippo")));
		bookRegisterService.register(new Book("816", "spring", false, memberSearchService.searchMember("rabbit")));
		bookRegisterService.register(new Book("985", "css", false, memberSearchService.searchMember("rabbit")));

		/**
		 * 대여된 책들을 목록을 출력한다.*/
		System.out.println("\nbNum\tbTitle\tbCanRen\tbLenderId");
		System.out.println("------------------------------------------");
		for (int i = 0; i < bNums.length; i++) {
			Book book = bookSearchService.searchBook(bNums[i]);
			System.out.print(book.getbNum() + "\t");
			System.out.print(book.getbTitle() + "\t");
			System.out.print(book.isbCanRental() + "\t");
			System.out.println(book.getbMember() == null ? null : book.getbMember().getmId());
		}

		/**
		 * 생명주기2. 스프링 컨테이너가 소멸되면서 Bean(객체) 들이 같이 소멸된다.*/
		ctx.close();
		
	}
}
