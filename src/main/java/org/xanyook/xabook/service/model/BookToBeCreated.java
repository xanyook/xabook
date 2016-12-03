package org.xanyook.xabook.service.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

public class BookToBeCreated implements Serializable {

    private static final long serialVersionUID = -6426264746262115496L;

    private String            description;
    @NotBlank
    private String            isbn;
    @NotBlank
    private String            title;
    @NotBlank
    private BookTypeEnum      type;

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public BookTypeEnum getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(BookTypeEnum type) {
        this.type = type;
    }

}
