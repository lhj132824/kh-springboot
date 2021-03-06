package com.kh.bookmanager.member;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate //변경이 감지된 속성만 쿼리에 반영해주는 어노테이션
@DynamicInsert //값이 null이 아닌 속성만 쿼리에 반영 - 없으면 입력하지 않은 값이 null로 가는데 오라클은 null을 정의되지 않은 '값'으로 처리해버림
public class Member {	
	
	@Id
	private String userId;
	private String password;
	private String email;
	private String grade;
	private String tell;
	@Column(columnDefinition = "date default sysdate")
	private Date rentableDate;
	@Column(columnDefinition = "date default sysdate")
	private LocalDateTime regDate;
	@Column(columnDefinition = "number default 0")
	private Boolean isLeave;

}
