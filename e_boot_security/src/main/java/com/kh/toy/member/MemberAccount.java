package com.kh.toy.member;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class MemberAccount extends User{

	private static final long serialVersionUID = 7202422839320957086L;
	private Member member;

	public MemberAccount(Member member) {
		super(member.getUserId()
				, member.getPassword()
				, List.of(new SimpleGrantedAuthority(member.getGrade())));
		this.member = member;
	}

	public Member getMember(Member member) {
		return member;
	}
	public String getEmail(Member member) {
		return member.getEmail();
	}
	public String getTell(Member member) {
		return member.getTell();
	}

}
