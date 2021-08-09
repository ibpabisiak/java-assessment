package com.assessment.web.app.book;

import com.assessment.web.app.book.data.BookDTO;
import com.assessment.web.app.book.data.BookEntity;
import com.assessment.web.app.book.data.BookRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository bookRepository;

    public void addBook(BookDTO bookDTO) {
        log.info("Adding a new record to {} in database.", BookEntity.class.getName());
        bookRepository.save(bookDTO.toEntity());
    }

    public List<BookDTO> getBooks() {
        log.info("Loading all {} records from database.", BookEntity.class.getName());
        return bookRepository.findAll().stream().map(BookDTO::new).collect(Collectors.toList());
    }

    public void deleteAllEntities() {
        log.info("Deleting all records from {} in database.", BookEntity.class.getName());
        bookRepository.deleteAll();
    }
}
