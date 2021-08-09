package com.assessment.web.app.book.data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String id;
    @NotEmpty(message = "Author field cannot be empty.")
    @Pattern(regexp = "^[A][a-zA-Z].*$", message = "Author forename and surname must starts with letter 'A'.")
    private String author;
    @NotEmpty(message = "Title cannot be empty.")
    private String title;
    @NotEmpty(message = "ISBN cannot be empty.")
    private String isbn;

    public BookDTO(BookEntity bookEntity) {
        fromEntity(bookEntity);
    }

    public void fromEntity(BookEntity bookEntity) {
        BeanUtils.copyProperties(bookEntity, this);
    }

    public BookEntity toEntity() {
        return new BookEntity(this);
    }
}
