package com.assessment.web.app.book.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(unique = true)
    private String id;
    private String author;
    private String title;
    private String isbn;

    public BookEntity(BookDTO bookDTO) {
        fromDto(bookDTO);
    }

    public void fromDto(BookDTO bookDTO) {
        BeanUtils.copyProperties(bookDTO, this);
    }

    public BookDTO toDto() {
        return new BookDTO(this);
    }

}
