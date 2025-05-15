package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<Book> books = new CopyOnWriteArrayList<>();
	
	{
		books.add(new Book(1, "機器貓小叮噹", 12.5, 20, false));
		books.add(new Book(2, "老夫子", 10.5, 30, false));
		books.add(new Book(3, "好小子", 8.5, 40, true));
		books.add(new Book(4, "尼羅河的女兒", 14.5, 50, true));
	}
	
	public List<Book> findAllBooks(){
		return books;
	}

	public Optional<Book> getBookById(Integer id){
		return books.stream().filter(book -> book.getId().equals(id)).findFirst();
	}
	
	public boolean addBook(Book book) {
		OptionalInt optMaxId = books.stream().mapToInt(Book::getId).max();
		// 建立 newId
		int newId = optMaxId.isEmpty()?1:optMaxId.getAsInt()+1;
		// 將 newId 設定給 book
		book.setId(newId);
		
		return books.add(book);
	}
	
	public boolean updateBook(Integer id, Book book) {
		
		Optional<Book> optBook = getBookById(id);
		if(optBook.isEmpty()) {
			return false;
		}
		
		int index = books.indexOf(optBook.get());
		if(index == -1) {
			return false;
		}
		return books.set(id, book) != null;
	}
	
	public boolean deleteBook(Integer id) {
		Optional<Book> optBook = getBookById(id);
		if(optBook.isPresent()) {
			return books.remove(optBook.get());
		}	
		
		return false;
	}
}
