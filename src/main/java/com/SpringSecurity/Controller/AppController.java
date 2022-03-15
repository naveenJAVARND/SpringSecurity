package com.SpringSecurity.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SpringSecurity.Model.Book;
import com.SpringSecurity.Service.BookService;




@EnableResourceServer
@RestController
@RequestMapping("/book")
public class AppController {
	
	@Autowired
	private BookService bookService;

	@GetMapping(value = "/list")
	public List<Book> viewHomePage(Model model) {
		List<Book> listProducts = bookService.listAll();
		

		return listProducts;
	}

	@PostMapping("/new")
	public String showNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);

		return "new_product";
	}

	@PostMapping(value = "/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.save(book);

		return "Book Added";
	}

	@PutMapping(value = "/edit/{id}")
	public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_book");

		Book book = bookService.get(id);
		mav.addObject("book", book);

		return mav;
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable(name = "id") Long id) {
		bookService.delete(id);

		return "Book Deleted";
	}

	
}
