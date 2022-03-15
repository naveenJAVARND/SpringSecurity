package com.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.Model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
