package com.kh.spring.querydsl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring.book.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QueryDSLTest {

	@Autowired
	private QueryDSLRepository queryDSLRepository;
	
	@Test
	@DisplayName("대출건 제목이 '디디'로 시작하고 대출자 ID가 test인 대출건을 조회")
	public void whereAnd() {
		queryDSLRepository.whereAnd("디디","test").forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("대출건 제목이 '디디'로 시작하거나 대출자 ID가 jpa인 대출건을 조회")
	public void whereOr() {
		queryDSLRepository.whereOr("디디","jpa").forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("대출도서등록일자와 도서등록일자가 일치하는 도서를 조회")
	public void fetchJoin() {
		queryDSLRepository.fetchJoin().forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("대출자의 아이디가 test인 모든 대출건의 대출건 제목과 대출번호 조회")
	public void projections() {
		queryDSLRepository.projections("test").forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("대출자의 아이디가 test인 모든 대출건의 대출건 제목과 대출번호 조회")
	public void tuple() {
		queryDSLRepository.tuple("test").forEach(e -> log.info(e.get(0, String.class)));
	}
	
	@Test
	@DisplayName("대출등록일자와 가입일자가 같은 회원이 존재하는 대출도서")
	public void thetaJoin() {
		queryDSLRepository.thetaJoin().forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("도서 재고 수량을 기준으로 내림차순으로 2권까지 조회")
	public void oderBy() {
		queryDSLRepository.oderBy().forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("카테고리별 도서들의 최대 재고, 평균 재고, 평균 대출 횟수")
	public void groupBy() {
		queryDSLRepository.groupBy().forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("대출도서의 상태가 '대출'인 대출도서가 한 권이라도 존재하는 회원을 조회")
	public void subQuery() {
		queryDSLRepository.subQuery().forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("도서 동적쿼리")
	public void dynamicQueryWithBook() {
		Book book = new Book();
		book.setBookAmt(2);
		book.setRentCnt(0);
		queryDSLRepository.dynamicQueryWithBook(book).forEach(e -> log.info(e.toString()));
	}
	
	@Test
	@DisplayName("회원 동적쿼리")
	public void dynamicQueryWithMember() {
		queryDSLRepository.dynamicQueryWithMember("test","010-1111-2222").forEach(e -> log.info(e.toString()));
	}
}
