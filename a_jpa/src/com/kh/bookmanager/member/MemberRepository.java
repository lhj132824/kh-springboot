package com.kh.bookmanager.member;

import java.util.List;

import javax.persistence.EntityManager;

public class MemberRepository {

	public List<Member> findAllMember(EntityManager em) {
		List<Member> members = em.createQuery("from Member",Member.class).getResultList(); //select m from Member m
		return members;
	}
	
}
