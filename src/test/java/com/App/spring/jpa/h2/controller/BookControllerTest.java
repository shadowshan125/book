package com.App.spring.jpa.h2.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.App.spring.jpa.h2.model.Book;
import com.App.spring.jpa.h2.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

	@InjectMocks
	BookController bookController;

	@Mock
	BookRepository bookRepository;

	@Test
	public void testCreateBook() {

		Book book = new Book();
		book.setTitle("new Book");
		book.setDescription("book about me");
		book.setPublished(true);

		when(bookRepository.save(any(Book.class))).thenReturn(book);
			
		Book bookTest = new Book("new Book","book about me",true);
		ResponseEntity<Book> responseEntity = bookController.createBook(bookTest);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(200);
	}

}
