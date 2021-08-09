package com.assessment.web.app.book.data;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

}
