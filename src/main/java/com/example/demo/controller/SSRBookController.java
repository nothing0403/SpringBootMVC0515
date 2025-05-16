package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exception.BookException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/ssr/book")
public class SSRBookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	// 首頁進入點
	// 查詢所有書籍
	public String findAllBooks(Model model) {
		List<Book> books = bookService.findAllBooks();
		model.addAttribute("books", books); // 將要傳遞給 JSP 的資料放入 Model 容器中 (等於 request.setAttribute("books", book))
		return "book_list"; // 對應到 /WEB-INF/view/book_list.jsp
	}
	
	@PostMapping("/add")
	public String addBook(Book book, Model model) {
		// model 是由 Spring 提供，能用來存取物件(items)並傳遞給JSP
		try {
			bookService.addBook(book);
		} catch (BookException e) {
			model.addAttribute("message", "新增錯誤: " + e.getMessage());
			return "error";
		}
		return "redirect:/ssr/book";
		// 回導到 findAllBooks 去顯示 books 的內容
		//return "redirect:http://localhost:8080/ssr/book";
		//return "redirect:https://tw.yahoo.com";
	}
	
	//@PostMapping("/delete/{id}")
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id, Model model) {
		try {
			bookService.deleteBook(id);
		} catch (BookException e) {
			model.addAttribute("message", "刪除錯誤: " + e.getMessage());
			return "error";
		}
		return "redirect:/ssr/book";
	}
	
	@GetMapping("/edit/{id}")
	public String getEditPage(@PathVariable Integer id, Model model) {
		try {
			Book book = bookService.getBookById(id);
			model.addAttribute("book", book);
			return "book_edit";
		} catch (BookException e) {
			model.addAttribute("message", "查無該筆書籍資料: " + e.getMessage());
			return "error";
		}
	}
	
	// 修改書籍
	@PostMapping("/edit/{id}")
	public String editBook(@PathVariable Integer id, Book book, Model model) {
		try {
			bookService.updateBook(id, book);
		} catch (BookException e) {
			model.addAttribute("message", "修改錯誤: " + e.getMessage());
			return "error";
		}
		return "redirect:/ssr/book";
	}
}
