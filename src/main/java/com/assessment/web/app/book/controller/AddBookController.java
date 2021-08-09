package com.assessment.web.app.book.controller;

import com.assessment.web.app.book.BooksService;
import com.assessment.web.app.book.data.BookDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AddBookController implements WebMvcConfigurer {

    private final BooksService booksService;

    @GetMapping("/add-book")
    public String get(BookDTO bookDTO) {
        return "add_book";
    }

    @PostMapping("/add-book")
    public String addBook(@Valid BookDTO bookDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.info("Posted invalid book.");
            return "add_book";
        }

        booksService.addBook(bookDTO);
        return "redirect:/";
    }
}
