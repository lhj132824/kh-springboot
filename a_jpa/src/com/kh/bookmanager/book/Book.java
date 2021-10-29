package com.kh.bookmanager.book;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.bookmanager.member.Member;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Book {
	
	@Id
	@GeneratedValue
	private Long bkIdx;
	private String isbn;
	private String category;
	private String title;
	private String author;
	private String info;
	@Column(columnDefinition = "number default 1")
	private Integer bookAmt;
	@Column(columnDefinition = "date default sysdate")
	private Date regDate;
	@Column(columnDefinition = "number default 0")
	private Integer rentCnt;
	
}