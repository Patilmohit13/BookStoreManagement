package com.bookmgm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookmgm.entity.bookstore;
import com.bookmgm.repository.bookRepository;

@Controller
@RequestMapping("/books/")
public class Bookcontroller {

	@Autowired
	private bookRepository bookrepository;

	@GetMapping("Showform")
	public String ShowBookform() {
		return "add-book";
	}

	@GetMapping("List")
	public String books(Model model) {
		model.addAttribute(books(model), this.bookrepository.findAll());
		return "index";
	}

	@PostMapping("Add")
	public String Addbooks(@Validated bookstore books, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-books";
		}
		this.bookrepository.save(books);
		return "Redirect:List";
	}

	@GetMapping("edit/{Bid}")
	public String showupdateform(@PathVariable("Bid") Integer Bid, Model model) {
		bookstore books = this.bookrepository.findById(Bid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Book id : " + Bid));
		model.addAttribute("books", books);
		return "update-book";

	}

	@GetMapping("update/{Bid}")
	public String Updatebooks(@PathVariable("Bid") Integer Bid, @Validated bookstore books, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			books.setBid(Bid);
			return "update-books";
		}

		// Updating Books
		bookrepository.save(books);
		// Get Details Of All Books (After update)
		model.addAttribute("books", this.bookrepository.findAll());
		return "index";

	}

	@DeleteMapping("delete/{id}")
	public String deletebooks(@PathVariable("Bid") Integer Bid, Model model) {
		bookstore books = this.bookrepository.findById(Bid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Book id : " + Bid));
		model.addAttribute("books", books);

		this.bookrepository.delete(books);
		model.addAttribute("books", this.bookrepository.findAll());
		return "index";

	}
}
