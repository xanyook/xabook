package org.xanyook.xabook.service.model;

import java.io.Serializable;

import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Book" )
public class GetBook implements Serializable {

    private static final long serialVersionUID = -5414514266267836349L;

    private String            description;
    private Long              id;
    private String            isbn;
    private String            title;
    private BookTypeEnum      type;

    @ApiModelProperty( value = Documentation.BOOK_DESCRIPTION_DESCRIPTION, required = true )
    public String getDescription() {
        return description;
    }

    @ApiModelProperty( value = Documentation.BOOK_ID_DESCRIPTION, required = true )
    public Long getId() {
        return id;
    }

    @ApiModelProperty( value = Documentation.BOOK_ISBN_DESCRIPTION, required = true )
    public String getIsbn() {
        return isbn;
    }

    @ApiModelProperty( value = Documentation.BOOK_TITTLE_DESCRIPTION, required = true )
    public String getTitle() {
        return title;
    }

    @ApiModelProperty( value = Documentation.BOOK_TYPE_DESCRIPTION, required = true )
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
