package com.SpringSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringSecurity.Model.Book;
import com.SpringSecurity.Repository.BookRepository;







@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> listAll() {		
		return repository.findAll();
	}
	
	public void save(Book book) {
		repository.save(book);
	}
	
	public Book get(Long id) {
		return repository.findById(id).get();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
