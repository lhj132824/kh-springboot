package com.kh.spring.rent;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.kh.spring.book.Book;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@ToString(exclude = "rent")
public class RentBook {

	@Id
	@GeneratedValue
	private Long rbIdx;
	@ManyToOne
	@JoinColumn(name = "bkIdx")
	private Book book;
	
	//양방향
	@ManyToOne
	@JoinColumn(name = "rmIdx")
	private Rent rent;
	
	@Column(columnDefinition = "date default sysdate")
	private LocalDateTime regDate;
	private String state;
	@Column(columnDefinition = "date default sysdate+7")
	private LocalDateTime returnDate;
	@Column(columnDefinition = "number default 0")
	private Integer extensionCnt;

	public void changeRent(Rent rent) {
		this.rent = rent;
		rent.getRentBooks().add(this);
	}
}
