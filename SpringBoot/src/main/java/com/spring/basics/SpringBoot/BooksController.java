package com.spring.basics.SpringBoot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	
	@GetMapping("/books")
	public List<Book> allBooks() {
//		List<Book> books = new ArrayList<Book>();
	
		return Arrays.asList(new Book(1l, "Bookname", "BookAuthor"));
		
	}
}
