
package org.xanyook.xabook.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xanyook.xabook.exception.EntityNotFoundException;
import org.xanyook.xabook.service.IBookService;
import org.xanyook.xabook.service.model.BookToBeCreated;
import org.xanyook.xabook.service.model.GetBook;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "authors/{authorId}/books/" )
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation( value = "Create a new Book" )
    @PostMapping( path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseStatus( code = HttpStatus.CREATED )
    public GetBook createBook(
        // @formatter:off
            @PathVariable(name ="authorId") Long authorId,
            @RequestBody @NotNull BookToBeCreated bookToBeCreated
        // @formatter:on
    ) throws EntityNotFoundException {
        return bookService.createBook( authorId, bookToBeCreated );
    }

    @ApiOperation( value = "Delete book by ID" )
    @DeleteMapping( path = "{bookId}" )
    @ResponseStatus( code = HttpStatus.NO_CONTENT )
    public void deleteBook(
        // @formatter:off
            @PathVariable( name = "authorId" ) Long authorId,
            @PathVariable( name = "bookId" ) Long bookId
        // @formatter:on
    ) throws EntityNotFoundException {
        bookService.deleteBoook( authorId, bookId );
    }

    @GetMapping( path = "{bookId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseStatus( code = HttpStatus.OK )
    public GetBook getBook(
        // @formatter:off
            @PathVariable( name = "authorId" ) Long authorId,
            @PathVariable( name = "bookId" ) Long bookId
        // @formatter:on
    ) throws EntityNotFoundException {
        return bookService.getBook( authorId, bookId );

    }

}
