package com.assessment.web.app.book.controller;

import com.assessment.web.app.book.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequiredArgsConstructor
public class BooksListController implements WebMvcConfigurer {

    private final BooksService booksService;

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", booksService.getBooks());
        return "book_list";
    }

    @GetMapping("/clear")
    public String clearDatabase() {
        booksService.deleteAllEntities();
        return "book_list";
    }
}
