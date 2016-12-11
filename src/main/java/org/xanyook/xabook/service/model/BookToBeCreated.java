package org.xanyook.xabook.service.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.xanyook.xabook.model.util.enumeration.BookTypeEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Book to be created" )
public class BookToBeCreated implements Serializable {

    private static final long serialVersionUID = -6426264746262115496L;

    private String            description;
    @NotBlank
    private String            isbn;
    @NotBlank
    private String            title;
    @NotBlank
    private BookTypeEnum      type;

    @ApiModelProperty( value = Documentation.BOOK_DESCRIPTION_DESCRIPTION, required = true )
    public String getDescription() {
        return description;
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
