package com.kh.bookmanager.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kh.bookmanager.common.code.jpa.JpaTemplate;

public class BookService {

	private BookRepository bookRepository = new BookRepository();
	
	public List<Book> findBooksByTitle(String keyword) {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> books = new ArrayList<Book>();
		
		try {
			books = bookRepository.findBooksByTitle(em,keyword);
		} finally {
			em.close();
		}
		
		return books;
	}

	public List<Book> findBooksWithRank() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> books = new ArrayList<Book>();
		
		try {
			books = bookRepository.findBooksWithRank(em);
		} finally {
			em.close();
		}
		
		return books;
	}
	

	public List<Book> findAllBooks() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> books = new ArrayList<Book>();
		
		try {
			books = bookRepository.findAllBooks(em);
		} finally {
			em.close();
		}
		
		return books;
	}

	public boolean persistBook(Book registBook) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			em.persist(registBook);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return false;
	}

	public boolean modifyBook(Long bkIdx, String info) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Book book = em.find(Book.class, bkIdx);
			book.setInfo(info);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return false;
	}

	public boolean removeBook(Long bkIdx) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			em.remove(em.find(Book.class, bkIdx));
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
