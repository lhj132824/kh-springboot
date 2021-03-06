package com.kh.bookmanager.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kh.bookmanager.common.code.jpa.JpaTemplate;

public class MemberService {

	private MemberRepository memberRepository = new MemberRepository();
	
	public Member memberAuthenticate(String userId, String password) {
		
		EntityManager em = JpaTemplate.createEntityManager();
		//find() : 조회
		try {
			Member member = em.find(Member.class, userId); //클래스 , 프라이머리 키
			if(member == null) return null;
			if(member.getPassword().equals(password)) return member;
		}finally {
			em.close();
		}
		return null;
	}

	public Member findMemberById(String userId) {
		EntityManager em = JpaTemplate.createEntityManager();
		Member member = null;
		try {
			member = em.find(Member.class, userId);
		} finally {
			em.close();
		}
		return member;
	}
	
	public List<Member> findAllMember() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Member> members = new ArrayList<Member>();
		try {
			members = memberRepository.findAllMember(em);
		} finally {
			em.close();
		}
		return members;
	}

	public int persistMember(Member member) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int res = 0;
		
		try {
			em.persist(member);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return res;
	}

	public int modifyMember(Member member) {
		EntityManager em = JpaTemplate.createEntityManager();
		//dml은 트랜잭션 관리가 필요함
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int res = 0;
		
		try {
			Member memberEntity = em.find(Member.class, member.getUserId());
			memberEntity.setPassword(member.getPassword());
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return res;
	}

	public int removeMember(String userId) {
		EntityManager em = JpaTemplate.createEntityManager();
		//dml은 트랜잭션 관리가 필요함
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int res = 0;
		
		try {
			Member member = em.find(Member.class, userId);
			em.remove(member);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return res;
	}

	
	
	
	
	
	
	
	
	
	

}
