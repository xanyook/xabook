package org.xanyook.xabook.service.model;

import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

public class GetBook {

    private String       description;
    private Long         id;
    private String       isbn;
    private String       title;
    private BookTypeEnum type;

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
