package org.xanyook.xabook.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

import java.io.Serializable;

@ApiModel( value = "Book" )
public class GetBook implements Serializable {

    private static final long serialVersionUID = -5414514266267836349L;

    private String            description;
    private Long bookId;
    private String            isbn;
    private String            title;
    private BookTypeEnum      type;

    @ApiModelProperty( value = Documentation.BOOK_DESCRIPTION_DESCRIPTION, required = true )
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ApiModelProperty( value = Documentation.BOOK_ID_DESCRIPTION, required = true )
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @ApiModelProperty( value = Documentation.BOOK_ISBN_DESCRIPTION, required = true )
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @ApiModelProperty( value = Documentation.BOOK_TITTLE_DESCRIPTION, required = true )
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ApiModelProperty( value = Documentation.BOOK_TYPE_DESCRIPTION, required = true )
    public BookTypeEnum getType() {
        return type;
    }

    public void setType(BookTypeEnum type) {
        this.type = type;
    }

}
