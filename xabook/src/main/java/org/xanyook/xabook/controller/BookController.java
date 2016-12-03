
package org.xanyook.xabook.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.IBookService;
import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.GetBook;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( path = "authors/{authorId}/books/", produces = MediaType.APPLICATION_JSON_VALUE )
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation( value = "Create a new Book" )
    @RequestMapping( method = RequestMethod.POST, path = "", consumes = MediaType.APPLICATION_JSON_VALUE )
    public GetBook createBook(
        // @formatter:off
            @PathVariable(name ="authorId") Long authorId,
            @RequestBody @NotNull BookToBeCreated bookToBeCreated
        // @formatter:on
    ) throws EntityNotFoundException {
        return bookService.createBook( authorId, bookToBeCreated );
    }

    @ApiOperation( value = "Delete book by ID" )
    @RequestMapping( method = RequestMethod.DELETE, path = "{bookId}" )
    public void deleteBook(
            // @formatter:off
            @PathVariable( name = "authorId" ) Long authorId,
            @PathVariable( name = "bookId" ) Long bookId
            // @formatter:on
    ) throws EntityNotFoundException {
        bookService.deleteBoook( authorId, bookId );
    }

}
